package com.pointunion.dao.ibatis;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.MerchantDao;
import com.pointunion.domain.dto.Merchant;
import com.pointunion.domain.qc.MerchantQC;

public class SqlMapMerchantDao extends SqlMapClientDaoSupport implements MerchantDao {
	public Merchant getMerchantByPK(String merchantNo) throws DataAccessException {
		return (Merchant) getSqlMapClientTemplate().queryForObject("getMerchantByPK", merchantNo);
	}

	public void insertMerchant(Merchant merchant) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertMerchant", merchant);
	}

	public void updateMerchant(Merchant merchant) throws DataAccessException {
		getSqlMapClientTemplate().update("updateMerchant", merchant, 1);
	}

	public void deleteMerchant(String merchantNo) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteMerchant", merchantNo, 1);
	}

	public Collection getMerchants(MerchantQC merchantQC) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getMerchantsByQC", merchantQC);
	}

	public int getMerchantsCount(MerchantQC merchantQC) throws DataAccessException {
		merchantQC.setCountFlag("Y");
		Merchant m = (Merchant) getSqlMapClientTemplate().queryForObject("getMerchantsByQC", merchantQC);
		return m.getTotalCountForCounter();
	}
	
	public Collection getTopReturnMerchants(int size) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getTopReturnMerchants", new Integer(size));
	}

}
