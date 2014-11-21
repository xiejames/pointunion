package com.pointunion.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.pointunion.web.util.AppDataInitializer;

public class RefreshDataController implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = new HashMap();
		result.put("title", "更新数据");
		result.put("flag", "0");
		result.put("msg", "");
		
		try{
			AppDataInitializer dataIniter =(AppDataInitializer)request.getSession().getServletContext().getAttribute("appInitBean");
			dataIniter.init(request.getSession().getServletContext());
		}catch(Exception e){
			result.put("flag", "1");
			result.put("msg", e.getMessage());
		}

		request.setAttribute("result", result);
		return new ModelAndView("result");
	}
}
