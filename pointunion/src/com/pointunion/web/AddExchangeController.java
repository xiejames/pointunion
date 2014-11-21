package com.pointunion.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.pointunion.domain.dto.Product;
import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.web.util.Cart;
import com.pointunion.web.util.Item;
import com.pointunion.web.util.WebUtil;

/**
 * 增加一个兑换商品到购物车中去 
 * @author yanjian
 * @since 10.06.2006
 */

public class AddExchangeController implements Controller {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String productNo = WebUtil.getRequestString(request, "productNo");
		if(productNo==null){
			Map result = new HashMap();
			result.put("title", "积分兑换");
			result.put("flag", "1");
			result.put("msg", "您要查看的商品不存在");			
			request.setAttribute("result", result);						
			return new ModelAndView("result");
		}
		
		Product p = pointUnion.getProduct(productNo);
		
		if(p==null){
			Map result = new HashMap();
			result.put("title", "积分兑换");
			result.put("flag", "1");
			result.put("msg", "您要查看的商品不存在");			
			request.setAttribute("result", result);						
			return new ModelAndView("result");
		}

		Item item = new Item(p);
		Cart.getSessionCart(request.getSession()).addItem(item);
		
		return new ModelAndView("exchangeInfo");
	}

}
