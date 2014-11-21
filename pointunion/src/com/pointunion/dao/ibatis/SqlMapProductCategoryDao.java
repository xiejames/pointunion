package com.pointunion.dao.ibatis;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.ProductCategoryDao;
import com.pointunion.domain.dto.ProductCategory;

public class SqlMapProductCategoryDao extends SqlMapClientDaoSupport implements ProductCategoryDao {
	public ProductCategory getProductCategoryByPK(String pcNo) throws DataAccessException {
		return (ProductCategory) getSqlMapClientTemplate().queryForObject("getProductCategoryByPK", pcNo);
	}

	public Collection getProductCategories() throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getProductCategories", null);
	}

	public void insertProductCategory(ProductCategory productCategory) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertProductCategory", productCategory);
	}

	public void updateProductCategory(ProductCategory productCategory) throws DataAccessException {
		getSqlMapClientTemplate().update("updateProductCategory", productCategory, 1);
	}

	public void deleteProductCategory(String pcNo) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteProductCategory", pcNo, 1);
	}

}
