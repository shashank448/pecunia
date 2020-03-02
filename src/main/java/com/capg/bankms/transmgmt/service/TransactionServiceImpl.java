package com.capg.bankms.transmgmt.service;



import com.capg.bankms.accountmgmt.dao.UserMgtStore;
import com.capg.bankms.accountmgmt.entities.Account;

import com.capg.bankms.transmgmt.dao.TransactionDao;
import com.capg.bankms.transmgmt.entities.Cheque;

import com.capg.bankms.transmgmt.entities.Transaction;
import com.capg.bankms.transmgmt.util.ValidateAccount;

public class TransactionServiceImpl implements ITransactionService{

	
	private TransactionDao dao;
	
	TransactionServiceImpl(TransactionDao dao){
		this.dao=dao;
	}
	public double getBalance(Account a) {
		
		
		return dao.getBalance(a);
	
	}

	@Override
	public boolean updateBalance(Account a) {
		return dao.updateBalance(a);
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
		Account account=UserMgtStore.accountStore.get(accountId);
		double balance=account.getAccountBalance();
		double newBalance=balance+amount;
		account.setAccountBalance(newBalance);
		dao.updateBalance(account);	
		return 0;
	}

	@Override
	public int debitUsingCheque(Transaction transaction, Cheque cheque) {
		ValidateAccount.validateDebitCheque(cheque,transaction);
		String accountId=transaction.getTransAccountId();
		double amount=transaction.getTransAmount();
		Account account=UserMgtStore.accountStore.get(accountId);
		double balance=account.getAccountBalance();
		double newBalance=balance-amount;
		account.setAccountBalance(newBalance);
		dao.updateBalance(account);
		return 0;
	}	
}
