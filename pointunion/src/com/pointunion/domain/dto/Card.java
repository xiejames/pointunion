package com.pointunion.domain.dto;

import java.sql.Timestamp;

public class Card extends MetaCard {
	/**
	 * 卡片状态：0-注册未激活
	 */
	public static final String STATUS_REGISTER = "0";

	/**
	 * 卡片状态：1-开卡激活
	 */
	public static final String STATUS_EFFECT = "1";

	/**
	 * 卡片状态：2-注销
	 */
	public static final String STATUS_INEFFECT = "2";
	
	
	/**
	 * 卡片注册类型：C- 客户在积分联盟注册
	 */	
	public static final String REQUEST_TYPE_POINTUNION_TRIGGER = "P";
	
	
	/**
	 * 卡片注册类型：M- 客户在商户处注册
	 */	
	public static final String REQUEST_TYPE_MERCHANT_TRIGGER = "M";
	

	private String cardNo;

	private String cardCategory;

	private String accountNo;

	private String requestType;

	private String status;

	private Timestamp publishTime;

	private Timestamp effectTime;

	private Timestamp ineffectTime;

	private String ineffectReason;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public Card() {
	}

	public Card(String cardNo, String cardCategory, String accountNo, String requestType, String status, Timestamp publishTime, Timestamp effectTime, Timestamp ineffectTime, String ineffectReason, Timestamp createTime, Timestamp modifyTime) {
		this.cardNo = cardNo;
		this.cardCategory = cardCategory;
		this.accountNo = accountNo;
		this.requestType = requestType;
		this.status = status;
		this.publishTime = publishTime;
		this.effectTime = effectTime;
		this.ineffectTime = ineffectTime;
		this.ineffectReason = ineffectReason;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardCategory() {
		return cardCategory;
	}

	public void setCardCategory(String cardCategory) {
		this.cardCategory = cardCategory;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * 获取卡片状态：定义见类中常量
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置卡片状态：定义见类中常量
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public Timestamp getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(Timestamp effectTime) {
		this.effectTime = effectTime;
	}

	public Timestamp getIneffectTime() {
		return ineffectTime;
	}

	public void setIneffectTime(Timestamp ineffectTime) {
		this.ineffectTime = ineffectTime;
	}

	public String getIneffectReason() {
		return ineffectReason;
	}

	public void setIneffectReason(String ineffectReason) {
		this.ineffectReason = ineffectReason;
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
