package com.ibank.service.bankApplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.ibank.service.bankApplication.model.AccountBalance;
import com.ibank.service.bankApplication.model.Transaction;
import com.ibank.service.bankApplication.repository.AccountBalanceRepo;
import com.ibank.service.bankApplication.repository.TransactionRepo;

@ExtendWith(MockitoExtension.class)
class AccountBalanceServiceTest {

	@Mock
	private AccountBalanceRepo AccountBalanceRepo;

	@Mock
	private TransactionRepo TransactionRepo;

	@InjectMocks
	private AccountBalanceService AccountBalanceService;

	@Test
	void getAllaccBalance() {

		AccountBalance mockBalance1 = new AccountBalance();

		mockBalance1.setAccountId(1);
		mockBalance1.setBalance(2000);

		AccountBalance mockBalance2 = new AccountBalance();

		mockBalance2.setAccountId(2);
		mockBalance2.setBalance(2300);

		List<AccountBalance> mockList = new ArrayList<AccountBalance>();
		mockList.add(mockBalance1);

		mockList.add(mockBalance2);

		AccountBalanceRepo.save(mockBalance1);
		AccountBalanceRepo.save(mockBalance2);

		when(AccountBalanceRepo.findAll()).thenReturn(mockList);

		List<AccountBalance> AccountBalanceList = AccountBalanceService.getAllAccBalance();

		assertThat(AccountBalanceList).isNotNull();
		assertThat(AccountBalanceList.size()).isEqualTo(2);

	}

	@Test
	void depositAmountByAccountId() {

		AccountBalance mockBalance1 = new AccountBalance();

		mockBalance1.setAccountId(1);
		mockBalance1.setBalance(2000);

		when(AccountBalanceRepo.findById(1)).thenReturn(Optional.of(mockBalance1));

		AccountBalance UpdatedmockBalance1 = new AccountBalance();

		UpdatedmockBalance1.setAccountId(1);
		UpdatedmockBalance1.setBalance(2000);

		AccountBalanceRepo.save(UpdatedmockBalance1);

		Optional<AccountBalance> findById = AccountBalanceRepo.findById(1);

		assertEquals(findById.get().getBalance(), 2000);

		String pattern = "dd-MMM-yyyy";
		java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new java.util.Date());

		Transaction transaction = new Transaction();
		transaction.setAccountId(1);
		transaction.setAmount(2000.00);
		transaction.setDate(date);
		transaction.setTransactionId(UUID.randomUUID());
		transaction.setTransactionStatus("Success");
		transaction.setType("Credit");
		
		
		
		TransactionRepo.save(transaction);

		assertThat(TransactionRepo.save(transaction));
		
		

	}
	
	@Test
	void WithdrawAmountByAccountId() {

		AccountBalance mockBalance1 = new AccountBalance();

		mockBalance1.setAccountId(1);
		mockBalance1.setBalance(2000);

		when(AccountBalanceRepo.findById(1)).thenReturn(Optional.of(mockBalance1));

		AccountBalance UpdatedmockBalance1 = new AccountBalance();

		UpdatedmockBalance1.setAccountId(1);
		UpdatedmockBalance1.setBalance(1000);

		AccountBalanceRepo.save(UpdatedmockBalance1);

		Optional<AccountBalance> findById = AccountBalanceRepo.findById(1);

		assertEquals(findById.get().getBalance(), 2000);

		String pattern = "dd-MMM-yyyy";
		java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new java.util.Date());

		Transaction transaction = new Transaction();
		transaction.setAccountId(1);
		transaction.setAmount(1000.00);
		transaction.setDate(date);
		transaction.setTransactionId(UUID.randomUUID());
		transaction.setTransactionStatus("Success");
		transaction.setType("Debit");
		List<Transaction> mockListTrans = new ArrayList<Transaction>();
		
		mockListTrans.add(transaction);
		
		
		TransactionRepo.save(transaction);
		
		assertThat(TransactionRepo.save(transaction));
		

	}

}
