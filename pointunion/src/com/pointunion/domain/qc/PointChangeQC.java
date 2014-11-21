/**
 * @author xielingjiang
 * @since 10.06.2006
 */
package com.pointunion.domain.qc;

import java.io.Serializable;
import java.sql.Timestamp;

public class PointChangeQC extends QueryCondition implements Serializable{
	public static final String ORDER_BY_ACCOUNT_NO = "1";
	public static final String ORDER_BY_POINT = "2";
	public static final String ORDER_BY_CREATE_TIME = "3";
	
	private String accountNo;
	private Integer point1;
	private Integer point2;
	private Timestamp time1;
	private Timestamp time2;
	private String orderBy;		//排序字段, 1-accountNo, 2-积分, 3-时间
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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
	
}