package com.pointunion.web.util;

public class City implements java.io.Serializable {
	private String city;
	private String cityCode;	
	
	public City(String city, String cityCode) {		
		this.city = city;
		this.cityCode = cityCode;
	}
	public String getCity() {
		return city;
	}
	public String getCityCode() {
		return cityCode;
	}
}
