package com.ibank.service.bankApplication.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ibank.service.bankApplication.constants.Constants;
import com.ibank.service.bankApplication.model.AccountBalance;
import com.ibank.service.bankApplication.model.Transaction;
import com.ibank.service.bankApplication.repository.AccountBalanceRepo;

@Service
public class AccountBalanceService {
	
	@Autowired
	private AccountBalanceRepo AccountBalanceRepo;
	
	@Autowired
 	private com.ibank.service.bankApplication.repository.TransactionRepo TransactionRepo;
	
	public List<AccountBalance> getAllAccBalance() {
		return AccountBalanceRepo.findAll();

		
	}
	
	 @Transactional
	public AccountBalance depositAmountByAccountId(int id ,AccountBalance accBalance) {
		 AccountBalance accountBalance = AccountBalanceRepo.findById(id)
				 .orElseThrow(()-> new com.ibank.service.bankApplication.exception.ResourecNotFoundException("Not found"));
				   
				   
				   double balance = accountBalance.getBalance();
				   accountBalance.setBalance(accBalance.getBalance() + balance);
				   
				   AccountBalanceRepo.save(accountBalance);
				   
				   String pattern = "dd-MMM-yyyy"; java.text.SimpleDateFormat simpleDateFormat = new
				   java.text.SimpleDateFormat(pattern); String date = simpleDateFormat.format(new java.util.Date());
				   
				   Transaction transaction = new Transaction(UUID.randomUUID(), id, date,
				   Constants.CREDIT, accBalance.getBalance(), Constants.SUCCESS, "");
				   TransactionRepo.save(transaction);
				 
				   new ResponseEntity<Transaction>(HttpStatus.ACCEPTED);
				   
				   return accBalance;
				   
		
	}
	
	 
	 @Transactional  
	  public AccountBalance withDrawAmountByAccountId( int id, AccountBalance accBalance) {
	   
	   AccountBalance accountBalance = AccountBalanceRepo.findById(id)
	   .orElseThrow(()-> new com.ibank.service.bankApplication.exception.ResourecNotFoundException("Not found"));
	   
	   double balance = accountBalance.getBalance();
	   
	   
	   
	   if(balance>0) { 
	   double balanceAfterWithdraw = balance -
	   accBalance.getBalance();
	   
	   accountBalance.setBalance(balanceAfterWithdraw);
	   AccountBalanceRepo.save(accountBalance);
	   
	   String pattern = "dd-MMM-yyyy"; java.text.SimpleDateFormat simpleDateFormat = new
	   java.text.SimpleDateFormat(pattern); String date = simpleDateFormat.format(new java.util.Date());
	   System.out.println(date);
	   
	   Transaction transaction = new Transaction(UUID.randomUUID(), id, date,
	   Constants.DEBIT, accBalance.getBalance(), Constants.SUCCESS, "");
	   
	   TransactionRepo.save(transaction); 
	    new ResponseEntity<Transaction>(HttpStatus.ACCEPTED);
	    return accountBalance;
	   
	   }else{ 
		   throw new com.ibank.service.bankApplication.exception.ResourecNotFoundException("No Balance in account"); } 
	   }
	  
	

}
