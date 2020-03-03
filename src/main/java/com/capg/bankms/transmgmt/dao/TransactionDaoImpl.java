package com.capg.bankms.transmgmt.dao;


import java.util.*;

<<<<<<< HEAD
=======
import com.capg.bankms.accountmgmt.dao.UserMgtStore;
>>>>>>> d4c4c70ded601002d1f206f73c4649eea47dabff
import com.capg.bankms.accountmgmt.entities.Account;
import com.capg.bankms.transmgmt.entities.Cheque;

import com.capg.bankms.transmgmt.entities.Transaction;

<<<<<<< HEAD
public class TransactionDaoImpl implements TransactionDao {
	public static Map<String, Transaction> transactionStore = new HashMap<>();
=======
public class TransactionDaoImpl implements TransactionDao{
	public static Map<String,Transaction> transactionStore=new HashMap<>(); 
>>>>>>> d4c4c70ded601002d1f206f73c4649eea47dabff
	private static int generatedChequeId;
	private static int generatedTransactionId;

	@Override
	public Account getAccountById(String id) {
<<<<<<< HEAD
		// TODO Auto-generated method stub

		return null;
=======
		Map<String,Account> accounts = UserMgtStore.accountStore;
		return accounts.get(id);
>>>>>>> d4c4c70ded601002d1f206f73c4649eea47dabff
	}

	@Override
	public double getBalance(Account account) {
<<<<<<< HEAD
		return account.getAccountBalance();
=======
		Map<String,Account> accounts = UserMgtStore.accountStore;
		return accounts.get(account.getAccountId()).getAccountBalance();
>>>>>>> d4c4c70ded601002d1f206f73c4649eea47dabff
	}

	@Override
	public boolean updateBalance(Account account) {
<<<<<<< HEAD
		Transaction transaction = new Transaction();
		transaction.setTransAccountId(account.getAccountId());
		transaction.setTransClosingBalance(account.getAccountBalance());
		int genTransId = generateTransactionId(transaction);

=======
		Transaction transaction=new Transaction();
		transaction.setTransAccountId(account.getAccountId());
		transaction.setTransClosingBalance(account.getAccountBalance());
	
>>>>>>> d4c4c70ded601002d1f206f73c4649eea47dabff
		return true;
	}

	@Override
	public int generateChequeId(Cheque cheque) {
		++generatedChequeId;
		String idStr = String.valueOf(generatedChequeId);
		cheque.setChequeId(idStr);
		return generatedChequeId;
	}

	@Override
	public int generateTransactionId(Transaction transaction) {
		++generatedTransactionId;
		String transId = String.valueOf(generatedTransactionId);
		transaction.setTransId(transId);
		return generatedTransactionId;

	}

}
