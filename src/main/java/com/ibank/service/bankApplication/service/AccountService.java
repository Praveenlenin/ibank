package com.ibank.service.bankApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ibank.service.bankApplication.exception.ResourecNotFoundException;
import com.ibank.service.bankApplication.model.Account;
import com.ibank.service.bankApplication.repository.AccountRepo;
import com.ibank.service.bankApplication.utils.ValidationInputs;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepo AccountRepo;
	
	public  List<Account> getAllAccountDetails() {
	 List<Account> list = AccountRepo.findAll();
 			 ResponseEntity.ok(list);
 			return list;
	}
	
	public Account getAccountDetailByID(int id) {
			Account account = AccountRepo.findById(id)
			.orElseThrow(()-> new ResourecNotFoundException("Account not found on given id as" + id))	;
				 ResponseEntity.ok(account);
				 
				 return account;
		}
	
	
public Account updateAccountDetails(int id ,  Account accountRequest) {
		
		Account account = AccountRepo.findById(id)
		.orElseThrow(()-> new ResourecNotFoundException("Account not found on given id as" + id));
		
		
		
		account.setAccountName(accountRequest.getAccountName());
		account.setEmail(accountRequest.getEmail());
		account.setPhone(accountRequest.getPhone());
		account.setStatus(accountRequest.getStatus());
		
		if(ValidationInputs.isAccountNameValid(account) && ValidationInputs.isStatusValid(account) &&
		ValidationInputs.isEmailIDValid(account) && ValidationInputs.isPhoneNumberValid(account)){		
			AccountRepo.save(account);
		}else{
			throw new ResourecNotFoundException("Please add valid credentials") ;
		};
		
		 ResponseEntity.ok(account);
		 return account;

	}


}
