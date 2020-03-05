package com.capg.bankms.accountmgmt.dao;

import com.capg.bankms.accountmgmt.entities.Account;
import com.capg.bankms.accountmgmt.entities.Address;
import com.capg.bankms.accountmgmt.entities.Customer;

public interface IAccountDao {
	boolean deleteAccount(String accountId);
	boolean updateCustomerName(Account account,Customer customer);
	boolean updateCustomerContact(Account account,Customer customer);
	String  updateCustomerAddress(Account account,Address address);
	String  addCustomerDetails(Customer customer,Address address);
<<<<<<< HEAD
	String  addAccount(Account account);
	String  showAccountDetails(Account account);
=======
	String  addAccount(Account account,Customer customer);
	String showAccountDetails(Account account);
>>>>>>> d4c4c70ded601002d1f206f73c4649eea47dabff
    Account findAccountById(String accountId);
}
