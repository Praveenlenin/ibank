package com.ibank.service.bankApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


@Entity(name = "Accountbalance")
public class AccountBalance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	private double balance;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "accountId")
    private Account account;
	
	public AccountBalance() {};
		
	public AccountBalance(int accountId, double balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountBalance [accountId=" + accountId + ", balance=" + balance + "]";
	}


}
