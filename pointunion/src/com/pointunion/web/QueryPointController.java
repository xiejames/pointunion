package com.pointunion.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.domain.qc.PileRecordQC;
import com.pointunion.web.util.QueryController;
import com.pointunion.web.util.UserSession;
import com.pointunion.web.util.WebUtil;

/**
 * @author yanjian
 * @since 10.06.2006
 */

public class QueryPointController extends QueryController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=new HashMap();
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		
		PileRecordQC qc = new PileRecordQC();
		qc.setAccountNo(userSession.getAccount().getAccountNo());
		qc.setCardNo(WebUtil.getRequestString(request, "cardNo"));
		qc.setMerchantNo(WebUtil.getRequestString(request, "merchantNo"));		
		qc.setTime1(WebUtil.getRequestTimestamp(request, "time1"));
		qc.setTime2(WebUtil.getRequestTimestamp(request, "time2"));
		qc.setPoint1(WebUtil.getRequestInteger(request, "point1"));
		qc.setPoint2(WebUtil.getRequestInteger(request, "point2"));
		qc.setPileType(WebUtil.getRequestString(request, "pileType"));
		
		qc.setStartRow(WebUtil.getRequestInteger(request, "startRow"));
		qc.setPageSize(WebUtil.getRequestInteger(request, "pageSize"));
		qc.setOrderBy(WebUtil.getRequestString(request, "orderBy"));
		qc.setOrderType(WebUtil.getRequestString(request, " orderType"));

		if (qc.getPoint1() != null && qc.getPoint1().intValue() < 0) {
			qc.setPoint1(null);
		}

		if (qc.getPageSize() == null) {
			qc.setPageSize(new Integer(30));
		}
		
		Collection list = this.pointUnion.getPileRecords(qc);
		int total = this.pointUnion.getPileRecordsCount(qc);
		result.put("pointCount", total + "");
		result.put("pointList", list);
		result.put("pointQC", qc);
		
		request.setAttribute("result", result);
	 	return new ModelAndView("pointList");
	}
	
	protected void validate(Collection errors, HttpServletRequest request){
		WebUtil.validate(request, errors, " pileType", "积分类型", WebUtil.FORMAT_STRING, 1, true);
	}

	protected boolean needCheckSession() {
		return true;
	}

	protected String getTitle() {		
		return "积分查询";
	}
}
