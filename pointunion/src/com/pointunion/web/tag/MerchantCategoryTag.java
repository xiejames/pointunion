package com.pointunion.web.tag;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import com.pointunion.domain.dto.MerchantCategory;
import com.pointunion.web.util.ApplicationData;

public class MerchantCategoryTag extends TagSupport {
	private String param = null;
	private String categoryNo = null;

	public void setParam(String param) {
		this.param = param;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	
	public int doStartTag() throws JspException {
		categoryNo = (String) ExpressionEvaluatorManager.evaluate("value", categoryNo, Object.class, this, pageContext);		
		pageContext.setAttribute(param, getCatalogs());
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	
	public Collection getCatalogs(){		
		ApplicationData appData = (ApplicationData)pageContext.getServletContext().getAttribute("appData");
		Collection categories = appData.getMerchantCategories();
		Map map = new TreeMap();
		for (Iterator it = categories.iterator(); it.hasNext();) {
			MerchantCategory category = (MerchantCategory) it.next();
			if(categoryNo.trim().toUpperCase().startsWith(category.getMcNo().toUpperCase())){
				map.put(category.getMcNo(), category);
			}
		}
		
		return map.values();
	}
}
