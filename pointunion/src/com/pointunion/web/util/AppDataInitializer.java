package com.pointunion.web.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import com.pointunion.domain.dto.MetaCard;
import com.pointunion.domain.logic.PointUnionFacade;
import com.pointunion.domain.qc.CampaignQC;
import com.pointunion.domain.qc.MerchantQC;
import com.pointunion.domain.qc.ProductQC;

/**
 * @author xielingjiang
 * @since 10.06.2006
 */

public class AppDataInitializer implements Serializable {
	private static Logger logger = Logger.getLogger("PointUnionWebLogger");
	
	private PointUnionFacade pointUnion;

	public void setpointUnion(PointUnionFacade pointUnion) {
		this.pointUnion = pointUnion;
	}

	public void init(ServletContext context){
		logger.debug("AppDataInitializer init begin");
		ApplicationData appData = new ApplicationData();
		ProductQC productQC = new ProductQC();
		CampaignQC campaignQC = new CampaignQC();
		MerchantQC merchantQC = new MerchantQC();
		
		productQC.setPageSize(new Integer(6));
		campaignQC.setPageSize(new Integer(6));
		merchantQC.setPageSize(new Integer(6));
		
		appData.setRecommendedProducts(pointUnion.getProducts(productQC));		
		appData.setRecommendedCampaigns(pointUnion.getCampaigns(campaignQC));
		appData.setRecommendedMerchants(pointUnion.getMerchants(merchantQC));
		appData.setMerchantCategories(pointUnion.getMerchantCategories());
		appData.setProductCategories(pointUnion.getProductCategories());		
		appData.setMetaCardMerchants(initMetaCardMerchants(pointUnion.getMetaCards()));
		appData.setProvinces(CityUtil.getInstance().getProvinces());
		appData.setIndustyMap(CommomParamUtil.getInstance().getIndustyMap());
		appData.setTopChangedProducts(pointUnion.getTopChangedProducts(5));
		appData.setTopReturnMerchants(pointUnion.getTopReturnMerchants(5));
		
		context.setAttribute("appData", appData);
		context.setAttribute("title", "积分联盟--让我们享受每一分");
		context.setAttribute("appInitBean", this);
		logger.debug("AppDataInitializer init ok.");
	}
	
	private Collection initMetaCardMerchants(Collection metaCards){
		Map merchantMap = new TreeMap();
		for (Iterator it = metaCards.iterator(); it.hasNext();) {
			MetaCard metaCard = (MetaCard) it.next();
			MetaCardMerchant metaCardMerchant = (MetaCardMerchant) merchantMap.get(metaCard.getMerchantNo());
			if (metaCardMerchant == null) {
				metaCardMerchant = new MetaCardMerchant(metaCard.getMerchantNo(), metaCard.getMerchantName());
				merchantMap.put(metaCard.getMerchantNo(), metaCardMerchant);
			}
			metaCardMerchant.putMetaCard(metaCard.getCardCategory(), metaCard);
		}
		
		for (Iterator it = merchantMap.values().iterator(); it.hasNext();) {
			MetaCardMerchant m = (MetaCardMerchant) it.next();
			logger.debug(m.getMerchantNo() + "\t" + m.getMerchantName());
			for (Iterator j = m.getMetaCards().iterator(); j.hasNext();) {
				MetaCard c = (MetaCard) j.next();
				logger.debug("\t" + c.getCardCategory() + "\t" + c.getCardName());
			}
		}
		logger.debug("init MetaCardMerchants ok");
		return merchantMap.values();
	}	
}
