package com.pointunion.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.dto.Product;
import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.web.util.ValidateController;
import com.pointunion.web.util.WebUtil;

/**
 * @author yanjian
 * @since 10.06.2006
 */

public class GetProductInfoController extends ValidateController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String productNo = WebUtil.getRequestString(request, "productNo");
		
		Map result = new HashMap();
		Product p = this.pointUnion.getProduct(productNo);		
		if (p == null) {
			result.put("title", getTitle());
			result.put("flag", "1");
			result.put("msg", "您要查看的商品信息不存在");
			request.setAttribute("result", result);
			return new ModelAndView("result");
		}
		
		result.put("product", p);

		request.setAttribute("result", result);
		return new ModelAndView("productInfo");
	}
	
	protected Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "productNo", "商品编号", WebUtil.FORMAT_STRING, 32, false);
		return errors;
	}

	protected String getTitle() {
		return "商品信息";
	}
}
