package com.pointunion.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.ProductCategory;

public interface ProductCategoryDao {
	public ProductCategory getProductCategoryByPK(String pcNo) throws DataAccessException;

	public Collection getProductCategories() throws DataAccessException;

	public void insertProductCategory(ProductCategory productCategory) throws DataAccessException;

	public void updateProductCategory(ProductCategory productCategory) throws DataAccessException;

	public void deleteProductCategory(String pcNo) throws DataAccessException;
}
