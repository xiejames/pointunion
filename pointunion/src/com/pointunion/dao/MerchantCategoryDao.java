package com.pointunion.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.MerchantCategory;

public interface MerchantCategoryDao {
	public MerchantCategory getMerchantCategoryByPK(String mcNo) throws DataAccessException;

	public Collection getMerchantCategories() throws DataAccessException;

	public void insertMerchantCategory(MerchantCategory merchantCategory) throws DataAccessException;

	public void updateMerchantCategory(MerchantCategory merchantCategory) throws DataAccessException;

	public void deleteMerchantCategory(String mcNo) throws DataAccessException;
}
