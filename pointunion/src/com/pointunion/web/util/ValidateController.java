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
	 * �Ƿ���Ҫ����û��Ѿ���¼
	 */
	protected boolean needCheckSession(){
		return false;
	}

	/**
	 * ��������Ƿ���ȷ
	 * 
	 * @return
	 */
	protected abstract Collection validate(HttpServletRequest request);

	/**
	 * ��ò���������
	 * @return
	 */
	protected abstract String getTitle();
	
	
	/**
	 * ����Ĵ������
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
				result.put("msg", "���ȵ�¼");
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
