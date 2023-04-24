package com.ibank.service.bankApplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibank.service.bankApplication.model.Transaction;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
	
	@Autowired
	com.ibank.service.bankApplication.service.TransactionService TransactionService;
	
	
	 @GetMapping("/transactionlist/{accountId}")
	public List<Transaction> getAccountSummary(@PathVariable int accountId) {
		 
		return TransactionService.getAccountSummary(accountId);
		
	}
	
	 
	 
	 

}
