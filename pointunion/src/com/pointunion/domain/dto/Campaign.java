package com.pointunion.domain.dto;

import java.sql.Timestamp;

public class Campaign extends Counter {
	private String campaignNo;

	private String merchantNo;

	private String title;

	private String status;

	private String intro;

	private String comment;

	private Timestamp createTime;

	private Timestamp modifyTime;

	private String merchantName;

	public Campaign() {
	}

	public Campaign(String campaignNo, String merchantNo, String title, String status, String intro, String comment, Timestamp createTime, Timestamp modifyTime) {
		this.campaignNo = campaignNo;
		this.merchantNo = merchantNo;
		this.title = title;
		this.status = status;
		this.intro = intro;
		this.comment = comment;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	public String getCampaignNo() {
		return campaignNo;
	}

	public void setCampaignNo(String campaignNo) {
		this.campaignNo = campaignNo;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
