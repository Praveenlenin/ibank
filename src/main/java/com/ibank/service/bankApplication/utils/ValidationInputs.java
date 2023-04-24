package com.ibank.service.bankApplication.utils;


import com.ibank.service.bankApplication.constants.Constants;
import com.ibank.service.bankApplication.model.Account;
import com.ibank.service.bankApplication.model.BeneficiaryAccount;

public class ValidationInputs {
	
	   public static boolean isAccountNameValid(Account account) {
	        return Constants.ACCOUNT_NAME.matcher(account.getAccountName()).find();
	    }
	   
	   public static boolean isPhoneNumberValid(Account account) {
	        return Constants.PHONE_NUMBER.matcher(account.getPhone()).find();
	    }
	   
	   public static boolean isEmailIDValid(Account account) {
	        return Constants.EMAIL_ID.matcher(account.getEmail()).find();
	    }
	   
	    
	    public static boolean isIFSCCODEValid(BeneficiaryAccount account) {
	        return Constants.IFSCCODE.matcher(account.getBeneficiaryIfscCode()).find();
	    }
	    public static boolean isBeneNameValid(BeneficiaryAccount account) {
	        return Constants.BENENAME.matcher(account.getBeneficiaryName()).find();
	    }
	   
	    public static boolean isStatusValid(Account account) {
	    	
	    	if(account.getStatus().equals(Constants.ACTIVE) || account.getStatus() == Constants.INACTIVE) {
	    		return true;
	    	}
	       return false;
	    }
	    public static boolean isStatusValidForBene(BeneficiaryAccount account) {
	    	
	    	if(account.getStatus().equals(Constants.ACTIVE) || account.getStatus() == Constants.INACTIVE) {
	    		return true;
	    	}
	       return false;
	    }
	    

	    
}
