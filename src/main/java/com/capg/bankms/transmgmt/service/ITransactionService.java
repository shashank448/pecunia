package com.capg.bankms.transmgmt.service;

//import java.sql.Date;

//import com.capg.bankms.transmgmt.dao.Account;
import com.capg.bankms.transmgmt.entities.Cheque;
import com.capg.bankms.accountmgmt.entities.*;
import com.capg.bankms.transmgmt.entities.Transaction;

public interface ITransactionService {
	double getBalance(Account a);
	boolean updateBalance(Account a);
	int creditUsingSlip(Transaction transaction);
	int debitUsingSlip(Transaction transaction);
	int creditUsingCheque(Transaction trnasaction,Cheque cheque);
	int debitUsingCheque(Transaction trnasaction,Cheque cheque);
	
	
	
}
