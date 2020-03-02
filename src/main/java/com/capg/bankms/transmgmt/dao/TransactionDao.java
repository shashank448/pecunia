package com.capg.bankms.transmgmt.dao;

import com.capg.bankms.accountmgmt.entities.Account;
import com.capg.bankms.transmgmt.entities.Cheque;
import com.capg.bankms.transmgmt.entities.Transaction;

public interface TransactionDao {

	Account getAccountById(String id);

	double getBalance(Account account);

	boolean updateBalance(Account account);

	int generateChequeId(Cheque cheque);

	int generateTransactionId(Transaction transaction);

}
