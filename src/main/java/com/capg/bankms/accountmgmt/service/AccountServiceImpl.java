package com.capg.bankms.accountmgmt.service;

import com.capg.bankms.accountmgmt.dao.IAccountDao;
import com.capg.bankms.accountmgmt.entities.Account;
import com.capg.bankms.accountmgmt.entities.Address;
import com.capg.bankms.accountmgmt.entities.Customer;


public class AccountServiceImpl implements IAccountService {
	private IAccountDao accountDao;
	
	AccountServiceImpl(IAccountDao dao){
		this.accountDao=dao;
	}

	@Override
	public boolean deleteAccount(String accountId) {
		accountDao.deleteAccount(accountId);
		return true;
	}

	@Override
	public boolean updateCustomerContact(Account account, Customer customer) {
		accountDao.updateCustomerContact(account, customer);
		return true;
	}

	
	@Override
	public String addAccount(Customer customer,Address address, Account account) {
		customer.setAddress(address);
		
		return accountDao.addAccount(account,customer);
	}

	@Override
	public Account showAccountDetails(Account account) {
		accountDao.showAccountDetails(account);
		return account;
	}

	@Override
	public String updateCustomerAddress(Account account, Address address) {
		accountDao.updateCustomerAddress(account, address);
		return "";
	}

	@Override
	public Account findAccountById(String accountId) {
		return accountDao.findAccountById(accountId);
	}

	

}
