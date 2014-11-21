package com.pointunion.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.domain.qc.ProductQC;
import com.pointunion.web.util.QueryController;
import com.pointunion.web.util.WebUtil;

/**
 * @author yanjian
 * @since 10.06.2006
 */

public class QueryProductController  extends QueryController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductQC qc = new ProductQC();
		qc.setProductCtg(WebUtil.getRequestString(request, "productCtg"));
		qc.setProductKey(WebUtil.getRequestString(request, "productKey"));
		qc.setPoint1(WebUtil.getRequestInteger(request, "point1"));
		qc.setPoint2(WebUtil.getRequestInteger(request, "point2"));

		qc.setTime1(WebUtil.getRequestTimestamp(request, "time1"));
		qc.setTime2(WebUtil.getRequestTimestamp(request, "time2"));
		qc.setOrderBy(WebUtil.getRequestString(request, "orderBy"));
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

		Map result = new HashMap();
		Collection list = this.pointUnion.getProducts(qc);
		int total = this.pointUnion.getProductsCount(qc);
		result.put("productCount", total + "");
		result.put("productList", list);
		result.put("productQC", qc);

		request.setAttribute("result", result);
		return new ModelAndView("productList");
	}

	protected String getTitle() {
		return "ÉÌÆ·²éÑ¯";
	}
}
