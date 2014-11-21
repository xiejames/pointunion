package com.pointunion.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pointunion.dao.CustomerDao;
import com.pointunion.domain.dto.Customer;

public class SqlMapCustomerDao extends SqlMapClientDaoSupport implements CustomerDao {
	public Customer getCustomerByPK(String customerNo) throws DataAccessException {
		return (Customer) getSqlMapClientTemplate().queryForObject("getCustomerByPK", customerNo);
	}

	public Customer getCustomer(String userId, String password) throws DataAccessException {
		Customer param = new Customer();
		param.setUserId(userId);
		param.setPassword(password);
		return (Customer) getSqlMapClientTemplate().queryForObject("getCustomerByIDAndPwd", param);
	}

	public Customer getCustomer(String userId) throws DataAccessException {
		return (Customer) getSqlMapClientTemplate().queryForObject("getCustomerByID", userId);
	}

	public Customer getCustomerByEmail(String email) throws DataAccessException {
		return (Customer) getSqlMapClientTemplate().queryForObject("getCustomerByEmail", email);
	}

	public void insertCustomer(Customer customer) throws DataAccessException {
		getSqlMapClientTemplate().update("insertCustomer", customer);
	}

	public void updateCustomer(Customer customer) throws DataAccessException {
		getSqlMapClientTemplate().update("updateCustomer", customer);
	}

	public void deleteCustomer(String customerNo) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteCustomer", customerNo);
	}
}
