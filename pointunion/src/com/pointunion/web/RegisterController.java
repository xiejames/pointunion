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

public class RegisterController extends ValidateController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = new HashMap();

		// String rand = (String)request.getSession().getAttribute("rand");
		// String input = request.getParameter("verify_code");
		// if (!rand.equals(input)) {
		// result.put("flag","false");
		// request.getSession().setAttribute("result", result);
		// return new ModelAndView("registerResult");
		// }
		String userId = WebUtil.getRequestString(request, "userid");
		String ischeck = WebUtil.getRequestString(request, "ischeck");
		if (ischeck != null) {
			if (this.pointUnion.getCustomer(userId) == null) {
				result.put("canregister", "true");
			} else {
				result.put("canregister", "false");
			}
			result.put("userId", userId);
			request.getSession().setAttribute("result", result);
			return new ModelAndView("checkResult");
		}

		String password = WebUtil.getRequestString(request, "password");
		String email = WebUtil.getRequestString(request, "email");
		int rst = this.pointUnion.register(userId, password, email);

		result.put("registered", rst + "");
		result.put("userId", userId);
		result.put("email", email);

		request.setAttribute("result", result);
		return new ModelAndView("registerResult");

	}

	protected Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "userid", "用户ID", WebUtil.FORMAT_STRING, 32, false);

		String ischeck = WebUtil.getRequestString(request, "ischeck");
		if (ischeck == null) {
			WebUtil.validate(request, errors, "email", "电子邮件", WebUtil.FORMAT_EMAIL, 64, false);
			WebUtil.validate(request, errors, "password", "密码", WebUtil.FORMAT_STRING, 64, false);
			WebUtil.validate(request, errors, "checksum", "校验码", WebUtil.FORMAT_STRING, 8, false);
			String check1 = WebUtil.getRequestString(request, "checksum");
			String check2 = (String)request.getSession().getAttribute("checkSum");
			if(check1!=null){
				if(!check1.equals(check2)){
					errors.add("检验码不正确");
				}
			}
		}
		
		return errors;
	}

	protected String getTitle() {
		return "用户注册";
	}

}
