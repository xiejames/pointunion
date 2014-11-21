package com.pointunion.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.domain.qc.CardQC;
import com.pointunion.web.util.QueryController;
import com.pointunion.web.util.UserSession;

/**
 * @author yanjian
 * @since 10.06.2006
 */

public class QueryCardController  extends QueryController  {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=new HashMap();
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");

		
		CardQC cardQC = new CardQC();
		cardQC.setAccountNo(userSession.getAccount().getAccountNo());
		Collection cards = pointUnion.getCards(cardQC);
				
		result.put("cardList", cards);
		request.setAttribute("result", result);
		
	 	return new ModelAndView("cardList");
	}
	
	protected boolean needCheckSession() {
		return true;
	}

	protected String getTitle() {		
		return "ø®∆¨≤È—Ø";
	}
}
