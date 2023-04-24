package com.ibank.service.bankApplication.model;



import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID transactionId;	
	private int accountId;	
	private String date;	
	private String type	;
	private double amount;	
	private String transactionStatus;
	private String remarks;
	
	public Transaction() {}
	
	
	
	public Transaction(UUID uuid, int accountId, String date, String type, double amount,
			String transactionStatus, String remarks) {
		super();
		this.transactionId = uuid;
		this.accountId = accountId;
		this.date = date;
		this.type = type;
		this.amount = amount;
		this.transactionStatus = transactionStatus;
		this.remarks = remarks;
	}
	
	public UUID getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountId=" + accountId + ", date=" + date + ", type="
				+ type + ", amount=" + amount + ", transactionStatus=" + transactionStatus + ", remarks=" + remarks
				+ "]";
	}
	
	
	
	
	
	
}
