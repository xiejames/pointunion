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
 * This file creation date: 25/08/2004 23:32:20
 * The JForum Project
 * http://www.jforum.net
 */
package net.jforum;

import java.sql.Connection;
import java.sql.DriverManager;

import net.jforum.exceptions.DatabaseException;
import net.jforum.util.preferences.ConfigKeys;
import net.jforum.util.preferences.SystemGlobals;

/**
 * Non-pooled connection implementation.
 * This class will ask a new conneciton to the database on every
 * <code>getConnection()</code> class. Uses of this class include
 * systems where a connection pool is not permited or the 
 * connections' life time is too short, not justifying to have
 * a connection pool.
 * 
 * @author Rafael Steil
 * @version $Id: SimpleConnection.java,v 1.1 2006/08/25 15:12:18 jack Exp $
 */
public class SimpleConnection extends DBConnection 
{
	/** 
	 * @see net.jforum.Connection#init()
	 */
	public void init() throws Exception 
	{
		try {
			Class.forName(SystemGlobals.getValue(ConfigKeys.DATABASE_CONNECTION_DRIVER));
			
			// Try to validate the connection url
			Connection conn = this.getConnection();
			if (conn != null) {
				this.releaseConnection(conn);
			}
			
			this.isDatabaseUp = true;
		}
		catch (Exception e) {
			this.isDatabaseUp = false;
			throw e;
		}
	}

	/** 
	 * @see net.jforum.Connection#getConnection()
	 */
	public Connection getConnection()
	{
		try {
			return DriverManager.getConnection(SystemGlobals.getValue(ConfigKeys.DATABASE_CONNECTION_STRING));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException(e);
		}
	}

	/** 
	 * @see net.jforum.Connection#releaseConnection(java.sql.Connection)
	 */
	public void releaseConnection(Connection conn)
	{
		try {
			conn.close();
		}
		catch (Exception e) {}
	}
	
	/** 
	 * @see net.jforum.DBConnection#realReleaseAllConnections()
	 */
	public void realReleaseAllConnections() throws Exception {}
}
