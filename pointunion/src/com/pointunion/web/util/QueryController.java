package com.pointunion.web.util;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

public abstract class QueryController extends ValidateController {

	/**
	 * 检查其他输入是否正确
	 * 
	 * @return
	 */
	protected void validate(Collection errors, HttpServletRequest request){
	}

	protected final Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "time1", "时间1", WebUtil.FORMAT_DATE, 10, true);
		WebUtil.validate(request, errors, "time2", "时间2", WebUtil.FORMAT_DATE, 10, true);
		WebUtil.validate(request, errors, "point1", "点数1", WebUtil.FORMAT_INTEGER, 10, true);
		WebUtil.validate(request, errors, "point2", "点数2", WebUtil.FORMAT_INTEGER, 10, true);

		WebUtil.validate(request, errors, "startRow", "开始记录数", WebUtil.FORMAT_INTEGER, 10, true);
		WebUtil.validate(request, errors, "pageSize", "页面长度", WebUtil.FORMAT_INTEGER, 10, true);
		WebUtil.validate(request, errors, "orderBy", "排序字段", WebUtil.FORMAT_STRING, 2, true);
		WebUtil.validate(request, errors, "orderType", "排序方式", WebUtil.FORMAT_STRING, 1, true);

		validate(errors, request);
		return errors;
	}
}
