package com.pointunion.domain.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class PointChange implements Serializable {
	/**
	 * 已下订单,未确认
	 */
	public final static String STATUS_INIT = "I";

	/**
	 * 已下订单,确认未成功(积分不够)
	 */
	public final static String STATUS_WAIT = "W";

	/**
	 * 订单已确认,等待发货
	 */
	public final static String STATUS_CONFIRM = "C";

	/**
	 * 发货成功
	 */
	public final static String STATUS_SUBMIT = "S";

	/**
	 * 发货未成功
	 */
	public final static String STATUS_SUBMIT_FAIL = "F";

	private Long changeSeq;

	private String accountNo;

	private Integer totalPoint;

	private Integer totalCount;

	private Timestamp changeTime;

	private String address;

	private String zip;

	private String name;

	private String telNo;

	private String mobile;

	private String email;

	private String status;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public PointChange() {
	}

	public PointChange(Long changeSeq, String accountNo, Integer totalPoint, Integer totalCount, Timestamp changeTime, String address, String zip, String name, String telNo, String mobile, String email, String status, Timestamp createTime,
			Timestamp modifyTime) {
		this.changeSeq = changeSeq;
		this.accountNo = accountNo;
		this.totalPoint = totalPoint;
		this.totalCount = totalCount;
		this.changeTime = changeTime;
		this.address = address;
		this.zip = zip;
		this.name = name;
		this.telNo = telNo;
		this.mobile = mobile;
		this.email = email;
		this.status = status;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	public Long getChangeSeq() {
		return changeSeq;
	}

	public void setChangeSeq(Long changeSeq) {
		this.changeSeq = changeSeq;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Timestamp getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Timestamp changeTime) {
		this.changeTime = changeTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
