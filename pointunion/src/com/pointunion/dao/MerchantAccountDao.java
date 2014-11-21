package com.pointunion.dao;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.MerchantAccount;

public interface MerchantAccountDao {
	public MerchantAccount getMerchantAccountByPK(String maNo) throws DataAccessException;

	public void insertMerchantAccount(MerchantAccount merchantAccount) throws DataAccessException;

	public void updateMerchantAccount(MerchantAccount merchantAccount) throws DataAccessException;

	public void deleteMerchantAccount(String maNo) throws DataAccessException;
}
