package com.pointunion.web.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public abstract class ValidateController implements Controller {
	/**
	 * 是否需要检查用户已经登录
	 */
	protected boolean needCheckSession(){
		return false;
	}

	/**
	 * 检查输入是否正确
	 * 
	 * @return
	 */
	protected abstract Collection validate(HttpServletRequest request);

	/**
	 * 获得操作的主题
	 * @return
	 */
	protected abstract String getTitle();
	
	
	/**
	 * 具体的处理过程
	 * @return
	 */
	protected abstract ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = new HashMap();
		result.put("title", getTitle());

		if (needCheckSession()) {
			Object obj = request.getSession().getAttribute("userSession");
			if (obj == null || !(obj instanceof UserSession)) {
				result.put("flag", "1");
				result.put("msg", "请先登录");
				request.setAttribute("result", result);
				return new ModelAndView("result");
			}
		}

		Collection errs = validate(request);
		if (errs != null && errs.size() > 0) {
			result.put("flag", "1");
			StringBuffer buf = new StringBuffer();
			
			for (Iterator it = errs.iterator(); it.hasNext();) {
				buf.append((String)it.next());
			}
			
			result.put("msg", buf.toString());
			request.setAttribute("result", result);
			return new ModelAndView("result");
		}

		return handle(request, response);
	}


}
