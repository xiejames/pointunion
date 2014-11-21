package com.pointunion.domain.qc;

public class QueryCondition {
	public static final String ORDER_TYPE_ASC = "A";
	public static final String ORDER_TYPE_DESC = "D";
	
	private Integer startRow;
	private Integer pageSize;
	private String  orderType;
	private String  countFlag;	//不为空，则表示仅仅计算数量
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getCountFlag() {
		return countFlag;
	}
	public void setCountFlag(String countFlag) {
		this.countFlag = countFlag;
	}
}
