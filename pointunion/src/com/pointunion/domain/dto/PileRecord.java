package com.pointunion.domain.dto;

import java.sql.Timestamp;

public class PileRecord extends Counter {
	/**
	 * 积分类型: 未结算 
	 */
	public static final String PILE_TYPE_PENDING = "E";
	
	/**
	 * 积分类型: 已结算
	 */
	public static final String PILE_TYPE_PILE = "I";

	private Long pileSeq;

	private String maNo;

	private String accountNo;

	private String cardNo;

	private Integer point;

	private String pileType;
	
	private String pileDesc;

	private Timestamp pendingTime;

	private Timestamp pileTime;
	
	private String merchantName;
	
	private String merchantNo;
	
	private String cardName;

	public PileRecord() {
	}

	public PileRecord(Long pileSeq, String maNo, String accountNo, String cardNo, Integer point, String pileType, String pileDesc, Timestamp pendingTime, Timestamp pileTime) {
		this.pileSeq = pileSeq;
		this.maNo = maNo;
		this.accountNo = accountNo;
		this.cardNo = cardNo;
		this.point = point;
		this.pileType = pileType;
		this.pileDesc = pileDesc;
		this.pendingTime = pendingTime;
		this.pileTime = pileTime;
	}

	public Long getPileSeq() {
		return pileSeq;
	}

	public void setPileSeq(Long pileSeq) {
		this.pileSeq = pileSeq;
	}

	public String getMaNo() {
		return maNo;
	}

	public void setMaNo(String maNo) {
		this.maNo = maNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getPileType() {
		return pileType;
	}

	public void setPileType(String pileType) {
		this.pileType = pileType;
	}

	public Timestamp getPendingTime() {
		return pendingTime;
	}

	public void setPendingTime(Timestamp pendingTime) {
		this.pendingTime = pendingTime;
	}

	public Timestamp getPileTime() {
		return pileTime;
	}

	public void setPileTime(Timestamp pileTime) {
		this.pileTime = pileTime;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
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

	public String getPileDesc() {
		return pileDesc;
	}

	public void setPileDesc(String pileDesc) {
		this.pileDesc = pileDesc;
	}

}
