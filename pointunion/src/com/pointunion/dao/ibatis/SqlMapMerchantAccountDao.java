package com.pointunion.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.MerchantAccountDao;
import com.pointunion.domain.dto.MerchantAccount;

public class SqlMapMerchantAccountDao extends SqlMapClientDaoSupport implements MerchantAccountDao {
	public MerchantAccount getMerchantAccountByPK(String maNo) throws DataAccessException {
		return (MerchantAccount) getSqlMapClientTemplate().queryForObject("getMerchantAccountByPK", maNo);
	}

	public void insertMerchantAccount(MerchantAccount merchantAccount) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertMerchantAccount", merchantAccount);
	}

	public void updateMerchantAccount(MerchantAccount merchantAccount) throws DataAccessException {
		getSqlMapClientTemplate().update("updateMerchantAccount", merchantAccount, 1);
	}

	public void deleteMerchantAccount(String maNo) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteMerchantAccount", maNo, 1);
	}

}
