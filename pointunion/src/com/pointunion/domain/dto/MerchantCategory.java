package com.pointunion.domain.dto;

import java.io.Serializable;

public class MerchantCategory implements Serializable {
	private String mcNo;

	private String name;

	private String intro;

	public MerchantCategory() {
	}

	public MerchantCategory(String mcNo, String name, String intro) {
		this.mcNo = mcNo;
		this.name = name;
		this.intro = intro;
	}

	public String getMcNo() {
		return mcNo;
	}

	public void setMcNo(String mcNo) {
		this.mcNo = mcNo;
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
