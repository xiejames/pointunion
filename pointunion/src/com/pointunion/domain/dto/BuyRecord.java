package com.pointunion.domain.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class BuyRecord implements Serializable {
	private Long buySeq;

	private String maNo;

	private String merchantNo;

	private Integer point;

	private Timestamp createTime;

	public BuyRecord() {
	}

	public BuyRecord(Long buySeq, String maNo, String merchantNo, Integer point, Timestamp createTime) {
		this.buySeq = buySeq;
		this.maNo = maNo;
		this.merchantNo = merchantNo;
		this.point = point;
		this.createTime = createTime;
	}

	public Long getBuySeq() {
		return buySeq;
	}

	public void setBuySeq(Long buySeq) {
		this.buySeq = buySeq;
	}

	public String getMaNo() {
		return maNo;
	}

	public void setMaNo(String maNo) {
		this.maNo = maNo;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
