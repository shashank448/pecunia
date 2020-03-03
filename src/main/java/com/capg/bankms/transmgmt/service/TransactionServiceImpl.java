package com.capg.bankms.transmgmt.service;


import java.util.*;
import com.capg.bankms.accountmgmt.dao.*;
import com.capg.bankms.accountmgmt.entities.Account;

import com.capg.bankms.transmgmt.dao.TransactionDao;
import com.capg.bankms.transmgmt.entities.Cheque;

import com.capg.bankms.transmgmt.entities.Transaction;
import com.capg.bankms.transmgmt.util.ValidateAccount;

public class TransactionServiceImpl implements ITransactionService{

	
	private TransactionDao dao;
	
	public TransactionServiceImpl(TransactionDao dao){
		this.dao=dao;
	}
	
	@Override
	public double getBalance(Account a) {		
		return dao.getBalance(a);
	
	}

	@Override
	public boolean updateBalance(Account a) {
		return dao.updateBalance(a);
	}
	public int generateChequeId(Cheque cheque) {
		return dao.generateChequeId(cheque);
	}
	@Override
	public int creditUsingSlip(Transaction transaction) {
		ValidateAccount.validateCreditSlip(transaction);
		String accountId=transaction.getTransAccountId();
		double amount=transaction.getTransAmount();
		Account account=UserMgtStore.accountStore.get(accountId);
		double balance=account.getAccountBalance();
		double newBalance=balance+amount;
		account.setAccountBalance(newBalance);
		dao.updateBalance(account);
		return 0;
	}

	@Override
	public int debitUsingSlip(Transaction transaction) {
		ValidateAccount.validateDebitSlip(transaction);
		String accountId=transaction.getTransAccountId();
		double amount=transaction.getTransAmount();
		Account account=UserMgtStore.accountStore.get(accountId);
		double balance=account.getAccountBalance();
		double newBalance=balance-amount;
		account.setAccountBalance(newBalance);
		dao.updateBalance(account);
		return 0;
	}

	@Override
	public int creditUsingCheque(Transaction transaction, Cheque cheque) {
		ValidateAccount.validateCreditCheque(cheque,transaction);
			String accountId=transaction.getTransAccountId();
			double amount=transaction.getTransAmount();
			
			
			
			Account account=UserMgtStore.accountStore.get(transaction.getTransTo());
			Account account2=UserMgtStore.accountStore.get(transaction.getTransFrom());
		
			account.setAccountBalance(account.getAccountBalance()+amount);
			account2.setAccountBalance(account2.getAccountBalance()-amount);
			
			dao.updateBalance(account);
			dao.updateBalance(account2);
			
		
		return 0;
	}

	@Override
	public int debitUsingCheque(Transaction transaction, Cheque cheque) {
		ValidateAccount.validateCreditCheque(cheque,transaction);
		String accountId=transaction.getTransAccountId();
		double amount=transaction.getTransAmount();
		
		Account account=UserMgtStore.accountStore.get(accountId);
	//	Account account2=UserMgtStore.accountStore.get(transaction.getTransFrom());
		account.setAccountBalance(account.getAccountBalance()+amount);
	//	account2.setAccountBalance(account2.getAccountBalance()-amount);
		
		dao.updateBalance(account);
	//	dao.updateBalance(account2);
		return 0;
	}	
}
