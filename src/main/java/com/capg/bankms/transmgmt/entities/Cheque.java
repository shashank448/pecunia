package com.capg.bankms.transmgmt.entities;

import java.util.*;

public class Cheque {
	
	
	private String chequeId;
	private int chequeNum;
	private String chequeAccountNum;
	private String chequeHolderName;
	private String chequeBankName;
	private String chequeIFSC;
	private Date IssueDate;
	private String chequeStatus;
	
	public String getChequeId() {
		return chequeId;
	}
	public void setChequeId(String chequeId) {
		this.chequeId = chequeId;
	}
	public int getChequeNum() {
		return chequeNum;
	}
	public void setChequeNum(int chequeNum) {
		this.chequeNum = chequeNum;
	}
	public String getChequeAccountNum() {
		return chequeAccountNum;
	}
	public void setChequeAccountNum(String chequeAccountNum) {
		this.chequeAccountNum = chequeAccountNum;
	}
	public String getChequeHolderName() {
		return chequeHolderName;
	}
	public void setChequeHolderName(String chequeHolderName) {
		this.chequeHolderName = chequeHolderName;
	}
	public String getChequeBankName() {
		return chequeBankName;
	}
	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}
	public String getChequeIFSC() {
		return chequeIFSC;
	}
	public void setChequeIFSC(String chequeIFSC) {
		this.chequeIFSC = chequeIFSC;
	}
	public Date getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(Date chequeIssueDate) {
		IssueDate = chequeIssueDate;
	}
	public String getChequeStatus() {
		return chequeStatus;
	}
	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}
	
}
