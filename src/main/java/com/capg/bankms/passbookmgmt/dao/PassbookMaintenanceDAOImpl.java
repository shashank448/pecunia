package com.capg.bankms.passbookmgmt.dao;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capg.bankms.accountmgmt.entities.Account;
import com.capg.bankms.transmgmt.dao.TransactionDaoImpl;
import com.capg.bankms.transmgmt.entities.Transaction;

public class PassbookMaintenanceDAOImpl implements PassbookMaintenanceDAO {

	@Override
	public List<Transaction> updatePassboook(String accountId) {
		Map<String, Transaction> transactionStore = TransactionDaoImpl.transactionStore;
		List<Transaction> transactions = new ArrayList<>(transactionStore.values());
		List<Transaction> result = new ArrayList<>();
		for (Transaction transaction : transactions) {
			if (transaction.getTransAccountId().equals(accountId)) {
				result.add(transaction);
			}
		}
		return result;

	}

	@Override
	public List<Transaction> accountSummary(String accountId, LocalDate fromDate,
			LocalDate toDate) {
		Map<String, Transaction> transactionStore = TransactionDaoImpl.transactionStore;
		List<Transaction> transactions = new ArrayList<>(transactionStore.values());
		List<Transaction> result = new ArrayList<>();
		
		// ZoneId defaultZoneId = ZoneId.systemDefault();
		 //Date date = new Date();
		 //Instant instant = date.toInstant();
		// LocalDate localDateOf = instant.atZone(defaultZoneId).toLocalDate();
		for (Transaction transaction : transactions) {
			Date dateOfTransaction = transaction.getTransDate();
			
			if(dateOfTransaction.compareTo(fromDate)) {
				
			}
		}
		return result;

	} 

	@Override
	public boolean accountValidation(Account account) {
		String regex = "(A-Za-z0-9)+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(account.accountId);
		if (account.accountId.length() != 12 && !(matcher.matches())) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean updateLastUpdated(Account account) {
		
		Account accounts = UserMgtStore.accountStore;
		for (Account acc : accounts) {
			if(account.getAccountId().equals(acc.getAccountId())) {
				acc.setAccountBalance(account.getAccountBalance());
				acc.setAccountBranchId(account.getAccountBranchId());
				acc.setAccountHolderId(account.getAccountHolderId());
				acc.setAccountInterest(account.getAccountInterest());
				acc.setAccountStatus(account.getAccountStatus());
				acc.setAccountType(account.getAccountType());
				acc.setCustomer(account.getCustomer());
				acc.setLastUpdated(account.getLastUpdated());
				return true;
			}
		}
		return false;

	}

}
