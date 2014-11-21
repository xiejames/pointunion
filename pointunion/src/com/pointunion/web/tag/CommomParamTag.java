package com.pointunion.web.tag;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import com.pointunion.domain.dto.MerchantCategory;
import com.pointunion.domain.dto.ProductCategory;
import com.pointunion.web.util.ApplicationData;
import com.pointunion.web.util.City;
import com.pointunion.web.util.CityUtil;
import com.pointunion.web.util.CommomParamUtil;
import com.pointunion.web.util.Province;

public class CommomParamTag extends TagSupport {
	private String type = null;

	private String code = null;

	public void setType(String type) {
		this.type = type;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int doEndTag() throws JspException {
		try {
			code = (String) ExpressionEvaluatorManager.evaluate("value", code, Object.class, this, pageContext);
			if (code != null) {
				String param = getParam();
				param = param == null ? "<!-- code is null -->" : param;
				pageContext.getOut().print(param);
			} else {
				pageContext.getOut().print("<!-- code is null -->");
			}
		} catch (IOException e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}

	private String getParam() {
		ApplicationData appData = (ApplicationData) pageContext.getServletContext().getAttribute("appData");
		Collection categories = null;
		if (type.equalsIgnoreCase("merchant")) {
			categories = appData.getMerchantCategories();
			for (Iterator it = categories.iterator(); it.hasNext();) {
				MerchantCategory category = (MerchantCategory) it.next();
				if (code.trim().equalsIgnoreCase(category.getMcNo())) {
					return category.getName();
				}
			}
		} else if (type.equalsIgnoreCase("product")) {
			categories = appData.getProductCategories();
			for (Iterator it = categories.iterator(); it.hasNext();) {
				ProductCategory category = (ProductCategory) it.next();
				if (code.trim().equalsIgnoreCase(category.getPcNo())) {
					return category.getName();
				}
			}
		} else if (type.equalsIgnoreCase("province")) {
			Province p = CityUtil.getInstance().getProvince(code);
			return p == null ? null : p.getProvince();
		} else if (type.equalsIgnoreCase("city")) {
			String arr[] = code.split(",");
			if (arr.length != 2) {
				return null;
			} else {
				City c = CityUtil.getInstance().getCity(arr[0], arr[1]);
				return c == null ? null : c.getCity();
			}
		} else if (type.equalsIgnoreCase("industry")) {
			return CommomParamUtil.getInstance().getIndusty(code);
		}
		return null;
	}
}
