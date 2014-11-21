package com.pointunion.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.domain.qc.CampaignQC;
import com.pointunion.domain.qc.MerchantQC;
import com.pointunion.domain.qc.ProductQC;
import com.pointunion.web.util.WebUtil;

/**
 * @author xielingjiang
 * @since 10.06.2006
 */

public class QueryAllController implements Controller {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductQC productQC = new ProductQC();
		CampaignQC campaignQC = new CampaignQC();
		MerchantQC merchantQC = new MerchantQC();
		
		productQC.setProductKey(WebUtil.getRequestString(request, "queryKey"));
		campaignQC.setCampaignKey(WebUtil.getRequestString(request, "queryKey"));
		merchantQC.setMerchantKey(WebUtil.getRequestString(request, "queryKey"));
		
		Map result = new HashMap();
		
		Collection productList = this.pointUnion.getProducts(productQC);
		int productTotal = this.pointUnion.getProductsCount(productQC);
		
		Collection campaignList = this.pointUnion.getCampaigns(campaignQC);
		int campaignTotal = this.pointUnion.getCampaignsCount(campaignQC);
		
		Collection merchantList = this.pointUnion.getMerchants(merchantQC);
		int merchantTotal = this.pointUnion.getMerchantsCount(merchantQC);
		
		result.put("productCount", productTotal + "");
		result.put("productList", productList);
		
		result.put("campaignCount", campaignTotal + "");
		result.put("campaignList", campaignList);		
		
		result.put("merchantCount", merchantTotal + "");
		result.put("merchantList", merchantList);
		
		result.put("queryKey", WebUtil.getRequestString(request, "queryKey"));
		
		request.setAttribute("result", result);
		return new ModelAndView("allList");
	}

}
