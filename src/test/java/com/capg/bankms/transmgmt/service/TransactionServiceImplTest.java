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
import com.capg.bankms.transmgmt.dao.TransactionMgmtStore;
import com.capg.bankms.transmgmt.entities.Cheque;
import com.capg.bankms.transmgmt.entities.Transaction;

public class TransactionServiceImplTest {
	private TransactionServiceImpl service;

	@BeforeEach
	public void setup() {
		service = new TransactionServiceImpl(new TransactionDaoImpl());
	}

	@AfterEach
	public void clear() {
		TransactionMgmtStore.transactionStore.clear();
	}

	@Test
	public void updateBalance_1() {
		Account account = new Account();
		account.setAccountId("101852369741");
		account.setAccountBalance(10000.0);
		
		service.updateBalance(account);
		Map<String, Account> store = UserMgtStore.accountStore;
		Account result = store.get("101852369741");
		System.out.println(result.getAccountId());
		Assertions.assertEquals(account, result);
	}

	@Test
	public void creditUsingCheque_1() {
		Account beneficiaryAccount = new Account();
		String beneficiaryAccountId="123456789123", payeeAccountId="123456789124";
		double balance=10000,amount=5000;
		beneficiaryAccount.setAccountId(beneficiaryAccountId);
		beneficiaryAccount.setAccountBalance(balance);
		Account payeeAccount = new Account();
		payeeAccount.setAccountId(payeeAccountId);
		payeeAccount.setAccountBalance(balance);
		service.updateBalance(payeeAccount);
		service.updateBalance(beneficiaryAccount);
        String chequeId="thg67g";
		Transaction transaction = new Transaction();
		Cheque cheque = new Cheque();
		cheque.setChequeId(chequeId);
		
		cheque.setAmount(amount);
		cheque.setChequeBankName("SBI");
		cheque.setChequeNum(123456);
		cheque.setChequeIFSC("123Afvg586");
		cheque.setIssueDate(new Date(2020, 01, 01));
		transaction.setTransAmount(cheque.getAmount());
		transaction.setTransTo(beneficiaryAccountId);
		transaction.setTransFrom(payeeAccountId);
		cheque.setChequeAccountNum(payeeAccountId);
		
		service.creditUsingCheque(transaction, cheque);

		Map<String, Account> store = UserMgtStore.accountStore;
		Account result = store.get(beneficiaryAccountId);
		Assertions.assertEquals(10000.0, result.getAccountBalance());

	}

	@Test
	public void debitUsingCheque_1() {
		Account beneficiaryaccount = new Account();
		String beneficiaryAccountId="123456789123",payeeAccountId="123456789124";
		double amount=5000;
		beneficiaryaccount.setAccountId(beneficiaryAccountId);
		beneficiaryaccount.setAccountBalance(10000.0);
		
		Account payeeaccount = new Account();
		payeeaccount.setAccountId(payeeAccountId);
		payeeaccount.setAccountBalance(10000.0);
		service.updateBalance(payeeaccount);
		service.updateBalance(beneficiaryaccount);
		Transaction transaction = new Transaction();
		Cheque cheque = new Cheque();
		cheque.setChequeAccountNum(payeeAccountId);
		cheque.setAmount(amount);
		cheque.setChequeBankName("SBI");
		cheque.setChequeNum(123456);
		cheque.setChequeIFSC("123Afvg586");
		cheque.setIssueDate(new Date(2020, 01, 01));
		service.generateChequeId(cheque);
		transaction.setTransAccountId(cheque.getChequeAccountNum());
		transaction.setTransAmount(cheque.getAmount());
		transaction.setTransTo(beneficiaryAccountId);
		transaction.setTransFrom(payeeAccountId);
		service.debitUsingCheque(transaction, cheque);
		Map<String, Account> store = UserMgtStore.accountStore;
		Account result = store.get("123456789124");
		Assertions.assertEquals(5000.0, result.getAccountBalance());

	}

	@Test
	public void creditUsingSlip_1() {
		Account account = new Account();
		account.setAccountId("123456789123");
		account.setAccountBalance(10000.0);
		Customer customer = new Customer();
		customer.setCustomerName("Swarnim");
		customer.setCustomerId("101010101010");
		account.setCustomer(customer);

		service.updateBalance(account);

		Transaction transaction = new Transaction();
		transaction.setTransAmount(10000);
		transaction.setTransAccountId(account.getAccountId());

		transaction.setTransTo(account.getAccountId());
		service.creditUsingSlip(transaction);
		Map<String, Account> store = UserMgtStore.accountStore;
		Account result = store.get("123456789123");
		Assertions.assertEquals(20000.0, result.getAccountBalance());

	}

	@Test
	public void debitUsingSlip_1() {
		Account account = new Account();
		account.setAccountId("123456789123");
		account.setAccountBalance(10000.0);
		Customer customer = new Customer();
		customer.setCustomerName("Swarnim");
		customer.setCustomerId("101010101010");
		account.setCustomer(customer);

		service.updateBalance(account);

		Transaction transaction = new Transaction();
		transaction.setTransAmount(10000);
		transaction.setTransAccountId(account.getAccountId());

		transaction.setTransTo(account.getAccountId());
		service.debitUsingSlip(transaction);
		Map<String, Account> store = UserMgtStore.accountStore;
		Account result = store.get("123456789123");
		Assertions.assertEquals(0.0, result.getAccountBalance());

	}

}