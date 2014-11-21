package com.pointunion.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.Product;
import com.pointunion.domain.qc.ProductQC;

public interface ProductDao {
	public Product getProductByPK(String productNo) throws DataAccessException;

	public void insertProduct(Product product) throws DataAccessException;

	public void updateProduct(Product product) throws DataAccessException;

	public void deleteProduct(String productNo) throws DataAccessException;

	public Collection getProducts(ProductQC productQC) throws DataAccessException;

	public int getProductsCount(ProductQC productQC) throws DataAccessException;
}
