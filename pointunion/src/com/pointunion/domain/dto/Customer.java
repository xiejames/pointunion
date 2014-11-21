package com.pointunion.domain.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Customer implements Serializable {
	private String customerNo;

	private String userId;

	private String password;

	private String email;

	private String name;

	private String gender;

	private String birthday;

	private String province;

	private String city;

	private String address;

	private String zip;

	private String telNo;

	private String mobile;

	private String industry;

	private String company;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public Customer() {
	}

	public Customer(String customerNo, String userId, String password, String email, String name, String gender, String birthday, String province, String city, String address, String zip, String telNo, String mobile, String industry, String company,
			Timestamp createTime, Timestamp modifyTime) {
		this.customerNo = customerNo;
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.province = province;
		this.city = city;
		this.address = address;
		this.zip = zip;
		this.telNo = telNo;
		this.mobile = mobile;
		this.industry = industry;
		this.company = company;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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
