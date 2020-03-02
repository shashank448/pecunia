package com.capg.bankms.passbookmgmt.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.capg.bankms.transmgmt.entities.Transaction;

public interface PassbookRepository {
	public List<Transaction> findById(String account, LocalDateTime dateTime);

	public List<Transaction> getAccountSummary(String account, LocalDateTime dateTime1, LocalDateTime dateTime2);
}
