package com.pointunion.web;

import java.sql.Timestamp;
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

public class RegisterCardController extends ValidateController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = new HashMap();
		result.put("title", "¿¨Æ¬×¢²á");

		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		String accountNo = userSession.getAccount().getAccountNo();

		String cardCategory = WebUtil.getRequestString(request, "metaCard");
		String cardNo = WebUtil.getRequestString(request, "cardNo");
		Timestamp publishTime = WebUtil.getRequestTimestamp(request, "publishDate");

		pointUnion.registerCard(cardNo, cardCategory, accountNo, Card.REQUEST_TYPE_POINTUNION_TRIGGER, publishTime);

		result.put("flag", "0");
		result.put("msg", "");

		request.setAttribute("result", result);
		return new ModelAndView("result");
	}

	protected boolean needCheckSession() {
		return true;
	}

	protected Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "metaCard", "¿¨ÖÖ", WebUtil.FORMAT_STRING, 6, false);
		WebUtil.validate(request, errors, "cardNo", "¿¨ºÅ", WebUtil.FORMAT_STRING, 32, false);
		WebUtil.validate(request, errors, "publishDate", "·¢ÐÐÊ±¼ä", WebUtil.FORMAT_DATE, 10, true);
		return errors;
	}

	protected String getTitle() {
		return "×¢²á¿¨Æ¬";
	}
}
