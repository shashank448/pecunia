package com.capg.bankms.transmgmt.entities;

import java.util.*;

public class Slip {
	String accountId;
	double amount;
	Date transactionDate;
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate2) {
		this.transactionDate = transactionDate2;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
