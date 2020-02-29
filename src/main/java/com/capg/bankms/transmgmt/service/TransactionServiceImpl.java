package com.capg.bankms.transmgmt.service;

import java.sql.Date;

import com.capg.bankms.transmgmt.dao.TransactionDao;
import com.capg.bankms.transmgmt.entities.Cheque;
import com.capg.bankms.transmgmt.entities.Slip;
import com.capg.bankms.transmgmt.entities.Transaction;

public class TransactionServiceImpl implements ITransactionService{

	@Override
	private TransactionDao dao;
	
	TransactionServiceImpl(TransactionDao dao){
		this.dao=dao;
	}
	public double getBalance(Account a) {
		
		
		return dao.getBalance(account);
	
	}

	@Override
	public boolean updateBalance(Account a) {
		return dao.updateBalance(account);
	}

	@Override
	public int creditUsingSlip(Transaction transaction) {
		
	}

	@Override
	public int debitUsingSlip(Transaction transaction) {
		
	}

	@Override
	public int creditUsingCheque(Transaction trnasaction, Cheque cheque) {
		
	}

	@Override
	public int debitUsingCheque(Transaction trnasaction, Cheque cheque) {
		
	}
	
	
}
