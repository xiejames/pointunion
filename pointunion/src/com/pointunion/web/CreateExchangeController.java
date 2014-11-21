package com.pointunion.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.dto.ChangeList;
import com.pointunion.domain.dto.PointChange;
import com.pointunion.domain.dto.PointChangeDetail;
import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.domain.logic.ServiceException;
import com.pointunion.web.util.Cart;
import com.pointunion.web.util.Item;
import com.pointunion.web.util.UserSession;
import com.pointunion.web.util.ValidateController;
import com.pointunion.web.util.WebUtil;

/**
 * 产生一笔兑换记录
 * 
 * @author yanjian
 * @since 10.06.2006
 */

public class CreateExchangeController extends ValidateController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	protected boolean needCheckSession() {
		return true;
	}

	protected Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "address", "地址", WebUtil.FORMAT_STRING, 255, false);
		WebUtil.validate(request, errors, "zip", "邮编", WebUtil.FORMAT_INTEGER, 6, false);
		WebUtil.validate(request, errors, "name", "姓名", WebUtil.FORMAT_STRING, 64, false);
		WebUtil.validate(request, errors, "telNo", "电话号码", WebUtil.FORMAT_TELEPHONE, 20, true);
		WebUtil.validate(request, errors, "mobile", "手机", WebUtil.FORMAT_TELEPHONE, 20, true);
		WebUtil.validate(request, errors, "email", "电子邮件", WebUtil.FORMAT_EMAIL, 64, false);
		
		if(WebUtil.getRequestString(request, "telNo")==null&&WebUtil.getRequestString(request, "mobile")==null){
			errors.add("电话号码和手机号码不可同时为空");
		}
		
		return errors;
	}

	protected String getTitle() {
		return "积分兑换";
	}

	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		Cart cart = Cart.getSessionCart(request.getSession());
		Map result = new HashMap();
		result.put("title", getTitle());

		if (cart.getTotal() > userSession.getAccount().getCurrentPoint().intValue()) {
			result.put("flag", "1");
			result.put("msg", "您的积分不够");
		} else {
			try {
				PointChange pointChange = new PointChange();
				pointChange.setAccountNo(userSession.getAccount().getAccountNo());
				pointChange.setTotalPoint(new Integer(cart.getTotal()));
				pointChange.setTotalCount(new Integer(cart.getCount()));
				pointChange.setAddress(WebUtil.getRequestString(request, "address"));
				pointChange.setZip(WebUtil.getRequestString(request, "zip"));
				pointChange.setName(WebUtil.getRequestString(request, "name"));
				pointChange.setTelNo(WebUtil.getRequestString(request, "telNo"));
				pointChange.setMobile(WebUtil.getRequestString(request, "mobile"));
				pointChange.setEmail(WebUtil.getRequestString(request, "email"));

				PointChangeDetail changeDetail = new PointChangeDetail(pointChange);
				Collection changeList = new ArrayList();
				for (Iterator it = cart.getItems().iterator(); it.hasNext();) {
					Item item = (Item) it.next();
					ChangeList ch = new ChangeList();
					ch.setProductNo(item.getProduct().getProductNo());
					ch.setPoint(new Integer(item.getRealPoint()));
					ch.setCount(new Integer(item.getQuantity()));
					changeList.add(ch);
				}
				changeDetail.setChangeList(changeList);
				pointUnion.addPointChange(changeDetail);
				result.put("flag", "0");
				cart.empty();
				userSession.setAccount(pointUnion.getAccountByAccountNo(userSession.getAccount().getAccountNo()));
			} catch (ServiceException e) {
				result.put("flag", "2");
				result.put("msg", e.getMessage());
			}
		}
		request.setAttribute("result", result);
		return new ModelAndView("result");
	}

}
