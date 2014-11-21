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
 * Created on 24/05/2004 / 12:04:11
 * The JForum Project
 * http://www.jforum.net
 */
package net.jforum.dao.oracle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import net.jforum.JForumExecutionContext;
import net.jforum.entities.Post;
import net.jforum.util.preferences.SystemGlobals;

/**
 * @author Dmitriy Kiriy
 * @version $Id: OraclePostDAO.java,v 1.1 2006/08/25 15:12:44 jack Exp $
 */
public class OraclePostDAO extends net.jforum.dao.generic.GenericPostDAO
{
	/**
	 * @see net.jforum.dao.generic.GenericPostDAO#addNewPostText(net.jforum.entities.Post)
	 */
	protected void addNewPostText(Post post) throws Exception
	{
		PreparedStatement p = JForumExecutionContext.getConnection().prepareStatement(SystemGlobals.getSql("PostModel.addNewPostText"));
		p.setInt(1, post.getId());
		p.setString(2, post.getSubject());
		p.executeUpdate();
		p.close();
		
		OracleUtils.writeBlobUTF16BinaryStream(
				SystemGlobals.getSql("PostModel.addNewPostTextField"),
				post.getId(), post.getText()
			);
	}
	
	/**
	 * @see net.jforum.dao.generic.GenericPostDAO#updatePostsTextTable(net.jforum.entities.Post)
	 */
	protected void updatePostsTextTable(Post post) throws Exception
	{
		PreparedStatement p = JForumExecutionContext.getConnection().prepareStatement(SystemGlobals.getSql("PostModel.updatePostText"));
		p.setString(1, post.getSubject());
		p.setInt(2, post.getId());
		
		p.executeUpdate();
		p.close();
		
		OracleUtils.writeBlobUTF16BinaryStream(
			SystemGlobals.getSql("PostModel.addNewPostTextField"),
			post.getId(), post.getText()
		);
	}
	
	/**
	 * @see net.jforum.dao.generic.GenericPostDAO#getPostTextFromResultSet(java.sql.ResultSet)
	 */
	protected String getPostTextFromResultSet(ResultSet rs) throws Exception
	{
		return OracleUtils.readBlobUTF16BinaryStream(rs, "post_text");
	}

    /**
	 * @see net.jforum.dao.PostDAO#selectAllByTopicByLimit(int, int, int)
	 */
	public List selectAllByTopicByLimit(int topicId, int startFrom, int count) throws Exception
	{
		return super.selectAllByTopicByLimit(topicId, startFrom, startFrom + count);
	}
	
	/**
	 * @see net.jforum.dao.PostDAO#selectByUserByLimit(int, int, int)
	 */
	public List selectByUserByLimit(int userId,int startFrom, int count) throws Exception
	{
		return super.selectByUserByLimit(userId, startFrom, startFrom + count);
	}
}
