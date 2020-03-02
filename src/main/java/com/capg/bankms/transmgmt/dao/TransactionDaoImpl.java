package com.capg.bankms.transmgmt.dao;


import java.util.*;

import com.capg.bankms.accountmgmt.dao.UserMgtStore;
import com.capg.bankms.accountmgmt.entities.Account;
import com.capg.bankms.transmgmt.entities.Cheque;

import com.capg.bankms.transmgmt.entities.Transaction;

public class TransactionDaoImpl implements TransactionDao{
	public static Map<String,Transaction> transactionStore=new HashMap<>(); 
	private static int generatedChequeId;
	private static int generatedTransactionId;
	
	
	@Override
	public Account getAccountById(String id) {
		Map<String,Account> accounts = UserMgtStore.accountStore;
		return accounts.get(id);
	}

	@Override
	public double getBalance(Account account) {
		Map<String,Account> accounts = UserMgtStore.accountStore;
		return accounts.get(account.getAccountId()).getAccountBalance();
	}

	@Override
	public boolean updateBalance(Account account) {
		Transaction transaction=new Transaction();
		transaction.setTransAccountId(account.getAccountId());
		transaction.setTransClosingBalance(account.getAccountBalance());
	
		return true;
	}

	@Override
	public int generateChequeId(Cheque cheque) {
		++generatedChequeId;
		String idStr=String.valueOf(generatedChequeId);
		cheque.setChequeId(idStr);
		return generatedChequeId;
	}

	@Override
	public int generateTransactionId(Transaction transaction) {
		++generatedTransactionId;
		String transId=String.valueOf(generatedTransactionId);
		transaction.setTransId(transId);
		return generatedTransactionId;
		
	}

	
	
}

	
	

	


