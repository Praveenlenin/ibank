package com.ibank.service.bankApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibank.service.bankApplication.model.Account;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
	
	@Autowired
	private  com.ibank.service.bankApplication.service.AccountService AccountService;
	
	
	@GetMapping(value = "/getAllAccounts")
	public  List<Account> getAllAccountDetails() {
	 
		return AccountService.getAllAccountDetails();
	}
	
	@GetMapping("/getAccount/{id}")
	public Account getAccountDetailByID(@PathVariable int id) {
		return AccountService.getAccountDetailByID(id);
	}
	
	

	@PutMapping("/updateAccount/{id}")
	public Account updateAccountDetails(@PathVariable int id , @RequestBody Account accountRequest) {
		return AccountService.updateAccountDetails(id, accountRequest);
	}
	
	
	

}
