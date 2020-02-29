package com.capg.bankms.passbookmgmt.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.capg.bankms.accountmgmt.entities.Account;
import com.capg.bankms.transmgmt.dao.TransactionDaoImpl;
import com.capg.bankms.transmgmt.entities.Transaction;

public class PassbookMaintenanceDAOImpl implements PassbookMaintenanceDAO {
   
	
		
	@Override
	public List<Transaction> updatePassboook(String account) {
	 Map<String,Transaction>transactionStore=TransactionDaoImpl.transactionStore;
	
	  for (Map.Entry<String,Transaction> entry : transactionStore.values()) 
	  {
		  if(account=transactionStore.values())
			  
	  
		  
	  }
	 transactionStore.values();	
	}

	@Override
	public List<Transaction> accountSummary(String accountId, LocalDate fromDate,
			LocalDate toDate) {
		
	}

	@Override
	public boolean accountValidation(Account account) {
		
	}

	@Override
	public boolean updateLastUpdated(Account account) {
		
	}

}
