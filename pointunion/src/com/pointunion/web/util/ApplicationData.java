package com.pointunion.web.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public class ApplicationData implements Serializable {
	private Collection recommendedProducts;
	private Collection recommendedMerchants;
	private Collection recommendedCampaigns;
	private Collection merchantCategories;
	private Collection productCategories;
	private Collection metaCardMerchants;
	private Collection provinces;
	
	private Collection topChangedProducts;
	private Collection topReturnMerchants;
	
	private Map industyMap;

	public Collection getProvinces() {
		return provinces;
	}

	public void setProvinces(Collection provinces) {
		this.provinces = provinces;
	}

	public Collection getMetaCardMerchants() {
		return metaCardMerchants;
	}

	public void setMetaCardMerchants(Collection metaCardMerchants) {
		this.metaCardMerchants = metaCardMerchants; 
	}

	public Collection getMerchantCategories() {
		return merchantCategories;
	}

	public void setMerchantCategories(Collection merchantCategories) {
		this.merchantCategories = merchantCategories;
	}

	public Collection getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(Collection productCategories) {
		this.productCategories = productCategories;
	}

	public Collection getRecommendedProducts() {
		return recommendedProducts;
	}

	public void setRecommendedProducts(Collection recommendedProducts) {
		this.recommendedProducts = recommendedProducts;
	}

	public Collection getRecommendedMerchants() {
		return recommendedMerchants;
	}

	public void setRecommendedMerchants(Collection recommendedMerchants) {
		this.recommendedMerchants = recommendedMerchants;
	}

	public Collection getRecommendedCampaigns() {
		return recommendedCampaigns;
	}

	public void setRecommendedCampaigns(Collection recommendedCampaigns) {
		this.recommendedCampaigns = recommendedCampaigns;
	}
	
	public Map getIndustyMap() {
		return industyMap;
	}

	public void setIndustyMap(Map industyMap) {
		this.industyMap = industyMap;
	}

	public Collection getTopChangedProducts() {
		return topChangedProducts;
	}

	public void setTopChangedProducts(Collection topChangedProducts) {
		this.topChangedProducts = topChangedProducts;
	}

	public Collection getTopReturnMerchants() {
		return topReturnMerchants;
	}

	public void setTopReturnMerchants(Collection topReturnMerchants) {
		this.topReturnMerchants = topReturnMerchants;
	}
}
