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
import com.pointunion.web.util.Cart;
import com.pointunion.web.util.Item;
import com.pointunion.web.util.ValidateController;
import com.pointunion.web.util.WebUtil;

/**
 * @author yanjian
 * @since 10.06.2006
 */

public class ModifyExchangeController extends ValidateController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String productNo = WebUtil.getRequestString(request, "productNo");
		int quantity = WebUtil.getRequestInteger(request, "quantity").intValue();

		Product p = pointUnion.getProduct(productNo);
		if (p == null) {
			Map result=new HashMap();
			result.put("title", getTitle());
			result.put("flag", "1");
			result.put("msg", "您要查看的商品信息不存在");
			request.setAttribute("result", result);
			return new ModelAndView("result");
		}
		
		Item item = new Item(p);
		item.setQuantity(quantity);
		Cart.getSessionCart(request.getSession()).updateItemQuantity(item);

		return new ModelAndView("exchangeInfo");
	}

	protected Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "productNo", "产品编号", WebUtil.FORMAT_STRING, 32, false);
		WebUtil.validate(request, errors, "quantity", "数量", WebUtil.FORMAT_INTEGER, 6, false);
		return errors;
	}

	protected String getTitle() {
		return "修改兑换物品数量";
	}

}
