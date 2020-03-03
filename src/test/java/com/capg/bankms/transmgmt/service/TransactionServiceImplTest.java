package com.capg.bankms.transmgmt.service;

import java.util.*;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capg.bankms.accountmgmt.dao.UserMgtStore;
import com.capg.bankms.accountmgmt.entities.Account;
import com.capg.bankms.accountmgmt.entities.Customer;
import com.capg.bankms.transmgmt.dao.TransactionDaoImpl;
import com.capg.bankms.transmgmt.entities.Cheque;
import com.capg.bankms.transmgmt.entities.Transaction;

public class TransactionServiceImplTest {
	private TransactionServiceImpl service;
	
@BeforeEach
public void setup() {
	service= new TransactionServiceImpl(new TransactionDaoImpl());
}


@AfterEach
public void clear() {
	TransactionDaoImpl.transactionStore.clear();
}

@Test
public void updateBalance_1() {
	Account account=new Account();
	account.setAccountId("101852369741");
	account.setAccountBalance(10000.0);
	Customer customer=new Customer();
	customer.setCustomerName("Swarnim");
	customer.setCustomerId("101120");
	account.setCustomer(customer);
	
	service.updateBalance(account);
	Map<String, Account> store=UserMgtStore.accountStore;
	Account result=store.get("101852369741");
	Assertions.assertEquals(account,result);
}

	@Test
public void creditUsingCheque_1() {
	Account account=new Account();
	account.setAccountId("123456789123");
	account.setAccountBalance(10000.0);
	Customer customer=new Customer();
	customer.setCustomerName("Swarnim");
	customer.setCustomerId("101010101010");
	account.setCustomer(customer);
	
	Account account2=new Account();
	account2.setAccountId("123456789124");
	account2.setAccountBalance(10000.0);
	Customer customer2=new Customer();
	customer2.setCustomerName("Swarnim Indraguru");
	customer2.setCustomerId("101110111011");
	account2.setCustomer(customer);

	service.updateBalance(account2);
	service.updateBalance(account);
	
	
	
	Transaction transaction=new Transaction();
	Cheque cheque=new Cheque();
	cheque.setChequeAccountNum("123456789123");
	cheque.setAmount(20000.0);
	cheque.setChequeBankName("SBI");
	cheque.setChequeNum(123456);
	cheque.setChequeIFSC("123Afvg586");
	cheque.setIssueDate(new Date(2020,01,01));
	service.generateChequeId(cheque);
	
	transaction.setTransAccountId(cheque.getChequeId());
	
	transaction.transAmount=cheque.getAmount();
	transaction.setTransTo("123456789123");
	transaction.setTransFrom("123456789124");
	
	service.creditUsingCheque(transaction, cheque);
	
	
	Map<String, Account> store=UserMgtStore.accountStore;
	Account result=store.get("123456789123");
	Assertions.assertEquals(25000.0,result.getAccountBalance());
	
}
	@Test
public void debitUsingCheque_1() {
	Account account=new Account();
	account.setAccountId("123456789123");
	account.setAccountBalance(10000.0);
	Customer customer=new Customer();
	customer.setCustomerName("Swarnim");
	customer.setCustomerId("101010101010");
	account.setCustomer(customer);
	
	Account account2=new Account();
	account2.setAccountId("123456789124");
	account2.setAccountBalance(10000.0);
	Customer customer2=new Customer();
	customer2.setCustomerName("Swarnim Indraguru");
	customer2.setCustomerId("101110111011");
	account2.setCustomer(customer);

	service.updateBalance(account2);
	service.updateBalance(account);
	
	
	
	Transaction transaction=new Transaction();
	Cheque cheque=new Cheque();
	cheque.setChequeAccountNum("123456789123");
	cheque.setAmount(5000.0);
	cheque.setChequeBankName("SBI");
	cheque.setChequeNum(123456);
	cheque.setChequeIFSC("123Afvg586");
	cheque.setIssueDate(new Date(2020,01,01));
	service.generateChequeId(cheque);
	
	transaction.setTransAccountId(cheque.getChequeAccountNum());
	
	transaction.transAmount=cheque.getAmount();
	transaction.setTransTo("123456789123");
	transaction.setTransFrom("123456789124");
	
	service.debitUsingCheque(transaction, cheque);
	
	
	Map<String, Account> store=UserMgtStore.accountStore;
	Account result=store.get("123456789124");
	Assertions.assertEquals(5000.0,result.getAccountBalance());
	
}

@Test
public void creditUsingSlip_1() {
	Account account=new Account();
	account.setAccountId("123456789123");
	account.setAccountBalance(10000.0);
	Customer customer=new Customer();
	customer.setCustomerName("Swarnim");
	customer.setCustomerId("101010101010");
	account.setCustomer(customer);
	
	
	service.updateBalance(account);
	
	Transaction transaction=new Transaction();
	transaction.setTransAmount(10000);
	transaction.setTransAccountId(account.getAccountId());
	
	transaction.setTransTo(account.getAccountId());
	service.creditUsingSlip(transaction);
	Map<String, Account> store=UserMgtStore.accountStore;
	Account result=store.get("123456789123");
	Assertions.assertEquals(20000.0,result.getAccountBalance());
	
}

@Test
public void debitUsingSlip_1() {
	Account account=new Account();
	account.setAccountId("123456789123");
	account.setAccountBalance(10000.0);
	Customer customer=new Customer();
	customer.setCustomerName("Swarnim");
	customer.setCustomerId("101010101010");
	account.setCustomer(customer);
	
	
	service.updateBalance(account);
	
	Transaction transaction=new Transaction();
	transaction.setTransAmount(10000);
	transaction.setTransAccountId(account.getAccountId());
	
	transaction.setTransTo(account.getAccountId());
	service.debitUsingSlip(transaction);
	Map<String, Account> store=UserMgtStore.accountStore;
	Account result=store.get("123456789123");
	Assertions.assertEquals(0.0,result.getAccountBalance());
	
}

}