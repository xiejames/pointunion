package com.pointunion.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.web.util.ValidateController;
import com.pointunion.web.util.WebUtil;

/**
 * @author xielingjiang
 * @since 10.06.2006
 */

public class ForgetPasswordController extends ValidateController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=new HashMap();		
		result.put("title", getTitle());		
		
		String userID = WebUtil.getRequestString(request, "userID");
		String email = WebUtil.getRequestString(request, "email");
		String pwdSeed = WebUtil.getRequestString(request, "pwdSeed");		
		
		boolean r = pointUnion.forgetPassword(userID, email, pwdSeed);
		if(r){
			result.put("flag", "0");
			result.put("msg", "");
		}else{
			result.put("flag", "1");
			result.put("msg", "用户ID或Email错，或不匹配");
		}
		
		request.setAttribute("result", result);
	 	return new ModelAndView("result");
	}

	protected Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "userID", "用户ID", WebUtil.FORMAT_STRING, 32, false);
		WebUtil.validate(request, errors, "email", "电子邮件", WebUtil.FORMAT_EMAIL, 64, false);
		WebUtil.validate(request, errors, "pwdSeed", "密码种子", WebUtil.FORMAT_STRING, 8, false);
		return errors;
	}

	protected String getTitle() {
		return "忘记密码";
	}
}
