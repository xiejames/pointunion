package com.pointunion.dao.ibatis;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.MerchantCategoryDao;
import com.pointunion.domain.dto.MerchantCategory;

public class SqlMapMerchantCategoryDao extends SqlMapClientDaoSupport implements MerchantCategoryDao {
	public MerchantCategory getMerchantCategoryByPK(String mcNo) throws DataAccessException {
		return (MerchantCategory) getSqlMapClientTemplate().queryForObject("getMerchantCategoryByPK", mcNo);
	}

	public Collection getMerchantCategories() throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getMerchantCategories", null);
	}

	public void insertMerchantCategory(MerchantCategory merchantCategory) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertMerchantCategory", merchantCategory);
	}

	public void updateMerchantCategory(MerchantCategory merchantCategory) throws DataAccessException {
		getSqlMapClientTemplate().update("updateMerchantCategory", merchantCategory, 1);
	}

	public void deleteMerchantCategory(String mcNo) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteMerchantCategory", mcNo, 1);
	}

}
