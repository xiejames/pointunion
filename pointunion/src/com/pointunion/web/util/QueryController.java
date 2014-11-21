package com.pointunion.web.util;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

public abstract class QueryController extends ValidateController {

	/**
	 * ������������Ƿ���ȷ
	 * 
	 * @return
	 */
	protected void validate(Collection errors, HttpServletRequest request){
	}

	protected final Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "time1", "ʱ��1", WebUtil.FORMAT_DATE, 10, true);
		WebUtil.validate(request, errors, "time2", "ʱ��2", WebUtil.FORMAT_DATE, 10, true);
		WebUtil.validate(request, errors, "point1", "����1", WebUtil.FORMAT_INTEGER, 10, true);
		WebUtil.validate(request, errors, "point2", "����2", WebUtil.FORMAT_INTEGER, 10, true);

		WebUtil.validate(request, errors, "startRow", "��ʼ��¼��", WebUtil.FORMAT_INTEGER, 10, true);
		WebUtil.validate(request, errors, "pageSize", "ҳ�泤��", WebUtil.FORMAT_INTEGER, 10, true);
		WebUtil.validate(request, errors, "orderBy", "�����ֶ�", WebUtil.FORMAT_STRING, 2, true);
		WebUtil.validate(request, errors, "orderType", "����ʽ", WebUtil.FORMAT_STRING, 1, true);

		validate(errors, request);
		return errors;
	}
}
