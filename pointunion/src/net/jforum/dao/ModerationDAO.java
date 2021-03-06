/*
 * Copyright (c) 2003, Rafael Steil
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
 * Created on Jan 30, 2005 11:32:49 AM
 * The JForum Project
 * http://www.jforum.net
 */
package net.jforum.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Rafael Steil
 * @version $Id: ModerationDAO.java,v 1.1 2006/08/25 15:13:01 jack Exp $
 */
public interface ModerationDAO
{
	/**
	 * Approves a post.
	 * 
	 * @param postId The post id to aprove
	 * @throws Exception
	 */
	public void aprovePost(int postId) throws Exception;
	/**
	 * Gets all messages that need moderation.
	 * 
	 * @param forumId The forum id to search for messages
	 * to mdoerate
	 * @return A map instance where the key is the topic id and the value is 
	 * a TopicModerationInfo instance.
	 * @throws Exception
	 */
	public Map topicsByForum(int forumId) throws Exception;
	
	/**
	 * Gets information about which categories and
	 * foruns have posts to moderate.
	 * 
	 * @return a list instance where each entry is a
	 * ModerationPendingInfo instance.
	 * @throws Exception
	 */
	public List categoryPendingModeration() throws Exception;
}
