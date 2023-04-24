package com.ibank.service.bankApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibank.service.bankApplication.model.AccountBalance;

@RestController
@RequestMapping("/api/v1")
public class AccountBalanceController {

	
	@Autowired
	private com.ibank.service.bankApplication.service.AccountBalanceService AccountBalanceService;
	
	
	@GetMapping("/getAccBalance")
	public List<AccountBalance> getAccBalance() {
		return AccountBalanceService.getAllAccBalance();
	}
	

	   @PutMapping("/deposit/{id}") 
	  public AccountBalance depositAmountByAccountId(@PathVariable int id,@RequestBody AccountBalance accBalance) {
	   
		return  AccountBalanceService.depositAmountByAccountId(id, accBalance);
	   
	   
	   }
	   
	   
	   @PutMapping("/withdraw/{id}") public AccountBalance
	   withDrawAmountByAccountId(@PathVariable int id,@RequestBody AccountBalance
	   accBalance) {
		 return  AccountBalanceService.withDrawAmountByAccountId(id, accBalance);
	   }
	  
	
	

}
