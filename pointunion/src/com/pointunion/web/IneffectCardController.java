package com.pointunion.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.dto.Card;
import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.web.util.UserSession;
import com.pointunion.web.util.ValidateController;
import com.pointunion.web.util.WebUtil;

/**
 * @author yanjian
 * @since 10.06.2006
 */

public class IneffectCardController extends ValidateController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = new HashMap();
		result.put("title", getTitle());

		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");

		String cardNo = WebUtil.getRequestString(request, "cardNo");
		String reason = WebUtil.getRequestString(request, "reason");

		Card card = pointUnion.getCard(cardNo);

		if (card == null || !card.getAccountNo().equals(userSession.getAccount().getAccountNo())) {
			result.put("flag", "1");
			result.put("msg", "请使用正常方式进行销卡");
		} else {
			pointUnion.ineffectCard(cardNo, reason);
			result.put("flag", "0");
			result.put("msg", "销卡成功");
		}

		request.setAttribute("result", result);
		return new ModelAndView("result");
	}

	protected boolean needCheckSession() {
		return true;
	}

	protected Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "cardNo", "卡号", WebUtil.FORMAT_STRING, 32, false);
		WebUtil.validate(request, errors, "reason", "销卡原因", WebUtil.FORMAT_STRING, 128, false);
		return errors;
	}

	protected String getTitle() {
		return "销卡";
	}

}
