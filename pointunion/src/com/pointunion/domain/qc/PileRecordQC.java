/**
 * @author xielingjiang
 * @since 10.06.2006
 */
package com.pointunion.domain.qc;

import java.io.Serializable;
import java.sql.Timestamp;

public class PileRecordQC extends QueryCondition implements Serializable{
	public static final String ORDER_BY_CARD_NO = "1";
	public static final String ORDER_BY_MERCHANT_NO = "2";
	public static final String ORDER_BY_PILE_TYPE = "3";
	public static final String ORDER_BY_POINT = "4";
	public static final String ORDER_BY_CREATE_TIME = "5";
	
	private String accountNo; 
	private String cardNo; 
	private String merchantNo;
	private String maNo;
	private Timestamp time1; 
	private Timestamp time2; 
	private Integer point1; 
	private Integer point2;	
	private String pileType;
	
	private String orderBy;		//排序字段, 1-cardNo, 2-merchantNo, 3-pileType, 4-积点, 5-时间
	
	public String getPileType() {
		return pileType;
	}
	public void setPileType(String pileType) {
		this.pileType = pileType;
	}
	public Timestamp getTime1() {
		return time1;
	}
	public void setTime1(Timestamp time1) {
		this.time1 = time1;
	}
	public Timestamp getTime2() {
		return time2;
	}
	public void setTime2(Timestamp time2) {
		this.time2 = time2;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}	
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getPoint1() {
		return point1;
	}
	public void setPoint1(Integer point1) {
		this.point1 = point1;
	}
	public Integer getPoint2() {
		return point2;
	}
	public void setPoint2(Integer point2) {
		this.point2 = point2;
	}
	public String getMaNo() {
		return maNo;
	}
	public void setMaNo(String maNo) {
		this.maNo = maNo;
	}
}