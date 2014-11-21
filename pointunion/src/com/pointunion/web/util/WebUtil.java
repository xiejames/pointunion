package com.pointunion.web.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;

import org.apache.log4j.Logger;

public class WebUtil {
	private static Logger logger = Logger.getLogger("PointUnionWebLogger");

	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private static Pattern emailRegex = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");

	public static String getRequestString(ServletRequest request, String param) {
		String val = request.getParameter(param);
		if (val == null || "".equals(val.trim())) {
			return null;
		} else {
			return val.trim();
		}
	}

	public static Integer getRequestInteger(ServletRequest request, String param) {
		String val = request.getParameter(param);
		if (val == null || "".equals(val.trim())) {
			return null;
		} else {
			try {
				return Integer.valueOf(val.trim());
			} catch (NumberFormatException e) {
				logger.error(e.getMessage(), e);
				return null;
			}
		}
	}

	public static Long getRequestLong(ServletRequest request, String param) {
		String val = request.getParameter(param);
		if (val == null || "".equals(val.trim())) {
			return null;
		} else {
			try {
				return Long.valueOf(val.trim());
			} catch (NumberFormatException e) {
				logger.error(e.getMessage(), e);
				return null;
			}
		}
	}

	public static Timestamp getRequestTimestamp(ServletRequest request, String param) {
		String val = request.getParameter(param);
		if (val == null || "".equals(val.trim())) {
			return null;
		} else {
			try {
				Date date = dateFormat.parse(val.trim());
				return new Timestamp(date.getTime());
			} catch (ParseException e) {
				logger.error(e.getMessage(), e);
				return null;
			}
		}
	}

	public final static int FORMAT_STRING = 1;

	public final static int FORMAT_INTEGER = 2;

	public final static int FORMAT_LONG = 3;

	public final static int FORMAT_DATE = 4;

	public final static int FORMAT_EMAIL = 5;

	public final static int FORMAT_TELEPHONE = FORMAT_STRING;

	/**
	 * 验证输入得参数是否满足要求
	 * 
	 * @param request
	 *            current HTTPrequest
	 * @param errors
	 * @param param
	 *            参数名
	 * @param paramDesc
	 *            描述
	 * @param type
	 *            种类
	 * @param maxLength
	 *            最大长度
	 * @param nullable
	 *            该参数是否可以为空
	 * @return 如果满足要求,返回null,否则返回对错误的描述列表
	 */
	public static void validate(ServletRequest request, Collection errors, String param, String paramDesc, int type, int maxLength, boolean nullable) {
		validate(request, errors, param, paramDesc, type, 0, maxLength, nullable);
	}

	/**
	 * 验证输入得参数是否满足要求
	 * 
	 * @param request
	 *            current HTTPrequest
	 * @param errors
	 * @param param
	 *            参数名
	 * @param paramDesc
	 *            描述
	 * @param type
	 *            种类
	 * @param mixLength
	 *            最小长度
	 * @param maxLength
	 *            最大长度
	 * @param nullable
	 *            该参数是否可以为空
	 */
	public static void validate(ServletRequest request, Collection errors, String param, String paramDesc, int type, int minLength, int maxLength, boolean nullable) {

		String val = request.getParameter(param);
		if (val != null) {
			val = val.trim();
			if(val.equals("")){
				val = null;
			}
		}
		paramDesc = paramDesc == null ? param : paramDesc;		

		if (!nullable && val == null) {
			errors.add(paramDesc + "不可为空");
			return;
		} else if (nullable && val == null) {
			return;
		}

		if (val.length() < minLength) {
			errors.add(paramDesc + "的长度不可小于" + minLength + "位");
		}

		if (val.length() > maxLength) {
			errors.add(paramDesc + "的长度不可超过" + maxLength + "位");
		}

		switch (type) {
		case FORMAT_STRING:
			return;
		case FORMAT_INTEGER:
			try {
				Integer.valueOf(val.trim());
			} catch (NumberFormatException e) {
				errors.add(paramDesc + "必须是整数");
			}
			return;
		case FORMAT_LONG:
			try {
				Long.valueOf(val.trim());
			} catch (NumberFormatException e) {
				errors.add(paramDesc + "必须是长整数");
			}
			return;
		case FORMAT_DATE:
			try {
				dateFormat.parse(val.trim());
			} catch (ParseException e) {
				errors.add(paramDesc + "必须是日期类型,其格式是\"YYYY-MM-DD\"");
			}
			return;
		case FORMAT_EMAIL:
			if (!emailRegex.matcher(val).matches()) {
				errors.add(paramDesc + "的不符合EMAIL地址的格式");
			}
			return;
		default:
			throw new IllegalArgumentException("参数类型的值无效");
		}

	}

	public static void main(String[] args) throws Exception {
		if (!emailRegex.matcher("ssdf@dd.com").matches()) {
			System.out.println("error");
		}
		System.out.println("ok");
	}
}
