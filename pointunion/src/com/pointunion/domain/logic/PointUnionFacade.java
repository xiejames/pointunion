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
	 * ���ܣ�������еĲ�Ʒ����
	 * ���룺
	 * �����Collection
	 */	
	public Collection getProductCategories();
	
	
	/**
	 * ���ܣ�������е��̻�����
	 * ���룺
	 * �����Collection
	 */		
	public Collection getMerchantCategories();
	
	/**
	 * ���ܣ�������еĿ�
	 * ���룺
	 * �����Collection
	 */	
	public Collection getMetaCards();

	/**
	 * ���ܣ���¼/������֤
	 * ���룺�û���������
	 * �����Customer
	 */	
	public Customer signOn(String userId, String password);
	
	
	/**
	 * ���ܣ��ͻ���Ϣ��ѯ
	 * ����: �û���
	 * ���: Customer
	 */
	public Customer getCustomer(String userID);
	
	/**
	 * ���ܣ��ͻ���Ϣ��ѯ
	 * ����: �û����
	 * ���: Customer
	 */
	public Customer getCustomerByPK(String customerNo);
	
	/**
	 * ����: �ͻ���Ϣ�޸�
	 * ����: �û������ͻ���Ϣ
	 */	
	public void updateCustomer(Customer customer);
	
	/**
	 * ����: �ʻ���Ϣ��ѯ
	 * ����: �û����
	 * ���: �ʻ���Ϣ
	 */	
	public Account getAccountByCustomerNo(String customerNo);
	
	/**
	 * ����: �ʻ���Ϣ��ѯ
	 * ����: �ʻ����
	 * ���: �ʻ���Ϣ
	 */
	public Account getAccountByAccountNo(String accountNo);

	/**
	 * ����: �����б� 
	 * ����: �ʻ���ţ����ţ��̻���, ��ʼʱ�䣬����ʱ�䣬���ַ�Χ	
	 * ���: �����б�,PileRecord in Collection
	 */	
	public Collection getPileRecords(PileRecordQC pileRecordQC);
	
	
	/**
	 * ����: ����������ѯ
	 * ����: 
	 * ���: 
	 */
	public int getPileRecordsCount(PileRecordQC pileRecordQC);
	
	
	/**
	 * ����: ������ϸ
	 * ����: ������ˮ��
	 * ���: ������ϸ ����
	 */	
	public PileRecordDetail getPileRecord(long pileSeq);
	
	/**
	 * ����: �һ��б�
	 * ����: �û���ţ���ʼʱ�䣬����ʱ�䣬�һ����ַ�Χ
	 * ���: �һ��б�
	 */	
	public Collection getPointChanges(PointChangeQC pointChangeQC);
	
	/**
	 * ����: �һ���ϸ
	 * ����: �һ���ˮ��
	 * ���: �һ���¼���һ���Ʒ�б�
	 */	
	public PointChangeDetail getPointChange(long changeSeq);
	
	/**
	 * ����: �ҿ�
	 * ����: ����,�ʺţ���������	
	 * ���: �Ƿ�ɹ�	
	 */	
	public boolean registerCard(String cardNo, String cardCategory, String accountNo, String type, Timestamp publishTime);
	
	/**
	 * ����: �ҿ�����
	 * ����: ����
	 * ���: �Ƿ�ɹ�	
	 */	
	public void effectCard(String cardNo);
	
	/**
	 * ����: ����
	 * ����: ���ţ�ԭ��
	 * ���: �Ƿ�ɹ�	
	 */	
	public void ineffectCard(String cardNo,String reason);
	
	
	/**
	 * ����: ���б�
	 * ����: 
	 * ���: �һ��б�
	 */	
	public Collection getCards(CardQC cardQC);
	
	/**
	 * ����: ���ݿ��Ż�ÿ�
	 * ����: 
	 * ���: ��
	 */	
	public Card getCard(String cardNo);
	
	/**
	 * ����: ȡ������
	 * ����: �û����������ʼ�, ���������� 
	 * ���: �Ƿ�ɹ�
	 */
	public boolean forgetPassword(String userID, String email, String pwdSeed);	
	

	/**
	 * ����: �޸�����
	 * ����: �û��������룬������
	 * ���: �Ƿ�ɹ�
	 */
	public boolean resetPassword(String userID, String password, String newPassword);
	
	
	/**
	 * ����: ע��
	 * ����: �û��������룬�����ʼ�
	 * ���: 0-�ɹ�  1-�û�ID�Ѿ�����  2-email�Ѿ���ע��� 
	 */
	public int register(String userID, String password, String email);		
	
		
	/**
	 * ����: ����б�
	 * ����: 
	 * ���: 
	 */
	public Collection getAdvertisements();
	

	/**
	 * ����: �һ���Ʒ��ѯ
	 * ����: 
	 * ���: 
	 */
	public Collection getProducts(ProductQC productQC);
	
	/**
	 * ����: �һ���Ʒ������ѯ
	 * ����: 
	 * ���: 
	 */
	public int getProductsCount(ProductQC productQC);

	/**
	 * ����: �����̻���ѯ
	 * ����: 
	 * ���: 
	 */
	public Collection getMerchants(MerchantQC merchantQC);
	
	
	/**
	 * ����: �����̻�������ѯ
	 * ����: 
	 * ���: 
	 */
	public int getMerchantsCount(MerchantQC merchantQC);
	
	
	/**
	 * ����: ��Ա���ѯ
	 * ����: 
	 * ���: 
	 */
	public Collection getCampaigns(CampaignQC campaignQC);
	
	/**
	 * ����: ��Ա�������ѯ
	 * ����: 
	 * ���: 
	 */
	public int getCampaignsCount(CampaignQC campaignQC);	
	
	
	/**
	 * ����: �һ���Ʒ��ѯ
	 * ����: 
	 * ���: 
	 */
	public Product getProduct(String productNo);

	/**
	 * ����: �����̻���ѯ
	 * ����: 
	 * ���: 
	 */
	public Merchant getMerchant(String merchantNo);
	
	
	/**
	 * ����: ��Ա���ѯ
	 * ����: 
	 * ���: 
	 */
	public Campaign getCampaign(String campaignNo );
	
	/**
	 * ����:	�ͻ����ֶһ�����
	 * ����: �һ�, �һ���ϸ
	 * ���: �Ƿ�ɹ�
	 */
	public void addPointChange(PointChangeDetail changeDetail);
	
	
	/**
	 * ����:	�ͻ����ֶһ��޸�
	 * ����: �һ�
	 */
	public void updatePointChange(PointChange change);
	
	/**
	 * ����:	�ͻ����ֶһ���ϸ����
	 * ����: �һ���ϸ
	 * ���: �Ƿ�ɹ�
	 */
	public void addChangeList(ChangeList changeList);	
	
	/**
	 * ����:	�̻����ػ���
	 * ����: �̻��ʺ�,����, ����ԭ��, ����
	 */
	public void returnPoint(String maNo, int point, String pileDesc, String cardNo);
	
	/**
	 * ����:	�̻��������
	 * ����: �̻���,�̻��ʺ�,����
	 */
	public void buyPoint(String merchantNo, String maNo, int point);
	
	/**
	 * ����:	��ý�Ʒ�һ����а�
	 * ����: ���а񳤶�
	 */
	public Collection getTopChangedProducts(int size);
	
	/**
	 * ����:	�̻��������а�
	 * ����: ���а񳤶�
	 */
	public Collection getTopReturnMerchants(int size);
}
