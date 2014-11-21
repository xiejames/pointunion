package com.pointunion.domain.logic;

import java.sql.Timestamp;
import java.util.Collection;

import com.pointunion.domain.dto.Account;
import com.pointunion.domain.dto.Campaign;
import com.pointunion.domain.dto.Card;
import com.pointunion.domain.dto.ChangeList;
import com.pointunion.domain.dto.Customer;
import com.pointunion.domain.dto.Merchant;
import com.pointunion.domain.dto.PileRecordDetail;
import com.pointunion.domain.dto.PointChange;
import com.pointunion.domain.dto.PointChangeDetail;
import com.pointunion.domain.dto.Product;
import com.pointunion.domain.qc.CampaignQC;
import com.pointunion.domain.qc.CardQC;
import com.pointunion.domain.qc.MerchantQC;
import com.pointunion.domain.qc.PileRecordQC;
import com.pointunion.domain.qc.PointChangeQC;
import com.pointunion.domain.qc.ProductQC;


public interface PointUnionFacade {
	/**
	 * 功能：获得所有的产品种类
	 * 输入：
	 * 输出：Collection
	 */	
	public Collection getProductCategories();
	
	
	/**
	 * 功能：获得所有的商户种类
	 * 输入：
	 * 输出：Collection
	 */		
	public Collection getMerchantCategories();
	
	/**
	 * 功能：获得所有的卡
	 * 输入：
	 * 输出：Collection
	 */	
	public Collection getMetaCards();

	/**
	 * 功能：登录/密码验证
	 * 输入：用户名，密码
	 * 输出：Customer
	 */	
	public Customer signOn(String userId, String password);
	
	
	/**
	 * 功能：客户信息查询
	 * 输入: 用户名
	 * 输出: Customer
	 */
	public Customer getCustomer(String userID);
	
	/**
	 * 功能：客户信息查询
	 * 输入: 用户编号
	 * 输出: Customer
	 */
	public Customer getCustomerByPK(String customerNo);
	
	/**
	 * 功能: 客户信息修改
	 * 输入: 用户名，客户信息
	 */	
	public void updateCustomer(Customer customer);
	
	/**
	 * 功能: 帐户信息查询
	 * 输入: 用户编号
	 * 输出: 帐户信息
	 */	
	public Account getAccountByCustomerNo(String customerNo);
	
	/**
	 * 功能: 帐户信息查询
	 * 输入: 帐户编号
	 * 输出: 帐户信息
	 */
	public Account getAccountByAccountNo(String accountNo);

	/**
	 * 功能: 积分列表 
	 * 输入: 帐户编号，卡号，商户号, 开始时间，结束时间，积分范围	
	 * 输出: 积分列表,PileRecord in Collection
	 */	
	public Collection getPileRecords(PileRecordQC pileRecordQC);
	
	
	/**
	 * 功能: 积分数量查询
	 * 输入: 
	 * 输出: 
	 */
	public int getPileRecordsCount(PileRecordQC pileRecordQC);
	
	
	/**
	 * 功能: 积分明细
	 * 输入: 积分流水号
	 * 输出: 积分明细 二期
	 */	
	public PileRecordDetail getPileRecord(long pileSeq);
	
	/**
	 * 功能: 兑换列表
	 * 输入: 用户编号，开始时间，结束时间，兑换积分范围
	 * 输出: 兑换列表
	 */	
	public Collection getPointChanges(PointChangeQC pointChangeQC);
	
	/**
	 * 功能: 兑换明细
	 * 输入: 兑换流水号
	 * 输出: 兑换记录，兑换商品列表
	 */	
	public PointChangeDetail getPointChange(long changeSeq);
	
	/**
	 * 功能: 挂卡
	 * 输入: 卡号,帐号，申请类型	
	 * 输出: 是否成功	
	 */	
	public boolean registerCard(String cardNo, String cardCategory, String accountNo, String type, Timestamp publishTime);
	
	/**
	 * 功能: 挂卡激活
	 * 输入: 卡号
	 * 输出: 是否成功	
	 */	
	public void effectCard(String cardNo);
	
	/**
	 * 功能: 销卡
	 * 输入: 卡号，原因
	 * 输出: 是否成功	
	 */	
	public void ineffectCard(String cardNo,String reason);
	
	
	/**
	 * 功能: 卡列表
	 * 输入: 
	 * 输出: 兑换列表
	 */	
	public Collection getCards(CardQC cardQC);
	
	/**
	 * 功能: 根据卡号获得卡
	 * 输入: 
	 * 输出: 卡
	 */	
	public Card getCard(String cardNo);
	
	/**
	 * 功能: 取回密码
	 * 输入: 用户名，电子邮件, 新密码种子 
	 * 输出: 是否成功
	 */
	public boolean forgetPassword(String userID, String email, String pwdSeed);	
	

	/**
	 * 功能: 修改密码
	 * 输入: 用户名，密码，新密码
	 * 输出: 是否成功
	 */
	public boolean resetPassword(String userID, String password, String newPassword);
	
	
	/**
	 * 功能: 注册
	 * 输入: 用户名，密码，电子邮件
	 * 输出: 0-成功  1-用户ID已经存在  2-email已经被注册过 
	 */
	public int register(String userID, String password, String email);		
	
		
	/**
	 * 功能: 广告列表
	 * 输入: 
	 * 输出: 
	 */
	public Collection getAdvertisements();
	

	/**
	 * 功能: 兑换商品查询
	 * 输入: 
	 * 输出: 
	 */
	public Collection getProducts(ProductQC productQC);
	
	/**
	 * 功能: 兑换商品数量查询
	 * 输入: 
	 * 输出: 
	 */
	public int getProductsCount(ProductQC productQC);

	/**
	 * 功能: 加盟商户查询
	 * 输入: 
	 * 输出: 
	 */
	public Collection getMerchants(MerchantQC merchantQC);
	
	
	/**
	 * 功能: 加盟商户数量查询
	 * 输入: 
	 * 输出: 
	 */
	public int getMerchantsCount(MerchantQC merchantQC);
	
	
	/**
	 * 功能: 会员活动查询
	 * 输入: 
	 * 输出: 
	 */
	public Collection getCampaigns(CampaignQC campaignQC);
	
	/**
	 * 功能: 会员活动数量查询
	 * 输入: 
	 * 输出: 
	 */
	public int getCampaignsCount(CampaignQC campaignQC);	
	
	
	/**
	 * 功能: 兑换商品查询
	 * 输入: 
	 * 输出: 
	 */
	public Product getProduct(String productNo);

	/**
	 * 功能: 加盟商户查询
	 * 输入: 
	 * 输出: 
	 */
	public Merchant getMerchant(String merchantNo);
	
	
	/**
	 * 功能: 会员活动查询
	 * 输入: 
	 * 输出: 
	 */
	public Campaign getCampaign(String campaignNo );
	
	/**
	 * 功能:	客户积分兑换新增
	 * 输入: 兑换, 兑换明细
	 * 输出: 是否成功
	 */
	public void addPointChange(PointChangeDetail changeDetail);
	
	
	/**
	 * 功能:	客户积分兑换修改
	 * 输入: 兑换
	 */
	public void updatePointChange(PointChange change);
	
	/**
	 * 功能:	客户积分兑换明细新增
	 * 输入: 兑换明细
	 * 输出: 是否成功
	 */
	public void addChangeList(ChangeList changeList);	
	
	/**
	 * 功能:	商户返回积分
	 * 输入: 商户帐号,分数, 积分原因, 卡号
	 */
	public void returnPoint(String maNo, int point, String pileDesc, String cardNo);
	
	/**
	 * 功能:	商户购买积分
	 * 输入: 商户号,商户帐号,分数
	 */
	public void buyPoint(String merchantNo, String maNo, int point);
	
	/**
	 * 功能:	获得奖品兑换排行榜
	 * 输入: 排行榜长度
	 */
	public Collection getTopChangedProducts(int size);
	
	/**
	 * 功能:	商户积分排行榜
	 * 输入: 排行榜长度
	 */
	public Collection getTopReturnMerchants(int size);
}
