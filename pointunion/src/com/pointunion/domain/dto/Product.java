package com.pointunion.domain.dto;

import java.sql.Timestamp;

public class Product extends Counter {
	private String productNo;

	private String name;

	private String categoryNo;

	private String intro;

	private String comment;

	private Integer point;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public Product() {
	}

	public Product(String productNo, String name, String categoryNo, String intro, String comment, Integer point, Timestamp createTime, Timestamp modifyTime) {
		this.productNo = productNo;
		this.name = name;
		this.categoryNo = categoryNo;
		this.intro = intro;
		this.comment = comment;
		this.point = point;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

}
