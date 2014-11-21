package com.pointunion.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.domain.qc.PointChangeQC;
import com.pointunion.web.util.QueryController;
import com.pointunion.web.util.UserSession;
import com.pointunion.web.util.WebUtil;

/**
 * @author xielingjiang
 * @since 10.06.2006
 */

public class QueryExchangeController extends QueryController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = new HashMap();
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");

		// 用户编号，开始时间，结束时间，兑换积分范围
		PointChangeQC qc = new PointChangeQC();
		qc.setAccountNo(userSession.getAccount().getAccountNo());
		qc.setTime1(WebUtil.getRequestTimestamp(request, "time1"));
		qc.setTime2(WebUtil.getRequestTimestamp(request, "time2"));
		qc.setPoint1(WebUtil.getRequestInteger(request, "point1"));
		qc.setPoint2(WebUtil.getRequestInteger(request, "point2"));

		Collection pointChanges = pointUnion.getPointChanges(qc);

		result.put("exchangeList", pointChanges);

		request.setAttribute("result", result);
		return new ModelAndView("exchangeList");
	}

	protected boolean needCheckSession() {
		return true;
	}

	protected String getTitle() {
		return "兑换查询";
	}
}
