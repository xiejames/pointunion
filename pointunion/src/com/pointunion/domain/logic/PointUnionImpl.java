package com.pointunion.domain.logic;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.pointunion.dao.AccountDao;
import com.pointunion.dao.BuyRecordDao;
import com.pointunion.dao.CampaignDao;
import com.pointunion.dao.CardDao;
import com.pointunion.dao.ChangeListDao;
import com.pointunion.dao.CustomerDao;
import com.pointunion.dao.MerchantAccountDao;
import com.pointunion.dao.MerchantCategoryDao;
import com.pointunion.dao.MerchantDao;
import com.pointunion.dao.MetaCardDao;
import com.pointunion.dao.PileRecordDao;
import com.pointunion.dao.PointChangeDao;
import com.pointunion.dao.ProductCategoryDao;
import com.pointunion.dao.ProductDao;
import com.pointunion.domain.dto.Account;
import com.pointunion.domain.dto.BuyRecord;
import com.pointunion.domain.dto.Campaign;
import com.pointunion.domain.dto.Card;
import com.pointunion.domain.dto.ChangeList;
import com.pointunion.domain.dto.Customer;
import com.pointunion.domain.dto.Merchant;
import com.pointunion.domain.dto.MerchantAccount;
import com.pointunion.domain.dto.PileRecord;
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

public class PointUnionImpl implements PointUnionFacade {

	private CustomerDao customerDao;

	private ChangeListDao changeListDao;

	private PileRecordDao pileRecordDao;

	private PointChangeDao pointChangeDao;

	private ProductDao productDao;

	private BuyRecordDao buyRecordDao;

	private CampaignDao campaignDao;

	private MerchantAccountDao merchantAccountDao;

	private CardDao cardDao;

	private AccountDao accountDao;

	private MetaCardDao metaCardDao;

	private MerchantDao merchantDao;

	private MerchantCategoryDao merchantCategoryDao;

	private ProductCategoryDao productCategoryDao;

	private MailSender mailSender;

	private Logger logger = Logger.getLogger("PointUnionLogger");

	private Logger auditor = Logger.getLogger("PointUnionAuditor");

	// -------------------------------------------------------------------------
	// Setter methods for dependency injection
	// -------------------------------------------------------------------------
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setBuyRecordDao(BuyRecordDao buyRecordDao) {
		this.buyRecordDao = buyRecordDao;
	}

	public void setCampaignDao(CampaignDao campaignDao) {
		this.campaignDao = campaignDao;
	}

	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}

	public void setChangeListDao(ChangeListDao changeListDao) {
		this.changeListDao = changeListDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setMerchantAccountDao(MerchantAccountDao merchantAccountDao) {
		this.merchantAccountDao = merchantAccountDao;
	}

	public void setMerchantCategoryDao(MerchantCategoryDao merchantCategoryDao) {
		this.merchantCategoryDao = merchantCategoryDao;
	}

	public void setProductCategoryDao(ProductCategoryDao productCategoryDao) {
		this.productCategoryDao = productCategoryDao;
	}

	public void setMerchantDao(MerchantDao merchantDao) {
		this.merchantDao = merchantDao;
	}

	public void setMetaCardDao(MetaCardDao metaCardDao) {
		this.metaCardDao = metaCardDao;
	}

	public void setPileRecordDao(PileRecordDao pileRecordDao) {
		this.pileRecordDao = pileRecordDao;
	}

	public void setPointChangeDao(PointChangeDao pointChangeDao) {
		this.pointChangeDao = pointChangeDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	// /////////////////

	public Collection getProductCategories() {
		return productCategoryDao.getProductCategories();
	}

	public Collection getMerchantCategories() {
		return merchantCategoryDao.getMerchantCategories();
	}

	public Collection getMetaCards() {
		return metaCardDao.getMetaCards();
	}
	
	public Customer signOn(String userId, String password) {
		try {
			Customer c = customerDao.getCustomer(userId, password);
			if (c != null) {
				c.setPassword(null);
			}
			return c;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Customer getCustomer(String userID) {
		try {
			Customer c = customerDao.getCustomer(userID);
			if (c != null) {
				c.setPassword(null);
			}
			return c;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Customer getCustomerByPK(String customerNo) {
		try {
			Customer c = customerDao.getCustomerByPK(customerNo);
			if (c != null) {
				c.setPassword(null);
			}
			return c;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public void updateCustomer(Customer customer) {
		try {
			customerDao.updateCustomer(customer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Account getAccountByCustomerNo(String customerNo) {
		try {
			return accountDao.getAccountByCustomerNo(customerNo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Account getAccountByAccountNo(String accountNo) {
		try {
			return accountDao.getAccountByPK(accountNo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Collection getPileRecords(PileRecordQC pileRecordQC) {
		try {
			return pileRecordDao.getPileRecords(pileRecordQC);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}
	
	public int getPileRecordsCount(PileRecordQC pileRecordQC){
		try {
			return pileRecordDao.getPileRecordsCount(pileRecordQC);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public PileRecordDetail getPileRecord(long pileSeq) {
		// TODO 二期实现
		return null;
	}

	public Collection getPointChanges(PointChangeQC pointChangeQC) {
		try {
			return pointChangeDao.getPointChanges(pointChangeQC);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public PointChangeDetail getPointChange(long changeSeq) {
		try {
			PointChangeDetail detail = new PointChangeDetail();
			detail.setPointChange(pointChangeDao.getPointChangeByPK(new Long(changeSeq)));
			Collection list = changeListDao.getChangeListBySeq(new Long(changeSeq));
			detail.setChangeList(list);
			return detail;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public boolean registerCard(String cardNo, String cardCategory, String accountNo, String type, Timestamp publishTime) {
		try {
			if (cardDao.getCardByPK(cardNo) != null) {
				return false;
			}

			Card card = new Card();
			card.setAccountNo(accountNo);
			card.setCardCategory(cardCategory);
			card.setCardNo(cardNo);
			card.setRequestType(type);
			card.setStatus(Card.STATUS_REGISTER);
			card.setPublishTime(publishTime);
			cardDao.insertCard(card);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public void effectCard(String cardNo) {
		try {
			Card card = cardDao.getCardByPK(cardNo);
			if (Card.STATUS_EFFECT.equals(card.getStatus())) {
				throw new ServiceException("该卡目前已激活. CardNo=" + cardNo);
			}

			card.setStatus(Card.STATUS_EFFECT);
			card.setEffectTime(new Timestamp(System.currentTimeMillis()));
			cardDao.updateCard(card);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public void ineffectCard(String cardNo, String reason) {
		try {
			Card card = cardDao.getCardByPK(cardNo);
			if (!Card.STATUS_EFFECT.equals(card.getStatus())) {
				throw new ServiceException("该卡目前尚未激活,无法注销. CardNo=" + cardNo);
			}

			card.setStatus(Card.STATUS_INEFFECT);
			card.setIneffectReason(reason);
			card.setIneffectTime(new Timestamp(System.currentTimeMillis()));
			cardDao.updateCard(card);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Collection getCards(CardQC cardQC) {
		try {
			return cardDao.getCards(cardQC);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}
	
	public Card getCard(String cardNo){
		try {
			return cardDao.getCardByPK(cardNo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public boolean forgetPassword(String userID, String email, String pwdSeed) {
		try {
			Customer c = customerDao.getCustomer(userID);
			if (c == null) {
				return false;
			}

			if (!email.trim().equalsIgnoreCase(c.getEmail().trim())) {
				return false;
			}

			String newPwd = SequenceGenerator.getInstnce().nextPassword();
			
			c.setPassword(pwdSeed + newPwd);
			customerDao.updateCustomer(c);

			sendEmail("point@point.com", email.trim(), "取回密码", "新密码后半部分:" + newPwd);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public boolean resetPassword(String userID, String password, String newPassword) {
		try {
			Customer c = customerDao.getCustomer(userID, password);
			if (c == null) {
				return false;
			}
			c.setPassword(newPassword);
			customerDao.updateCustomer(c);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	private Object registerLock = new Object();

	// 0-成功 1-用户ID已经存在 2-email已经被注册过
	public int register(String userID, String password, String email) {
		synchronized (registerLock) {
			try {
				if (customerDao.getCustomer(userID) != null) {
					return 1;
				}

				if (customerDao.getCustomerByEmail(email) != null) {
					return 2;
				}

				Customer customer = new Customer();
				customer.setCustomerNo(SequenceGenerator.getInstnce().nextCustomerNo());
				customer.setUserId(userID);
				customer.setPassword(password);
				customer.setEmail(email);

				Account account = new Account();
				account.setAccountNo(SequenceGenerator.getInstnce().nextAccountNo());
				account.setCustomerNo(customer.getCustomerNo());
				account.setCurrentPoint(new Integer(0));
				account.setPendingPoint(new Integer(0));

				customerDao.insertCustomer(customer);
				accountDao.insertAccount(account);
				
				registerCard(account.getAccountNo(),"A00001", account.getAccountNo(), "P", null);
				returnPoint("00000001", 1000, "注册联盟会员获得积分", account.getAccountNo());
				
				sendEmail("point@point.com", email.trim(), "恭喜你注册成功", "尊敬的"+customer.getUserId()+",你的客户编号是"+ customer.getCustomerNo());
				return 0;
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new ServiceException(e);
			}
		}
	}

	public Collection getRecommendedProducts() {
		try {
			ProductQC qc = new ProductQC();
			qc.setPageSize(new Integer(6));
			return getProducts(qc);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}	

	public Collection getAdvertisements() {
		// TODO 二期实现
		return null;
	}

	public Collection getProducts(ProductQC productQC) {
		try {
			return productDao.getProducts(productQC);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public int getProductsCount(ProductQC productQC) {
		try {
			return productDao.getProductsCount(productQC);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Collection getMerchants(MerchantQC merchantQC) {
		try {
			return merchantDao.getMerchants(merchantQC);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public int getMerchantsCount(MerchantQC merchantQC) {
		try {
			return merchantDao.getMerchantsCount(merchantQC);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Collection getCampaigns(CampaignQC campaignQC) {
		try {
			return campaignDao.getCampaigns(campaignQC);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public int getCampaignsCount(CampaignQC campaignQC) {
		try {
			return campaignDao.getCampaignsCount(campaignQC);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Product getProduct(String productNo) {
		try {
			return productDao.getProductByPK(productNo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Merchant getMerchant(String merchantNo) {
		try {
			return merchantDao.getMerchantByPK(merchantNo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Campaign getCampaign(String campaignNo) {
		try {
			return campaignDao.getCampaignByPK(campaignNo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public void sendEmail(String from, String to, String subject, String text) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setTo(to);
			mailMessage.setFrom(from);
			mailMessage.setSubject(subject);
			mailMessage.setText(text);
			mailSender.send(mailMessage);
		} catch (MailException e) {
			logger.error("EMAIL发送不成功", e);
			throw new ServiceException("EMAIL发送不成功", e);
		}
	}

	public void addPointChange(PointChangeDetail changeDetail) {
		try {
			// 检查total和list中point是否一致
			int totalPoint = 0;
			int totalCount = 0;
			for (Iterator it = changeDetail.getChangeList().iterator(); it.hasNext();) {
				ChangeList e = (ChangeList) it.next();
				totalPoint += e.getPoint().intValue() * e.getCount().intValue();
				totalCount += e.getCount().intValue();
			}
			if (totalPoint != changeDetail.getTotalPoint().intValue()) {
				throw new ServiceException("兑换物品总点数和各物品点数之和不一致");
			}

			if (totalCount != changeDetail.getTotalCount().intValue()) {
				throw new ServiceException("兑换物品总数和各物品个数之和不一致");
			}

			changeDetail.setChangeSeq(new Long(SequenceGenerator.getInstnce().nextChangeSeq()));
			changeDetail.setStatus(PointChange.STATUS_CONFIRM);	
			pointChangeDao.insertPointChange(changeDetail);

			for (Iterator it = changeDetail.getChangeList().iterator(); it.hasNext();) {
				ChangeList e = (ChangeList) it.next();
				e.setChangeSeq(changeDetail.getChangeSeq());
				changeListDao.insertChangeList(e);
			}

			Account acct = accountDao.getAccountByPK(changeDetail.getAccountNo());
			if (acct.getCurrentPoint().intValue() < totalPoint) {
				throw new ServiceException("客户可兑积分小于当前选择物品总积分,客户号=" + acct.getAccountNo());
			}

			acct.setCurrentPoint(new Integer(acct.getCurrentPoint().intValue() - totalPoint));
			accountDao.updateAccount(acct);

			auditor.trace("[积点兑换] 帐号=" + changeDetail.getAccountNo() + ", 积点=" + totalPoint + ", 数量=" + totalCount + ", CHANGE_SEQ=" + changeDetail.getChangeSeq());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public void updatePointChange(PointChange change) {
		try {
			PointChange newPointChange = pointChangeDao.getPointChangeByPK(change.getChangeSeq());

			// newPointChange.setChangeSeq(change.getChangeSeq());
			// newPointChange.setAccountNo(change.getAccountNo());
			// newPointChange.setTotalPoint(change.getTotalPoint());
			// newPointChange.setTotalCount(change.getTotalCount());
			newPointChange.setChangeTime(change.getChangeTime());
			newPointChange.setAddress(change.getAddress());
			newPointChange.setZip(change.getZip());
			newPointChange.setName(change.getName());
			newPointChange.setTelNo(change.getTelNo());
			newPointChange.setMobile(change.getMobile());
			newPointChange.setStatus(change.getStatus());

			pointChangeDao.updatePointChange(newPointChange);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public void addChangeList(ChangeList changeList) {
		try {
			PointChange newPointChange = pointChangeDao.getPointChangeByPK(changeList.getChangeSeq());
			newPointChange.setTotalPoint(new Integer(newPointChange.getTotalPoint().intValue() + changeList.getPoint().intValue() * changeList.getCount().intValue()));
			newPointChange.setTotalCount(new Integer(newPointChange.getTotalCount().intValue() + changeList.getCount().intValue()));

			Account acct = accountDao.getAccountByPK(newPointChange.getAccountNo());
			if (acct.getCurrentPoint().intValue() < changeList.getPoint().intValue() * changeList.getCount().intValue()) {
				throw new ServiceException("客户可兑积分小于当前选择物品总积分,客户号=" + acct.getAccountNo());
			}

			changeListDao.insertChangeList(changeList);
			pointChangeDao.updatePointChange(newPointChange);
			accountDao.updateAccount(acct);
			auditor.trace("[积点兑换 增加记录] 帐号=" + newPointChange.getAccountNo() + ", 商品代号=" + changeList.getProductNo() + ", 积点=" + changeList.getPoint().intValue() * changeList.getCount().intValue() + ", 数量=" + changeList.getCount() + ", CHANGE_SEQ="
					+ newPointChange.getChangeSeq());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public void returnPoint(String maNo, int point, String pileDesc, String cardNo) {
		try {
			Card card = cardDao.getCardByPK(cardNo);
			Account acct = accountDao.getAccountByPK(card.getAccountNo());
			MerchantAccount ma = merchantAccountDao.getMerchantAccountByPK(maNo);
			PileRecord pileRecord = new PileRecord();
			pileRecord.setAccountNo(acct.getAccountNo());
			pileRecord.setCardNo(cardNo);
			pileRecord.setMaNo(maNo);
			pileRecord.setPoint(new Integer(point));
			pileRecord.setPileDesc(pileDesc);

			if (ma.getSparePoint().intValue() < point) {
				acct.setPendingPoint(new Integer(acct.getPendingPoint().intValue() + point));
				ma.setPendingPoint(new Integer(ma.getPendingPoint().intValue() + point));
				pileRecord.setPileType(PileRecord.PILE_TYPE_PENDING);
				pileRecord.setPendingTime(new Timestamp(System.currentTimeMillis()));
			} else {
				acct.setCurrentPoint(new Integer(acct.getCurrentPoint().intValue() + point));
				ma.setSparePoint(new Integer(ma.getSparePoint().intValue() - point));
				pileRecord.setPileType(PileRecord.PILE_TYPE_PILE);
				pileRecord.setPileTime(new Timestamp(System.currentTimeMillis()));
			}

			accountDao.updateAccount(acct);
			merchantAccountDao.updateMerchantAccount(ma);
			pileRecordDao.insertPileRecord(pileRecord);
			auditor.trace("[积点返还] 商户帐号=" + maNo + ", 积点=" + point + ", 卡号=" + cardNo + ", 种类=" + pileRecord.getPileType());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public void buyPoint(String merchantNo, String maNo, int point) {
		try {
			MerchantAccount ma = merchantAccountDao.getMerchantAccountByPK(maNo);
			BuyRecord buyRecord = new BuyRecord();
			buyRecord.setMerchantNo(merchantNo);
			buyRecord.setMaNo(maNo);
			buyRecord.setPoint(new Integer(point));
			buyRecord.setCreateTime(new Timestamp(System.currentTimeMillis()));
			buyRecordDao.insertBuyRecord(buyRecord);

			PileRecordQC pileRecordQC = new PileRecordQC();
			pileRecordQC.setMaNo(maNo);
			pileRecordQC.setPileType(PileRecord.PILE_TYPE_PENDING);
			pileRecordQC.setOrderBy(PileRecordQC.ORDER_BY_CREATE_TIME);

			Collection list = pileRecordDao.getPileRecords(pileRecordQC);
			int totalPending = 0;
			for (Iterator it = list.iterator(); it.hasNext();) {
				PileRecord p = (PileRecord) it.next();
				totalPending += p.getPoint().intValue();
			}

			if (totalPending != ma.getPendingPoint().intValue()) {
				logger.warn("该商户帐户的Pending Point总数和PileRecord表中的对应值之和不平, 商户号=" + ma.getMerchantNo() + ", 商户帐号=" + ma.getMaNo());
			}

			int sparePoint = point + ma.getSparePoint().intValue();
			// ma.getPendingPoint().intValue()>0 &&
			// ma.getPendingPoint().intValue()<point
			for (Iterator it = list.iterator(); it.hasNext();) {
				PileRecord p = (PileRecord) it.next();
				if (sparePoint >= p.getPoint().intValue()) {
					sparePoint -= p.getPoint().intValue();
					p.setPileType(PileRecord.PILE_TYPE_PILE);
					p.setPileTime(buyRecord.getCreateTime());
					pileRecordDao.updatePileRecord(p);
					auditor.trace("[积点购买] 商户号=" + merchantNo + ", 商户帐号" + maNo + ", POINT=" + point + ", 更新PileRecord记录=" + p.getPileSeq());

					Card card = cardDao.getCardByPK(p.getCardNo());
					Account acct = accountDao.getAccountByPK(card.getAccountNo());
					int oldCurrentPoint = acct.getCurrentPoint().intValue();
					int oldPendingPoint = acct.getPendingPoint().intValue();
					acct.setCurrentPoint(new Integer(acct.getCurrentPoint().intValue() + p.getPoint().intValue()));
					acct.setPendingPoint(new Integer(acct.getPendingPoint().intValue() - p.getPoint().intValue()));
					accountDao.updateAccount(acct);
					auditor.trace("[积点购买] 商户号=" + merchantNo + ", 商户帐号" + maNo + ", POINT=" + point + ", 更新帐号=" + acct.getAccountNo() + ", CurrentPoint变化=" + oldCurrentPoint + "->" + acct.getCurrentPoint() + ", PendingPoint变化=" + oldPendingPoint
							+ "->" + acct.getPendingPoint());
				}
			}

			int oldMaPendingPoint = ma.getPendingPoint().intValue();
			int oldMaSparePoint = ma.getSparePoint().intValue();
			ma.setPendingPoint(new Integer(ma.getPendingPoint().intValue() - (point + ma.getSparePoint().intValue() - sparePoint)));
			ma.setSparePoint(new Integer(sparePoint));
			merchantAccountDao.updateMerchantAccount(ma);

			auditor.trace("[积点购买] 商户号=" + merchantNo + ", 商户帐号" + maNo + ", POINT=" + point + ", 更新商户帐号=" + ma.getMaNo() + ", SparePoint变化=" + oldMaSparePoint + "->" + ma.getSparePoint() + ", PendingPoint变化=" + oldMaPendingPoint + "->"
					+ ma.getPendingPoint());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}
	
	public Collection getTopChangedProducts(int size){
		try {
			return changeListDao.getTopChangedProducts(size);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}

	public Collection getTopReturnMerchants(int size){
		try {
			return merchantDao.getTopReturnMerchants(size);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e);
		}
	}
}
