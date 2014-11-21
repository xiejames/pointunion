package com.pointunion.domain.dto;

import java.io.Serializable;

public class ChangeList  implements Serializable{
	private Long changeSeq;

	private String productNo;

	private Integer point;

	private Integer count;	

	private String name;

	private String categoryNo;

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ChangeList() {
	}

	public ChangeList(Long changeSeq, String productNo, Integer point, Integer count) {
		this.changeSeq = changeSeq;
		this.productNo = productNo;
		this.point = point;
		this.count = count;
	}

	public Long getChangeSeq() {
		return changeSeq;
	}

	public void setChangeSeq(Long changeSeq) {
		this.changeSeq = changeSeq;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
