package com.ibank.service.bankApplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibank.service.bankApplication.model.Transaction;
import com.ibank.service.bankApplication.repository.TransactionRepo;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepo TransactionRepo;
	
	
	public List<Transaction> getAccountSummary( int accountId) {
		 
		 List<Transaction> list = TransactionRepo.findAll();
			
		List<Transaction> transactionList = list.stream().filter(p-> p.getAccountId()==accountId).collect(Collectors.toList());
			
			return transactionList;
		
	}
	
	

}
