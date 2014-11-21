package com.pointunion.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pointunion.domain.dto.PointChangeDetail;
import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.web.util.ValidateController;
import com.pointunion.web.util.WebUtil;

/**
 * @author yanjian
 * @since 10.06.2006
 */

public class GetExchangeController  extends ValidateController  {

	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=new HashMap();
		
		Long changeSeq = WebUtil.getRequestLong(request, "changeSeq");		
		PointChangeDetail detail = pointUnion.getPointChange(changeSeq.longValue());
		if(detail==null){		
			result.put("title", getTitle());
			result.put("flag", "1");
			result.put("msg", "��Ҫ�鿴�Ķһ���ϸ������");			
			request.setAttribute("result", result);						
			return new ModelAndView("result");
		}
		
		result.put("exchange", detail);		
		request.setAttribute("result", result);
	 	return new ModelAndView("exchangeDetailView");
	}
	
	protected boolean needCheckSession(){
		return true;
	}
	
	protected Collection validate(HttpServletRequest request) {
		Collection errors = new ArrayList();
		WebUtil.validate(request, errors, "changeSeq", "�һ����", WebUtil.FORMAT_LONG, 32, false);
		return errors;
	}

	protected String getTitle() {
		return "�һ���ϸ";
	}
}
