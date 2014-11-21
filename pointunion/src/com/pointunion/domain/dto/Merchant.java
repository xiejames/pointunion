package com.pointunion.domain.dto;

import java.sql.Timestamp;

public class Merchant extends Counter {
	private String merchantNo;

	private String fatherMerchant;

	private String categoryNo;

	private String merchantName;

	private String province;

	private String city;

	private String intro;

	private String comment;

	private String telNo;

	private String url;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public Merchant() {
	}

	public Merchant(String merchantNo, String fatherMerchant, String categoryNo, String merchantName, String province, String city, String intro, String comment, String telNo, String url, Timestamp createTime, Timestamp modifyTime) {
		this.merchantNo = merchantNo;
		this.fatherMerchant = fatherMerchant;
		this.categoryNo = categoryNo;
		this.merchantName = merchantName;
		this.province = province;
		this.city = city;
		this.intro = intro;
		this.comment = comment;
		this.telNo = telNo;
		this.url = url;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getFatherMerchant() {
		return fatherMerchant;
	}

	public void setFatherMerchant(String fatherMerchant) {
		this.fatherMerchant = fatherMerchant;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
