package com.ibank.service.bankApplication.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	

	private String accountName;
	


	private String phone;
	
	private String email;
	
	private String status;
	
	@OneToMany
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
   private transient List<BeneficiaryAccount> beneficirayAccount;
	
	@OneToMany
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
   private transient List<Transaction> transactions;
	
	@OneToOne(mappedBy = "Account", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private transient AccountBalance accountbalance;
	

	
	public Account() {};
	

	public Account(int accountId, String accountName, String phone, String email, String status) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.phone = phone;
		this.email = email;
		this.status = status;
	}



	public String getAccountName() {
		return accountName;
	}



	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "Account [AccountId=" + accountId + ", accountName=" + accountName + ", phone=" + phone + ", email="
				+ email + ", status=" + status + "]";
	}


	

	   }
