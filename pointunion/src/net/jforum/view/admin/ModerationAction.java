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
 * Created on Jan 30, 2005 2:49:29 PM
 * The JForum Project
 * http://www.jforum.net
 */
package net.jforum.view.admin;

import net.jforum.ActionServletRequest;
import net.jforum.dao.DataAccessDriver;
import net.jforum.dao.PostDAO;
import net.jforum.dao.TopicDAO;
import net.jforum.dao.UserDAO;
import net.jforum.entities.Post;
import net.jforum.entities.Topic;
import net.jforum.entities.User;
import net.jforum.repository.ForumRepository;
import net.jforum.repository.PostRepository;
import net.jforum.repository.TopicRepository;
import net.jforum.util.preferences.ConfigKeys;
import net.jforum.util.preferences.SystemGlobals;
import net.jforum.util.preferences.TemplateKeys;
import net.jforum.view.forum.common.AttachmentCommon;
import net.jforum.view.forum.common.PostCommon;
import net.jforum.view.forum.common.TopicsCommon;
import freemarker.template.SimpleHash;

/**
 * @author Rafael Steil
 * @version $Id: ModerationAction.java,v 1.1 2006/08/25 15:12:22 jack Exp $
 */
public class ModerationAction extends AdminCommand
{
	public ModerationAction() {}
	
	public ModerationAction(SimpleHash context, ActionServletRequest request)
	{
		this.context = context;
		this.request = request;
	}
	
	/**
	 * @see net.jforum.Command#list()
	 */
	public void list() throws Exception
	{
		this.setTemplateName(TemplateKeys.MODERATION_ADMIN_LIST);
		this.context.put("infoList", DataAccessDriver.getInstance().newModerationDAO().categoryPendingModeration());
	}
	
	public void view() throws Exception
	{
		int forumId = this.request.getIntParameter("forum_id");
		
		this.setTemplateName(TemplateKeys.MODERATION_ADMIN_VIEW);
		this.context.put("forum", ForumRepository.getForum(forumId));
		this.context.put("topics", DataAccessDriver.getInstance().newModerationDAO().topicsByForum(
				forumId));
	}
	
	public void doSave() throws Exception
	{
		String[] posts = this.request.getParameterValues("post_id");

		if (posts != null) {
			TopicDAO tm = DataAccessDriver.getInstance().newTopicDAO();
			
			for (int i = 0; i < posts.length; i++) {
				int postId = Integer.parseInt(posts[i]);
				
				String status = this.request.getParameter("status_" + postId);
				
				if ("defer".startsWith(status)) {
					continue;
				}
				
				if ("aprove".startsWith(status)) {
					Post p = DataAccessDriver.getInstance().newPostDAO().selectById(postId);
					
					UserDAO udao = DataAccessDriver.getInstance().newUserDAO();
					User u = udao.selectById(p.getUserId());
					
					// Check is the post is in fact waiting for moderation
					if (!p.isModerationNeeded()) {
						continue;
					}
					
					boolean first = false;
					Topic t = TopicRepository.getTopic(new Topic(p.getTopicId()));
					
					if (t == null) {
						t = tm.selectById(p.getTopicId());
						
						if (t.getId() == 0) {
							first = true;
							t = tm.selectRaw(p.getTopicId());
						}
					}
					
					DataAccessDriver.getInstance().newModerationDAO().aprovePost(postId);
					
					boolean firstPost = (t.getFirstPostId() == postId);
					
					if (!firstPost) {
						t.setTotalReplies(t.getTotalReplies() + 1);
					}
					
					t.setLastPostId(postId);
					t.setLastPostBy(u);
					t.setLastPostDate(p.getTime());
					t.setLastPostTime(p.getFormatedTime());
					
					tm.update(t);
					
					if (first) {
						t = tm.selectById(t.getId());
					}

					TopicsCommon.updateBoardStatus(t, postId, firstPost,
							tm, DataAccessDriver.getInstance().newForumDAO());
					
					ForumRepository.updateForumStats(t, u, p);
					TopicsCommon.notifyUsers(t, tm);
					
					udao.incrementPosts(p.getUserId());
					
					if (SystemGlobals.getBoolValue(ConfigKeys.POSTS_CACHE_ENABLED)) {
						PostRepository.append(p.getTopicId(), PostCommon.preparePostForDisplay(p));
					}
				}
				else {
					PostDAO pm = DataAccessDriver.getInstance().newPostDAO();
					Post post = pm.selectById(postId);
					
					if (post == null || !post.isModerationNeeded()) {
						continue;
					}
					
					pm.delete(post);
					
					new AttachmentCommon(this.request, post.getForumId()).deleteAttachments(postId, post.getForumId());
					
					int totalPosts = tm.getTotalPosts(post.getTopicId());
					
					if (totalPosts == 0) {
						TopicsCommon.deleteTopic(post.getTopicId(), post.getForumId(), true);
					}
				}
			}
		}
	}
	
	public void save() throws Exception
	{
		this.doSave();
		this.view();
	}
}
