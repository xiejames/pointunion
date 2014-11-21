package com.pointunion.web.util;

import java.io.Serializable;

import com.pointunion.domain.dto.Account;
import com.pointunion.domain.dto.Customer;

/**
 * @author xielingjiang
 * @since 10.06.2006
 */
public class UserSession implements Serializable {

	private Customer customer;

	private Account account;

	public UserSession(Customer customer) {
		this.customer = customer;
	}

	public UserSession(Customer customer, Account account) {
		this.customer = customer;
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
