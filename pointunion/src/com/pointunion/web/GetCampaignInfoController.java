package com.pointunion.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.pointunion.domain.dto.Campaign;
import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.web.util.WebUtil;

/**
 * @author xielingjiang
 * @since 10.06.2006
 */

public class GetCampaignInfoController implements Controller {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String campaignNo = WebUtil.getRequestString(request, "campaignNo");
		Map result = new HashMap();
		
		Campaign c = this.pointUnion.getCampaign(campaignNo);
		if(c==null){
			result.put("title", "积分活动信息");
			result.put("flag", "1");
			result.put("msg", "您要查看的积分活动不存在");			
			request.setAttribute("result", result);						
			return new ModelAndView("result");
		}
		
		
		result.put("campaign", c);

		request.setAttribute("result", result);
		return new ModelAndView("campaignInfo");
	}

}
