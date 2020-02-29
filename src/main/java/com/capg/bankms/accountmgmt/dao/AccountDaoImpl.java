package com.capg.bankms.accountmgmt.dao;

import java.util.*;

import com.capg.bankms.accountmgmt.entities.Account;
import com.capg.bankms.accountmgmt.entities.Address;
import com.capg.bankms.accountmgmt.entities.Customer;

public class AccountDaoImpl implements IAccountDao {
	
	@Override
	public boolean deleteAccount(String accountId) {
		if (customerStore.containsKey(accountId)) {
			accountStore.remove(accountId);
			return true;
		}
		return false;

	}

	@Override
	public boolean updateCustomerName(Account account, Customer customer) {
		if (accountStore.containsKey(account.getAccountId())) {
			account.setCustomer(customer);
			return true;
		}
		return false;

	}

	@Override
	public boolean updateCustomerContact(Account account, Customer customer) {
		if (!accountStore.containsKey(account.getAccountId())) {
			return false;
		}
		account.setCustomer(customer);
		return true;

	}

	@Override
	public String updateCustomerAddress(Account account, Address address) {
		if (customerStore.containsKey(account.getCustomer().getCustomerId())) {
			return "address updated successfully";
		}
		return "address not found";

	}

	@Override
	public String addCustomerDetails(Customer customer, Address address) {
		customer.setAddress(address);
		return "customer name updated successfully";
	}

	@Override
	public String addAccount(Account account) {
		accountStore.put(account.getAccountId(), account);
		return "accoount added successfully";
	}

	@Override
	public String showAccountDetails(Account account) {
		if (accountStore.containsKey(account.getAccountId())) {
			return account.toString();
		}		
		return null;
	}

	@Override
	public Account findAccountById(String accountId) {
		if (accountStore.containsKey(accountId)) {
			return accountStore.get(accountId);
		}
		return null;
	}

}
