package com.capg.bankms.transmgmt.exception;



public class InvalidTransactionAmountException extends InvalidChequeException{
	public InvalidTransactionAmountException(String msg) {
		super(msg);
	}
}
