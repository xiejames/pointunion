/**
 * @author xielingjiang
 * @since 10.06.2006
 */
package com.pointunion.domain.qc;

import java.io.Serializable;
import java.sql.Timestamp;

public class CampaignQC extends QueryCondition implements Serializable{
	public static final String ORDER_BY_MERCHANT_KEY = "1";
	public static final String ORDER_BY_MERCHANT_CTG = "2";
	public static final String ORDER_BY_CAMPAIGN_KEY = "3";
	public static final String ORDER_BY_CREATE_TIME = "4";
	
	
	private String merchantKey;	//�̻��ؼ���	
	private String merchantCtg;	//�̻�����
	private String campaignKey;	//�ؼ���
	private Timestamp time1;	//ʱ��--��
	private Timestamp time2;	//ʱ��--ֹ
	private String orderBy;		//�����ֶ�, 1-merchantkey, 2-	merchantCtg, 3-campaignKey, 4-ʱ��
	
	public String getCampaignKey() {
		return campaignKey;
	}
	public void setCampaignKey(String campaignKey) {
		this.campaignKey = campaignKey;
	}
	public String getMerchantCtg() {
		return merchantCtg;
	}
	public void setMerchantCtg(String merchantCtg) {
		this.merchantCtg = merchantCtg;
	}
	public String getMerchantKey() {
		return merchantKey;
	}
	public void setMerchantKey(String merchantKey) {
		this.merchantKey = merchantKey;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
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