/**
 * @author xielingjiang
 * @since 10.06.2006
 */
package com.pointunion.domain.qc;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProductQC extends QueryCondition implements Serializable{
	public static final String ORDER_BY_PRODUCT_CTG = "1";
	public static final String ORDER_BY_PRODUCT_KEY = "2";
	public static final String ORDER_BY_POINT = "3";
	public static final String ORDER_BY_CREATE_TIME = "4";	
	
	private String productCtg;	//商品种类
	private String productKey;	//关键字
	private Integer point1;		//积分范围--起
	private Integer point2;		//积分范围--止
	private Timestamp time1;	//时间--起
	private Timestamp time2;	//时间--止
	private String orderBy;		//排序字段, 1-productCtg, 2-	productKey, 3-point, 4-时间
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
	public String getProductCtg() {
		return productCtg;
	}
	public void setProductCtg(String productCtg) {
		this.productCtg = productCtg;
	}
	public String getProductKey() {
		return productKey;
	}
	public void setProductKey(String productKey) {
		this.productKey = productKey;
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