package com.pointunion.domain.dto;

import java.io.Serializable;

public class ProductCategory implements Serializable {
	private String pcNo;

	private String name;

	private String intro;

	public ProductCategory() {
	}

	public ProductCategory(String pcNo, String name, String intro) {
		this.pcNo = pcNo;
		this.name = name;
		this.intro = intro;
	}

	public String getPcNo() {
		return pcNo;
	}

	public void setPcNo(String pcNo) {
		this.pcNo = pcNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
}
