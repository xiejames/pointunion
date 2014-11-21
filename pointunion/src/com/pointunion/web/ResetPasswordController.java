package com.pointunion.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.domain.logic.ServiceException;
import com.pointunion.web.util.ValidateController;
import com.pointunion.web.util.WebUtil;

/**
 * @author xielingjiang
 * @since 10.06.2006
 */

public class ResetPasswordController extends ValidateController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=new HashMap();
		result.put("title", "÷ÿ÷√√‹¬Î");		
		
		String userID = WebUtil.getRequestString(request, "userID");
		String pwd = WebUtil.getRequestString(request, "pwd");
		String newPwd = WebUtil.getRequestString(request, "newPwd");		
		
		boolean flag=true;
		String msg="";
		try{
			flag=pointUnion.resetPassword(userID, pwd, newPwd);
			if(flag)
				msg="0";
			else
				msg="1";
		}catch(ServiceException e){
			msg="2";
		}
		if(flag){
			result.put("flag", "0");
			result.put("msg", msg);					
		}else{
			result.put("flag", "1");
			result.put("msg", msg);		
		}

		request.setAttribute("result", result);
	 	return new ModelAndView("result");
	}

	protected Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "userID", "”√ªßID", WebUtil.FORMAT_STRING, 20, false);
		WebUtil.validate(request, errors, "pwd", "√‹¬Î", WebUtil.FORMAT_STRING, 20, false);
		WebUtil.validate(request, errors, "newPwd", "–¬√‹¬Î", WebUtil.FORMAT_STRING, 20, false);
		return errors;
	}

	protected String getTitle() {
		return "÷ÿ÷√√‹¬Î";
	}
}
