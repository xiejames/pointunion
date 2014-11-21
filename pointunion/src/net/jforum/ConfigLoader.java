/*
 * Copyright (c) Rafael Steil
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, 
 * with or without modification, are permitted provided 
 * that the following conditions are met:
 * 
 * 1) Redistributions of source code must retain the above 
 * copyright notice, this list of conditions and the 
 * following  disclaimer.
 * 2)  Redistributions in binary form must reproduce the 
 * above copyright notice, this list of conditions and 
 * the following disclaimer in the documentation and/or 
 * other materials provided with the distribution.
 * 3) Neither the name of "Rafael Steil" nor 
 * the names of its contributors may be used to endorse 
 * or promote products derived from this software without 
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT 
 * HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, 
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL 
 * THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE 
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, 
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE
 * 
 * Created on 02/11/2004 12:45:37
 * The JForum Project
 * http://www.jforum.net
 */
package net.jforum;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import net.jforum.cache.CacheEngine;
import net.jforum.cache.Cacheable;
import net.jforum.dao.DataAccessDriver;
import net.jforum.exceptions.CacheEngineStartupException;
import net.jforum.summary.SummaryScheduler;
import net.jforum.util.FileMonitor;
import net.jforum.util.preferences.ConfigKeys;
import net.jforum.util.preferences.QueriesFileListener;
import net.jforum.util.preferences.SystemGlobals;
import net.jforum.util.preferences.SystemGlobalsListener;
import net.jforum.util.search.SearchFacade;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

/**
 * General utilities methods for loading configurations for JForum.
 * 
 * @author Rafael Steil
 * @version $Id: ConfigLoader.java,v 1.1 2006/08/25 15:12:19 jack Exp $
 */
public class ConfigLoader 
{
	private static final Logger logger = Logger.getLogger(ConfigLoader.class);
	private static CacheEngine cache;
	
	/**
	 * Start ( or restart ) <code>SystemGlobals</code>.
	 * This method loads all configuration keys set at
	 * <i>SystemGlobals.properties</i>, <i>&lt;user.name&gt;.properties</i>
	 * and database specific stuff.
	 * 
	 * @param appPath The application root's directory
	 * @throws Exception
	 */
	public static void startSystemglobals(String appPath) throws Exception
	{
		SystemGlobals.initGlobals(appPath, appPath + "/WEB-INF/config/SystemGlobals.properties");
		SystemGlobals.loadAdditionalDefaults(SystemGlobals.getValue(ConfigKeys.DATABASE_DRIVER_CONFIG));
		
		if (new File(SystemGlobals.getValue(ConfigKeys.INSTALLATION_CONFIG)).exists()) {
			SystemGlobals.loadAdditionalDefaults(SystemGlobals.getValue(ConfigKeys.INSTALLATION_CONFIG));
		}
	}

	/**
	 * Loads module mappings for the system.
	 * 
	 * @param baseConfigDir The directory where the file <i>modulesMapping.properties</i> is.
	 * @return The <code>java.util.Properties</code> instance, with the loaded modules 
	 * @throws IOException
	 */
	public static Properties loadModulesMapping(String baseConfigDir) throws IOException
	{
		Properties modulesMapping = new Properties();
		modulesMapping.load(new FileInputStream(baseConfigDir + "/modulesMapping.properties"));
		
		return modulesMapping;
	}
	
	/**
	 * Load url patterns.
	 * The method tries to load url patterns from <i>WEB-INF/config/urlPattern.properties</i>
	 * 
	 * @throws IOException
	 */
	public static void loadUrlPatterns() throws IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(SystemGlobals.getValue(ConfigKeys.CONFIG_DIR)
			+ "/urlPattern.properties"));

		Iterator iter = p.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();

			ActionServletRequest.addUrlPattern((String)entry.getKey(), (String)entry.getValue());
        }
    }
	
	/**
	 * Listen for changes in common configuration files.
	 * The watched files are: <i>generic_queries.sql</i>, 
	 * <i>&lt;database_name&gt;.sql</i>, <i>SystemGlobals.properties</i>
	 * and <i>&lt;user.name&gt;.properties</i>
	 */
	public static void listenForChanges()
	{
		int fileChangesDelay = SystemGlobals.getIntValue(ConfigKeys.FILECHANGES_DELAY);
		
		if (fileChangesDelay > 0) {
			// Queries
			FileMonitor.getInstance().addFileChangeListener(new QueriesFileListener(),
					SystemGlobals.getValue(ConfigKeys.SQL_QUERIES_GENERIC), fileChangesDelay);

			FileMonitor.getInstance().addFileChangeListener(new QueriesFileListener(),
					SystemGlobals.getValue(ConfigKeys.SQL_QUERIES_DRIVER), fileChangesDelay);

			// System Properties
			FileMonitor.getInstance().addFileChangeListener(new SystemGlobalsListener(),
					SystemGlobals.getValue(ConfigKeys.DEFAULT_CONFIG), fileChangesDelay);

			ConfigLoader.listenInstallationConfig();
        }
	}
	
	public static void listenInstallationConfig()
	{
		int fileChangesDelay = SystemGlobals.getIntValue(ConfigKeys.FILECHANGES_DELAY);
		
		if (fileChangesDelay > 0) {
			if (new File(SystemGlobals.getValue(ConfigKeys.INSTALLATION_CONFIG)).exists()) {
				FileMonitor.getInstance().addFileChangeListener(new SystemGlobalsListener(),
						SystemGlobals.getValue(ConfigKeys.INSTALLATION_CONFIG), fileChangesDelay);
			}
		}
	}
	
	public static void loadDaoImplementation() throws Exception
	{

        // Start the dao.driver implementation
        String driver = SystemGlobals.getValue(ConfigKeys.DAO_DRIVER);
        
        logger.info("Loading JDBC driver " + driver);
        
        Class c = Class.forName(driver);
        DataAccessDriver d = (DataAccessDriver)c.newInstance();
        DataAccessDriver.init(d);
	}
	
	public static void startCacheEngine()
	{
		try {
			String cacheImplementation = SystemGlobals.getValue(ConfigKeys.CACHE_IMPLEMENTATION);
			logger.info("Using cache engine: " + cacheImplementation);
			
			cache = (CacheEngine)Class.forName(cacheImplementation).newInstance();
			cache.init();
			
			String s = SystemGlobals.getValue(ConfigKeys.CACHEABLE_OBJECTS);
			if (s == null || s.trim().equals("")) {
				logger.warn("Cannot find Cacheable objects to associate the cache engine instance.");
				return;
			}
			
			String[] cacheableObjects = s.split(",");
			for (int i = 0; i < cacheableObjects.length; i++) {
				logger.info("Creating an instance of " + cacheableObjects[i]);
				Object o = Class.forName(cacheableObjects[i].trim()).newInstance();
				
				if (o instanceof Cacheable) {
					((Cacheable)o).setCacheEngine(cache);
				}
				else {
					logger.error(cacheableObjects[i] + " is not an instance of net.jforum.cache.Cacheable");
				}
			}
		}
		catch (Exception e) {
			throw new CacheEngineStartupException("Error while starting the cache engine", e);
		}
	}
	
	public static void stopCacheEngine()
	{
		if (cache != null) {
			cache.stop();
		}
	}
	
	public static void startSearchIndexer()
	{
		SearchFacade.init();
	}

	/**
	 * Init a Job who will send e-mails to the all users with a summary of posts...
	 * @throws SchedulerException
	 * @throws IOException
	 */
	public static void startSummaryJob() throws SchedulerException, IOException {
		SummaryScheduler.startJob();
	}
}
