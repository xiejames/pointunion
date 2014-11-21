package com.pointunion.web.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Province implements java.io.Serializable {
	private String province;
	private String provinceCode;
	private Map cityMap;
	
	public Province(String province, String provinceCode) {		
		this.province = province;
		this.provinceCode = provinceCode;
		cityMap = new HashMap();
	}
	
	protected Map getCityMap() {
		return cityMap;
	}	
	
	public Collection getCities() {
		return cityMap.values();
	}
	
	
	public String getProvince() {
		return province;
	}

	public String getProvinceCode() {
		return provinceCode;
	}
}
