package com.pointunion.domain.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Account implements Serializable {
	private String accountNo;

	private String customerNo;

	private Integer currentPoint;

	private Integer pendingPoint;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public Account() {
	}

	public Account(String accountNo, String customerNo, Integer currentPoint, Integer pendingPoint, Timestamp createTime, Timestamp modifyTime) {
		this.accountNo = accountNo;
		this.customerNo = customerNo;
		this.currentPoint = currentPoint;
		this.pendingPoint = pendingPoint;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public Integer getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(Integer currentPoint) {
		this.currentPoint = currentPoint;
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
