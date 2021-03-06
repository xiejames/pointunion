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
 * This file creation date: 15/08/2003 / 20:56:33
 * The JForum Project
 * http://www.jforum.net
 */
package net.jforum.view.admin;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import net.jforum.ActionServletRequest;
import net.jforum.entities.Category;
import net.jforum.entities.Forum;
import net.jforum.repository.ForumRepository;
import net.jforum.repository.TopicRepository;
import net.jforum.util.I18n;
import net.jforum.util.preferences.ConfigKeys;
import net.jforum.util.preferences.SystemGlobals;
import net.jforum.util.preferences.TemplateKeys;
import freemarker.template.SimpleHash;

/**
 * @author Rafael Steil
 * @version $Id: ConfigAction.java,v 1.1 2006/08/25 15:12:22 jack Exp $
 */
public class ConfigAction extends AdminCommand 
{
	public ConfigAction() {}
	
	public ConfigAction(ActionServletRequest request, 
			HttpServletResponse response, 
			SimpleHash context)
	{
		this.request = request;
		this.response = response;
		this.context = context;
	}
	
	public void list() throws Exception {
		Properties p = new Properties();
		Iterator iter = SystemGlobals.fetchConfigKeyIterator();

		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = SystemGlobals.getValue(key);
			p.put(key, value);
		}

		Properties locales = new Properties();
		locales.load(new FileInputStream(SystemGlobals.getValue(ConfigKeys.CONFIG_DIR)
						+ "/languages/locales.properties"));
		List localesList = new ArrayList();

		for (Enumeration e = locales.keys(); e.hasMoreElements();) {
			localesList.add(e.nextElement());
		}

		this.context.put("config", p);
		this.context.put("locales", localesList);
		this.setTemplateName(TemplateKeys.CONFIG_LIST);
	}

	public void editSave() throws Exception 
	{
		this.updateData(this.getConfig());
		this.list();
	}
	
	Properties getConfig()
	{
		Properties p = new Properties();

		Enumeration e = this.request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();

			if (name.startsWith("p_")) {
				p.setProperty(name.substring(name.indexOf('_') + 1), this.request.getParameter(name));
			}
		}
		
		return p;
	}
	
	void updateData(Properties p) throws Exception
	{
		int oldTopicsPerPage = SystemGlobals.getIntValue(ConfigKeys.TOPICS_PER_PAGE);

		for (Iterator iter = p.entrySet().iterator(); iter.hasNext(); ) {
			Map.Entry entry = (Map.Entry)iter.next();
			
			SystemGlobals.setValue((String)entry.getKey(), (String)entry.getValue());
		}
		
		SystemGlobals.saveInstallation();
		I18n.changeBoardDefault(SystemGlobals.getValue(ConfigKeys.I18N_DEFAULT));
		
		// If topicsPerPage has changed, force a reload in all forums
		if (oldTopicsPerPage != SystemGlobals.getIntValue(ConfigKeys.TOPICS_PER_PAGE)) {
			List categories = ForumRepository.getAllCategories();
			
			for (Iterator iter = categories.iterator(); iter.hasNext(); ) {
				Category c = (Category)iter.next();
				
				for (Iterator iter2 = c.getForums().iterator(); iter2.hasNext(); ) {
					Forum f = (Forum)iter2.next();
					TopicRepository.clearCache(f.getId());
				}
			}
		}
	}
}