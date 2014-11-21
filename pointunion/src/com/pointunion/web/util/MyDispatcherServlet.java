package com.pointunion.web.util;

import javax.servlet.ServletException;

import org.springframework.beans.BeansException;
import org.springframework.web.servlet.DispatcherServlet;

public class MyDispatcherServlet extends DispatcherServlet{
	protected void initFrameworkServlet() throws ServletException, BeansException {
		super.initFrameworkServlet();
		
		try{
			AppDataInitializer dataIniter =(AppDataInitializer)getWebApplicationContext().getBean("appInitBean");
			if(dataIniter==null){
				if (logger.isInfoEnabled()) {
					logger.equals("No AppDataInitializer found in servlet " + getServletName());
				}
			}			
			dataIniter.init(this.getWebApplicationContext().getServletContext());			
			if (logger.isInfoEnabled()) {
				logger.info("AppDataInitializer init OK");
			}
		}catch(Exception e){
			if (logger.isInfoEnabled()) {
				logger.error("AppDataInitializer init error", e);
			}
		}
	}
}
