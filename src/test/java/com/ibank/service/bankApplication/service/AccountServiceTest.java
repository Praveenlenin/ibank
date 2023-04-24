package com.ibank.service.bankApplication.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.ibank.service.bankApplication.model.Account;
import com.ibank.service.bankApplication.repository.AccountRepo;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AccountServiceTest {
		
		@Mock
		private AccountRepo AccountRepo;

		
		
		@InjectMocks
		private AccountService AccountService;
				

		

		@Test
		void getAllaccounts() {
			Account ac1 = new Account();
			ac1.setAccountId(1);
			ac1.setAccountName("Praveen");
			ac1.setEmail("ash@gmail.com");
			ac1.setPhone("8870176832");
			ac1.setStatus("Active");
			
			Account ac2 = new Account();
			ac2.setAccountId(2);
			ac2.setAccountName("Ravi");
			ac2.setEmail("ravi@gmail.com");
			ac2.setPhone("8870134832");
			ac2.setStatus("Active");
			
			List<Account> ac = new ArrayList<Account>();
			ac.add(ac2);
			ac.add(ac1);
			
			
			when(AccountService.getAllAccountDetails()).thenReturn(ac);			
		 
		}
		
		@Test
		void getAccountByID() {
			Account ac1 = new Account();
			ac1.setAccountId(1);
			ac1.setAccountName("Praveen");
			ac1.setEmail("ash@gmail.com");
			ac1.setPhone("8870176832");
			ac1.setStatus("Active");
			
			when(AccountRepo.save(ac1)).thenReturn(ac1);
			
	
		}
		
		@Test
		void updateAccountDetailsByID() {
			
						
			
			
		}


}
