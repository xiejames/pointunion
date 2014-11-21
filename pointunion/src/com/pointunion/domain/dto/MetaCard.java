package com.pointunion.domain.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class MetaCard implements Serializable {
	private String cardCategory;

	private String merchantNo;

	private String cardName;
	
	private String merchantName;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public MetaCard() {
	}

	public MetaCard(String cardCategory, String merchantNo, String cardName, Timestamp createTime, Timestamp modifyTime) {
		this.cardCategory = cardCategory;
		this.merchantNo = merchantNo;
		this.cardName = cardName;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	public String getCardCategory() {
		return cardCategory;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public void setCardCategory(String cardCategory) {
		this.cardCategory = cardCategory;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
