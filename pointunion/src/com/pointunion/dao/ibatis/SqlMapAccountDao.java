package com.pointunion.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.AccountDao;
import com.pointunion.domain.dto.Account;

public class SqlMapAccountDao extends SqlMapClientDaoSupport implements AccountDao {
	public Account getAccountByPK(String accountNo) throws DataAccessException {
		return (Account) getSqlMapClientTemplate().queryForObject("getAccountByPK", accountNo);
	}

	public void insertAccount(Account account) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertAccount", account);
	}

	public void updateAccount(Account account) throws DataAccessException {
		getSqlMapClientTemplate().update("updateAccount", account, 1);
	}

	public void deleteAccount(String accountNo) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteAccount", accountNo, 1);
	}

	public Account getAccountByCustomerNo(String customerNo) throws DataAccessException {
		return (Account) getSqlMapClientTemplate().queryForObject("getAccountByCustomerNo", customerNo);
	}

}
