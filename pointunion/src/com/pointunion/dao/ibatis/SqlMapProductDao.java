package com.pointunion.dao.ibatis;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.ProductDao;
import com.pointunion.domain.dto.Product;
import com.pointunion.domain.qc.ProductQC;

public class SqlMapProductDao extends SqlMapClientDaoSupport implements ProductDao {
	public Product getProductByPK(String productNo) throws DataAccessException {
		return (Product) getSqlMapClientTemplate().queryForObject("getProductByPK", productNo);
	}

	public void insertProduct(Product product) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertProduct", product);
	}

	public void updateProduct(Product product) throws DataAccessException {
		getSqlMapClientTemplate().update("updateProduct", product, 1);
	}

	public void deleteProduct(String productNo) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteProduct", productNo, 1);
	}

	public Collection getProducts(ProductQC productQC) throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getProductsByQC", productQC);
	}

	public int getProductsCount(ProductQC productQC) throws DataAccessException {
		productQC.setCountFlag("Y");
		Product p = (Product) getSqlMapClientTemplate().queryForObject("getProductsByQC", productQC);
		return p.getTotalCountForCounter();
	}

}
