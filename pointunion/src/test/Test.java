package test;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.pointunion.dao.*;
import com.pointunion.domain.*;
import com.pointunion.domain.qc.*;
import com.pointunion.web.SignonController;

public class Test {
	
	
	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getLogger("test");
		logger.debug("=========");
		
		XmlWebApplicationContext ctx;
		String[] paths = { "classpath:/test/applicationContext.xml", 
				"classpath:/test/dataAccessContext-local.xml"};
		ctx = new XmlWebApplicationContext();		

		ctx.setConfigLocations(paths);
		ctx.setServletContext(new MockServletContext("."));
		ctx.refresh();
		
		
		System.out.println("========" + ctx.getResource(".").getFilename());

		//MockHttpServletRequest request = new MockHttpServletRequest(); 
		//MockHttpServletResponse response = new MockHttpServletResponse(); 
		//request.addParameter("userid", "point"); 
		//request.addParameter("password", "point");
		//SignonController c = (SignonController) ctx.getBean("/signon.do"); 
		//ModelAndView mav = c.handleRequest(request, response); 
		//Map m = mav.getModel();
		//   
		
//		CampaignDao campaignDao = (CampaignDao) ctx.getBean("campaignDao");
//		CampaignQC qc = new CampaignQC();
//		//qc.setCampaignKey("р╩");
//		qc.setStartRow(null);
//		qc.setPageSize(new Integer(2));
//		//qc.setTime2(new Timestamp(System.currentTimeMillis()-2100000L));
//		
//		Collection collection = campaignDao.getCampaigns(qc);
//		System.out.println(collection.size());
//		for (Iterator it = collection.iterator(); it.hasNext();) {
//			Campaign e = (Campaign) it.next();
//			System.out.print(e.getCampaignNo()+",");
//			System.out.print(e.getTitle()+",");
//			System.out.println(e.getMerchantName());
//		}
		
//		MerchantDao merchantDao = (MerchantDao) ctx.getBean("merchantDao");
//		MerchantQC qc = new MerchantQC();
//		qc.setMerchantkey("йт");
//		qc.setStartRow(new Integer(2));
//		qc.setPageSize(new Integer(6));
//		//qc.setTime2(new Timestamp(System.currentTimeMillis()-2100000L));
//		
//		Collection collection = merchantDao.getMerchants(qc);
//		System.out.println(collection.size());
//		for (Iterator it = collection.iterator(); it.hasNext();) {
//			Merchant e = (Merchant) it.next();
//			System.out.print(e.getMerchantNo()+",");
//			System.out.print(e.getMerchantName()+",");
//			System.out.print(e.getCategoryNo()+",");
//			System.out.println(e.getCreateTime());
//		}
//		
//		ProductDao productDao = (ProductDao) ctx.getBean("productDao");
//		ProductQC qc = new ProductQC();
//		//qc.setProductKey("1");
//		qc.setPoint1(new Integer(2));
//		//qc.setStartRow(new Integer(0));
//		//qc.setPageSize(new Integer(6));
//		
//		
//		Collection collection = productDao.getProducts(qc);
//		System.out.println(collection.size());
//		for (Iterator it = collection.iterator(); it.hasNext();) {
//			Product e = (Product) it.next();
//			System.out.print(e.getProductNo()+",");
//			System.out.print(e.getName()+",");
//			System.out.print(e.getComment()+",");
//			System.out.println(e.getCreateTime());			
//		}
		SignonController c = (SignonController) ctx.getBean("/signon.do");
//		HttpServletRequest request=new HttpServletRequest();
//		
//		c.handleRequest();
//		Customer customer = customerDao.getCustomer("point", "point");
//		System.out.println(customer.getUserId());
		
	}
}
