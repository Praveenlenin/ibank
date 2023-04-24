package com.ibank.service.bankApplication.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "Beneficiary")
public class BeneficiaryAccount {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long beneficiaryAccountId;
	private int accountId;
	private String beneficiaryIfscCode;
	private String beneficiaryName;
	private String status;
	
	public BeneficiaryAccount() {}
	
	public BeneficiaryAccount(int accountId, long beneficiaryAccountId, String beneficiaryIfscCode,
			String beneficiaryName, String status) {
		super();
		this.accountId = accountId;
		this.beneficiaryAccountId = beneficiaryAccountId;
		this.beneficiaryIfscCode = beneficiaryIfscCode;
		this.beneficiaryName = beneficiaryName;
		this.status = status;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public long getBeneficiaryAccountId() {
		return beneficiaryAccountId;
	}
	public void setBeneficiaryAccountId(int beneficiaryAccountId) {
		this.beneficiaryAccountId = beneficiaryAccountId;
	}
	public String getBeneficiaryIfscCode() {
		return beneficiaryIfscCode;
	}
	public void setBeneficiaryIfscCode(String beneficiaryIfscCode) {
		this.beneficiaryIfscCode = beneficiaryIfscCode;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BeneficiaryAccount [accountId=" + accountId + ", beneficiaryAccountId=" + beneficiaryAccountId
				+ ", beneficiaryIfscCode=" + beneficiaryIfscCode + ", beneficiaryName=" + beneficiaryName + ", status="
				+ status + "]";
	}


}
