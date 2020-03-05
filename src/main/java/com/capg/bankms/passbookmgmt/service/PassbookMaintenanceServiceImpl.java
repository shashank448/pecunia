package com.capg.bankms.passbookmgmt.service;

import java.time.LocalDate;
import java.util.List;
import com.capg.bankms.passbookmgmt.exceptions.IncorrectArgumentException;
import com.capg.bankms.passbookmgmt.dao.PassbookMaintenanceDAO;
import com.capg.bankms.transmgmt.entities.Transaction;

public class PassbookMaintenanceServiceImpl implements PassbookMaintenanceService {

	private PassbookMaintenanceDAO dao;

	public PassbookMaintenanceServiceImpl(PassbookMaintenanceDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Transaction> updatePassbook(String account) {
		if (account == null) {
			throw new IncorrectArgumentException("Account is Null");
		}
		return dao.updatePassboook(account);
	}

	@Override
	public List<Transaction> accountSummary(String account, LocalDate fromDate, LocalDate toDate) {
		if (account == null) {
			throw new IncorrectArgumentException("Account is Null");
		}
		return dao.accountSummary(account, fromDate, toDate);
	}

}
