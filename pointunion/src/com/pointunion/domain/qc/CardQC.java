/**
 * @author xielingjiang
 * @since 10.06.2006
 */
package com.pointunion.domain.qc;

import java.io.Serializable;
import java.sql.Timestamp;

public class CardQC extends QueryCondition implements Serializable{
	public static final String ORDER_BY_CARD_NO = "1";
	public static final String ORDER_BY_PUBLISH_TIME = "2";
	public static final String ORDER_BY_EFFECT_TIME = "3";
	public static final String ORDER_BY_INEFFECT_TIME = "4";
	public static final String ORDER_BY_MERCHANT_NO = "5";
	
	//帐户编号，状态，发卡时间范围，开卡时间范围，注销时间范围,商户号	
	private String accountNo;
	private String status;
	private Timestamp publishTime1;
	private Timestamp publishTime2;	
	private Timestamp effectTime1;
	private Timestamp effectTime2;	
	private Timestamp ineffectTime1;	
	private Timestamp ineffectTime2;
	private String merchantNo;
	
	private String orderBy;		//排序字段, 1-卡号，2-发卡时间范围，3-开卡时间范围42-注销时间范围,5-商户号	

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Timestamp getEffectTime1() {
		return effectTime1;
	}

	public void setEffectTime1(Timestamp effectTime1) {
		this.effectTime1 = effectTime1;
	}

	public Timestamp getEffectTime2() {
		return effectTime2;
	}

	public void setEffectTime2(Timestamp effectTime2) {
		this.effectTime2 = effectTime2;
	}

	public Timestamp getIneffectTime1() {
		return ineffectTime1;
	}

	public void setIneffectTime1(Timestamp ineffectTime1) {
		this.ineffectTime1 = ineffectTime1;
	}

	public Timestamp getIneffectTime2() {
		return ineffectTime2;
	}

	public void setIneffectTime2(Timestamp ineffectTime2) {
		this.ineffectTime2 = ineffectTime2;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Timestamp getPublishTime1() {
		return publishTime1;
	}

	public void setPublishTime1(Timestamp publishTime1) {
		this.publishTime1 = publishTime1;
	}

	public Timestamp getPublishTime2() {
		return publishTime2;
	}

	public void setPublishTime2(Timestamp publishTime2) {
		this.publishTime2 = publishTime2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}