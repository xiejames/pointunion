package com.pointunion.web;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.dto.Account;
import com.pointunion.domain.dto.Customer;
import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.web.util.UserSession;
import com.pointunion.web.util.ValidateController;
import com.pointunion.web.util.WebUtil;

/**
 * @author xielingjiang
 * @since 10.06.2006
 */

public class SignonController extends ValidateController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		Customer customer = pointUnion.signOn(userId, password);
		if (customer == null) {
			request.getSession().setAttribute("userSession", null);
			return new ModelAndView("loginframe");
		} else {
			UserSession userSession = new UserSession(customer);
			Account account = this.pointUnion.getAccountByCustomerNo(customer.getCustomerNo());
			userSession.setAccount(account);

			request.getSession().setAttribute("userSession", userSession);
			request.getSession().setAttribute("forum_email",customer.getEmail());
			request.getSession().setAttribute("forum_password", password);

			String forwardAction = request.getParameter("forwardAction");
			if (forwardAction != null) {
				response.sendRedirect(forwardAction);
				return null;
			} else {
				return new ModelAndView("loginframe");
			}
		}
	}

	protected Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "userid", "用户ID", WebUtil.FORMAT_STRING, 20, false);
		WebUtil.validate(request, errors, "password", "密码", WebUtil.FORMAT_STRING, 20, false);
		return errors;
	}

	protected String getTitle() {
		return "用户登录";
	}

}
