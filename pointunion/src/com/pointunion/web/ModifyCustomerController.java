package com.pointunion.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.dto.Customer;
import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.web.util.CityUtil;
import com.pointunion.web.util.UserSession;
import com.pointunion.web.util.ValidateController;
import com.pointunion.web.util.WebUtil;

/**
 * @author yanjian
 * @since 10.06.2006
 */

public class ModifyCustomerController extends ValidateController {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = new HashMap();
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");

		Customer customer = pointUnion.getCustomerByPK(userSession.getCustomer().getCustomerNo());
		customer.setPassword(null);

		if (WebUtil.getRequestString(request, "email") != null) {
			customer.setEmail(WebUtil.getRequestString(request, "email"));
		}
		if (WebUtil.getRequestString(request, "name") != null) {
			customer.setName(WebUtil.getRequestString(request, "name"));
		}
		if (WebUtil.getRequestString(request, "gender") != null) {
			customer.setGender(WebUtil.getRequestString(request, "gender"));
		}
		if (WebUtil.getRequestString(request, "birthday") != null) {
			customer.setBirthday(WebUtil.getRequestString(request, "birthday"));
		}
		if (WebUtil.getRequestString(request, "province") != null) {
			customer.setProvince(WebUtil.getRequestString(request, "province"));
		}
		if (WebUtil.getRequestString(request, "city") != null) {
			customer.setCity(WebUtil.getRequestString(request, "city"));
		}
		if (WebUtil.getRequestString(request, "address") != null) {
			customer.setAddress(WebUtil.getRequestString(request, "address"));
		}
		if (WebUtil.getRequestString(request, "zip") != null) {
			customer.setZip(WebUtil.getRequestString(request, "zip"));
		}
		if (WebUtil.getRequestString(request, "telNo") != null) {
			customer.setTelNo(WebUtil.getRequestString(request, "telNo"));
		}
		if (WebUtil.getRequestString(request, "mobile") != null) {
			customer.setMobile(WebUtil.getRequestString(request, "mobile"));
		}
		if (WebUtil.getRequestString(request, "industry") != null) {
			customer.setIndustry(WebUtil.getRequestString(request, "industry"));
		}
		if (WebUtil.getRequestString(request, "company") != null) {
			customer.setCompany(WebUtil.getRequestString(request, "company"));
		}

		result.put("title", getTitle());

		pointUnion.updateCustomer(customer);
		userSession.setCustomer(pointUnion.getCustomerByPK(customer.getCustomerNo()));
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
		WebUtil.validate(request, errors, "name", "����", WebUtil.FORMAT_STRING, 32, true);
		WebUtil.validate(request, errors, "email", "�����ʼ�", WebUtil.FORMAT_EMAIL, 32, true);
		WebUtil.validate(request, errors, "gender", "����", WebUtil.FORMAT_STRING, 1, true);
		WebUtil.validate(request, errors, "birthday", "��������", WebUtil.FORMAT_DATE, 10, true);
		WebUtil.validate(request, errors, "address", "��ַ", WebUtil.FORMAT_STRING, 128, true);
		WebUtil.validate(request, errors, "zip", "�ʱ�", WebUtil.FORMAT_INTEGER, 6, true);

		WebUtil.validate(request, errors, "telNo", "�绰����", WebUtil.FORMAT_TELEPHONE, 20, true);
		WebUtil.validate(request, errors, "mobile", "�ֻ�", WebUtil.FORMAT_TELEPHONE, 20, true);
		
		WebUtil.validate(request, errors, "industry", "��ҵ", WebUtil.FORMAT_STRING, 20, true);
		WebUtil.validate(request, errors, "company", "��˾", WebUtil.FORMAT_STRING, 64, true);		

		if (!CityUtil.getInstance().validateCode(WebUtil.getRequestString(request, "province"), WebUtil.getRequestString(request, "city"))) {
			errors.add("ʡ�б�������");
		}

		if (WebUtil.getRequestString(request, "telNo") == null && WebUtil.getRequestString(request, "mobile") == null) {
			errors.add("�绰������ֻ����벻��ͬʱΪ��");
		}

		return errors;
	}

	protected String getTitle() {
		return "�޸Ŀͻ���Ϣ";
	}

}
