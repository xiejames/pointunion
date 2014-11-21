package com.pointunion.domain.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class MerchantAccount implements Serializable {
	private String maNo;

	private String merchantNo;

	private Integer sparePoint;

	private Integer pendingPoint;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public MerchantAccount() {
	}

	public MerchantAccount(String maNo, String merchantNo, Integer sparePoint, Integer pendingPoint, Timestamp createTime, Timestamp modifyTime) {
		this.maNo = maNo;
		this.merchantNo = merchantNo;
		this.sparePoint = sparePoint;
		this.pendingPoint = pendingPoint;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
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

	public Integer getSparePoint() {
		return sparePoint;
	}

	public void setSparePoint(Integer sparePoint) {
		this.sparePoint = sparePoint;
	}

	public Integer getPendingPoint() {
		return pendingPoint;
	}

	public void setPendingPoint(Integer pendingPoint) {
		this.pendingPoint = pendingPoint;
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
