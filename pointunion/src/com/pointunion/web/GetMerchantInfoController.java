package com.pointunion.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.dto.Merchant;
import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.web.util.ValidateController;
import com.pointunion.web.util.WebUtil;

/**
 * @author yanjian
 * @since 10.06.2006
 */

public class GetMerchantInfoController extends ValidateController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String merchantNo = WebUtil.getRequestString(request, "merchantNo");

		Map result = new HashMap();
		Merchant m = this.pointUnion.getMerchant(merchantNo);
		if (m == null) {
			result.put("title", getTitle());
			result.put("flag", "1");
			result.put("msg", "您要查看的商户信息不存在");
			request.setAttribute("result", result);
			return new ModelAndView("result");
		}

		result.put("merchant", m);

		request.setAttribute("result", result);
		return new ModelAndView("merchantInfo");
	}

	protected Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "merchantNo", "商户编号", WebUtil.FORMAT_STRING, 32, false);
		return errors;
	}

	protected String getTitle() {
		return "商户信息";
	}

}
