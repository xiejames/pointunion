package com.pointunion.web.util;

import javax.servlet.http.HttpServletRequest;

import net.jforum.ActionServletRequest;
import net.jforum.entities.UserSession;
import net.jforum.sso.SSO;

public class PointUnionSSO implements SSO{
	public String authenticateUser(ActionServletRequest request) {
		com.pointunion.web.util.UserSession us = (com.pointunion.web.util.UserSession)request.getSession().getAttribute("userSession");
		if(us!=null){
			return us.getCustomer().getUserId();
		}
		return null;
	}

	public boolean isSessionValid(UserSession userSession, HttpServletRequest request) {
		if(request.getSession().getAttribute("userSession")!=null){
			return false;
		}
		return false;
	}


}
