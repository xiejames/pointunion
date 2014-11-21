package com.pointunion.dao;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.Customer;

public interface CustomerDao {
	public Customer getCustomerByPK(String customerNo) throws DataAccessException;

	public Customer getCustomer(String userId, String password) throws DataAccessException;

	public Customer getCustomer(String userId) throws DataAccessException;

	public Customer getCustomerByEmail(String email) throws DataAccessException;

	public void insertCustomer(Customer customer) throws DataAccessException;

	public void updateCustomer(Customer customer) throws DataAccessException;

	public void deleteCustomer(String customerNo) throws DataAccessException;

}
