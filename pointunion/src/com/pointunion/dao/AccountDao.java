package com.pointunion.dao;

import org.springframework.dao.DataAccessException;

import com.pointunion.domain.dto.Account;

public interface AccountDao {
	public Account getAccountByPK(String accountNo) throws DataAccessException;

	public void insertAccount(Account account) throws DataAccessException;

	public void updateAccount(Account account) throws DataAccessException;

	public void deleteAccount(String accountNo) throws DataAccessException;

	public Account getAccountByCustomerNo(String customerNo) throws DataAccessException;
}
