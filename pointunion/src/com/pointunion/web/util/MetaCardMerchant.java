package com.pointunion.web.util;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import com.pointunion.domain.dto.MetaCard;

public class MetaCardMerchant implements java.io.Serializable {
	private String merchantNo;	
	private String merchantName;
	private Map metaCardMap = new TreeMap();;
	
	
	public MetaCardMerchant(String no, String name) {
		merchantNo = no;
		merchantName = name;
	}	
	
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public Collection getMetaCards() {
		return metaCardMap.values();
	}
	
	public void putMetaCard(String key, MetaCard metaCard) {
		metaCardMap.put(key, metaCard);
	}
	

}
