package com.pointunion.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

public class StringSliceTag extends TagSupport {
	private String length = null;

	private String value = null;

	public void setLength(String length) {
		this.length = length;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int doEndTag() throws JspException {
		try {
			value = (String) ExpressionEvaluatorManager.evaluate("value", value, Object.class, this, pageContext);
			if (value != null) {
				try {
					int len = Integer.parseInt(length);
					if (len < getStringLength(value)) {
						if (len > 2) {
							value = "<font title=\"" + value + "\">" + getSubString(value, len - 2) + "..</font>";
						} else if (len > 0) {
							value = "<font title=\"" + value + "\">..</font>";
						}
					}
				} catch (NumberFormatException e) {
					pageContext.getOut().print("<!-- NumberFormatError -->");
				}
				pageContext.getOut().print(value);
			} else {
				pageContext.getOut().print("<!-- code is null -->");
			}
		} catch (IOException e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}

	public static void main(String[] args) throws Exception {
		String value = "ÄÞºçµÆ·¢¶¯Å©Ãñ·ÀµÁËø·ÖÈý´ó·ÅËÍ";
		value = "ÄÞºçnvd";
		System.out.println(getStringLength(value));

		int len = 7;
		if (len < getStringLength(value)) {
			if (len > 2) {
				value = "<font title=\"" + value + "\">" + getSubString(value, len - 2) + "..</font>";
			} else if (len > 0) {
				value = "<font title=\"" + value + "\">..</font>";
			}
		}
		System.out.println(value);
	}

	public static int getStringLength(String str) {
		int len = 0;
		char arr[] = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if ((int) arr[i] <= 128) {
				len++;
			} else {
				len += 2;
			}
		}
		return len;
	}

	public static String getSubString(String str, int maxLen) {
		int len = 0;
		char arr[] = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {			
			if ((int) arr[i] <= 128) {
				len++;
			} else {
				len += 2;
			}

			if (len > maxLen) {
				return new String(arr, 0, i);
			}
		}
		return str;
	}

}
