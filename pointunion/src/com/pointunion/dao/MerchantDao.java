package com.pointunion.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.Merchant;
import com.pointunion.domain.qc.MerchantQC;

public interface MerchantDao {
	public Merchant getMerchantByPK(String merchantNo) throws DataAccessException;

	public void insertMerchant(Merchant merchant) throws DataAccessException;

	public void updateMerchant(Merchant merchant) throws DataAccessException;

	public void deleteMerchant(String merchantNo) throws DataAccessException;

	public Collection getMerchants(MerchantQC merchantQC) throws DataAccessException;

	public int getMerchantsCount(MerchantQC merchantQC) throws DataAccessException;
	
	public Collection getTopReturnMerchants(int size) throws DataAccessException;
}
