package com.capg.bankms.transmgmt.util;
import com.capg.bankms.transmgmt.entities.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import com.capg.bankms.accountmgmt.exception.IncorrectChequeDetailsException;
import com.capg.bankms.accountmgmt.exception.IncorrectSlipDetailsException;
import com.capg.bankms.accountmgmt.exception.InvalidChequeException;

public class ValidateAccount {

	public static void validateCreditSlip(Transaction transaction) {

		if (transaction.transAccountId.length() != 12
				&& !(transaction.transAmount >= 100 && transaction.transAmount <= 100000)) {
			throw new IncorrectSlipDetailsException("Slip details are Invalid");
		}
	}

	public static void validateDebitSlip(Transaction transaction) {

		if (transaction.transAccountId.length() != 12) {
			throw new IncorrectSlipDetailsException("Slip details are Invalid");
		}
	}

	public static void validateDebitCheque(Cheque cheque, Transaction transaction) {
		Date issuedDate = cheque.getIssueDate();
		int issuedMonth = issuedDate.getMonth();
		int issuedYear = issuedDate.getYear();
		Date currentDate = new Date();
		int currentMonth = currentDate.getMonth();
		int currentYear = currentDate.getYear();
		if (currentYear - issuedYear > 1) {
			throw new InvalidChequeException("Cheque is expired");
		}
		if (currentYear == issuedYear && currentMonth - issuedMonth + 3 > 0) {
			throw new InvalidChequeException("Cheque is expired");
		}

		if (currentYear != issuedYear && currentMonth - issuedMonth + 3 > 0) {
			throw new InvalidChequeException("Cheque is expired");
		}
		if (cheque.getChequeBankName() == null) {
			throw new IncorrectChequeDetailsException("Cheque details are Incomplete");
		}

		String chequenum = String.valueOf(cheque.getChequeNum());

		if (!((cheque.getChequeAccountNum().length() == 12)
				&& (transaction.getTransAmount() >= 100 && transaction.getTransAmount() <= 200000) && (chequenum.length() == 6)
				&& (cheque.getChequeIFSC().length() == 10) && (cheque.getChequeIFSC().matches("^[a-zA-Z0-9]+$")))) {
			throw new IncorrectChequeDetailsException("Cheque details are Incomplete or Invalid");
		}
	}

	public static void validateCreditCheque(Cheque cheque,Transaction transaction) {
		Date issuedDate = cheque.getIssueDate();
		int issuedMonth = issuedDate.getMonth();
		int issuedYear = issuedDate.getYear();
		int issuedDay = issuedDate.getDate();
		Date today=new Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(today);
		
		int currentMonth= cal.get(Calendar.MONTH);
		int currentYear = cal.get(Calendar.YEAR);
	
		if (currentYear - issuedYear > 1) {
			throw new InvalidChequeException("Cheque is expired");
		}
		if (currentYear == issuedYear && currentMonth - issuedMonth>3) {
			throw new InvalidChequeException("Cheque is expired");
		}

		if (currentYear != issuedYear && currentMonth+12 - issuedMonth  > 3) {
			throw new InvalidChequeException("Cheque is expired");
		}

		if (cheque.getChequeBankName() == null) {
			throw new IncorrectChequeDetailsException("Cheque details are Incomplete");
		}

		String chequenum = String.valueOf(cheque.getChequeNum());

		if (!((cheque.getChequeAccountNum().length() == 12)
				&& (transaction.getTransAmount() >= 100 && transaction.getTransAmount() <= 200000) && (chequenum.length() == 6)
				&& (cheque.getChequeIFSC().length() == 10) && (cheque.getChequeIFSC().matches("^[a-zA-Z0-9]+$")))) {
			throw new IncorrectChequeDetailsException("Cheque details are Incomplete or Invalid");
		}
		
	}

}
