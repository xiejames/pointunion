/*
 * Copyright (c) Rafael Steil
 * All rights reserved.

 * Redistribution and use in source and binary forms,
 * with or without modification, are permitted provided
 * that the following conditions are met:

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
 * Created on 24/05/2004 17:40:25
 * The JForum Project
 * http://www.jforum.net
 */
package net.jforum.dao.generic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.jforum.JForumExecutionContext;
import net.jforum.util.preferences.ConfigKeys;
import net.jforum.util.preferences.SystemGlobals;

/**
 * @author Rafael Steil
 * @version $Id: AutoKeys.java,v 1.1 2006/08/25 15:12:47 jack Exp $
 */
public class AutoKeys
{
	private static boolean supportAutoGeneratedKeys = SystemGlobals.getBoolValue(ConfigKeys.DATABASE_AUTO_KEYS);
	private String autoGeneratedKeysQuery;
	
	protected boolean supportAutoGeneratedKeys()
	{
		return supportAutoGeneratedKeys;
	}

	/**
	 * Query to execute when {@link #setSupportAutoGeneratedKey(boolean)} is set
	 * to <code>false</code>
	 * @param query The query to execute to retreive the last generated key
	 */
	protected void setAutoGeneratedKeysQuery(String query)
	{
		this.autoGeneratedKeysQuery = query;
	}
	
	protected String getAutoGeneratedKeysQuery()
	{
		return this.autoGeneratedKeysQuery;
	}
	
	protected String getErrorMessage()
	{
		return "Could not obtain the latest generated key. This error may be associated"
			+" to some invalid database driver operation or server failure."
			+" Please check the database configurations and code logic.";
	}
	
	protected PreparedStatement getStatementForAutoKeys(String queryName, Connection conn) throws SQLException
	{
		PreparedStatement p = null;
		if (this.supportAutoGeneratedKeys()) {
			p = conn.prepareStatement(SystemGlobals.getSql(queryName),
				Statement.RETURN_GENERATED_KEYS);
		}
		else {
			p = conn.prepareStatement(SystemGlobals.getSql(queryName));
		}
		
		return p;
	}
	
	protected PreparedStatement getStatementForAutoKeys(String queryName) throws SQLException
	{
		return this.getStatementForAutoKeys(queryName, JForumExecutionContext.getConnection());
	}
	
	protected int executeAutoKeysQuery(PreparedStatement p) throws SQLException
	{
		return this.executeAutoKeysQuery(p, JForumExecutionContext.getConnection());
	}
	
	protected int executeAutoKeysQuery(PreparedStatement p, Connection conn) throws SQLException
	{
		int id = -1;
		p.executeUpdate();
		
		if (this.supportAutoGeneratedKeys()) {
			ResultSet rs = p.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
		}
		else {
			p = conn.prepareStatement(this.getAutoGeneratedKeysQuery());
			ResultSet rs = p.executeQuery();
			
			if (rs.next()) {
				id = rs.getInt(1);
			}
			
			rs.close();
		}
	
		boolean valid = true;
		if (id == -1) {
			valid = false;
		}
		
		if (!valid) {
			throw new SQLException(this.getErrorMessage());
		}
		
		return id;
	}
}
