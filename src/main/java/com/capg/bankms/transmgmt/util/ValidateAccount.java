package com.capg.bankms.transmgmt.util;
import com.capg.bankms.transmgmt.entities.*;
import com.capg.bankms.transmgmt.exception.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.regex.Pattern;



public class ValidateAccount {

	public static void validateCreditSlip(Transaction transaction) {

		if (transaction.transAccountId.length() != 12
				&& !(transaction.getTransAmount() >= 100 && transaction.getTransAmount() <= 100000)) {
			throw new IncorrectSlipDetailsException("Slip details are Invalid");
		}
	}

	public static void validateDebitSlip(Transaction transaction) {

		if (transaction.transAccountId.length() != 12) {
			throw new IncorrectSlipDetailsException("Slip details are Invalid");
		}
	}



	public static void validateCheque(Cheque cheque,Transaction transaction) {
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

		if (cheque.getChequeBankName() == null || cheque.getChequeBankName().isEmpty()) {
			throw new IncorrectChequeDetailsException("Cheque details are Incomplete");
		}

		String chequenum = String.valueOf(cheque.getChequeNum());
        System.out.println("inside validatecreditcheque");
		if (cheque.getChequeAccountNum().length() != 12) {
			throw new InvalidChequeLengthException("Cheque Account Number is incorrect");
	}
		System.out.println("Transaction Amount "+transaction.getTransAmount());
		 if (!(transaction.getTransAmount() >= 100 && transaction.getTransAmount() <= 200000)) {
			 throw new InvalidTransactionAmountException("Transaction Amount is not in limit");
		 }
		if (chequenum.length() != 6) {
			throw new InvalidChequeNumberException("Cheque Number length is incorrect ");
		}
		
		if(!(cheque.getChequeIFSC().length() == 10) && (cheque.getChequeIFSC().matches("\\w+"))){
			{
				throw new InvalidChequeIFSCException("Cheque IFSC is invalid");
		}
			
		}
		
	}

}
