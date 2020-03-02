package com.capg.bankms.passbookmgmt.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.bankms.transmgmt.entities.Transaction;

public interface PassbookMaintenanceService {

	public List<Transaction> updatePassbook(String account);

	public List<Transaction> accountSummary(String account, LocalDate fromDate, LocalDate toDate);
}
