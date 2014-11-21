package com.pointunion.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.domain.qc.CampaignQC;
import com.pointunion.web.util.QueryController;
import com.pointunion.web.util.WebUtil;

/**
 * @author yanjian
 * @since 10.06.2006
 */

public class QueryCampaignController extends QueryController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CampaignQC qc = new CampaignQC();

		qc.setMerchantKey(WebUtil.getRequestString(request, "merchantKey"));
		qc.setMerchantCtg(WebUtil.getRequestString(request, "merchantCtg"));
		qc.setCampaignKey(WebUtil.getRequestString(request, "campaignKey"));

		qc.setTime1(WebUtil.getRequestTimestamp(request, "time1"));
		qc.setTime2(WebUtil.getRequestTimestamp(request, "time2"));
		qc.setStartRow(WebUtil.getRequestInteger(request, "startRow"));
		qc.setPageSize(WebUtil.getRequestInteger(request, "pageSize"));
		qc.setOrderBy(WebUtil.getRequestString(request, "orderBy"));
		qc.setOrderType(WebUtil.getRequestString(request, " orderType"));

		if (qc.getPageSize() == null) {
			qc.setPageSize(new Integer(30));
		}

		Map result = new HashMap();
		Collection list = this.pointUnion.getCampaigns(qc);
		int total = this.pointUnion.getCampaignsCount(qc);
		result.put("campaignCount", total + "");
		result.put("campaignList", list);
		result.put("campaignQC", qc);

		request.setAttribute("result", result);
		return new ModelAndView("campaignList");
	}

	protected String getTitle() {
		return "积分活动查询";
	}

}
