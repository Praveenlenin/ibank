package com.ibank.service.bankApplication.constants;

import java.util.regex.Pattern;

public class Constants {
	
	
    public static final String NO_ACCOUNT_FOUND =
            "Unable to find an account ID";
    public static final String INVALID_SEARCH_CRITERIA =
            "The provided account id did not match the expected format";

    public static final String INSUFFICIENT_ACCOUNT_BALANCE =
            "Your account does not have sufficient balance";
    
    public static final String INACTIVE_TRANSACTION =
            "Account  is inactive";

    public static final String ACTIVE = "ACTIVE";
    public static final String INACTIVE = "INACTIVE";
    public static final String CREDIT = "CREDIT";
    public static final String DEBIT = "DEBIT";
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILURE = "FAILURE";



    public static final Pattern PHONE_NUMBER = Pattern.compile("[0-9]{10}");
    public static final Pattern ACCOUNT_NAME = Pattern.compile("[a-zA-Z]");
    public static final Pattern EMAIL_ID = Pattern.compile("[^(.+)@(\\S+)$]");
    public static final Pattern IFSCCODE = Pattern.compile("^[A-Z]{4}0[A-Z0-9]{6}$");
    public static final Pattern BENENAME = Pattern.compile("[a-zA-Z]");
  

}
