package com.ibank.service.bankApplication.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ibank.service.bankApplication.model.Transaction;
import com.ibank.service.bankApplication.service.TransactionService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=TransactionController.class)
class TransactionControllerTest {


		@Autowired
		private MockMvc mockMvc;

		@MockBean
		private TransactionService TransactionService;
		
		@Test
		public void getAllbeneficiary() throws Exception {
			
			Transaction T1 = new Transaction();
			T1.setAccountId(1);
			T1.setAmount(1200.00);
			T1.setDate("24-apr-2023");
			T1.setTransactionId(UUID.randomUUID());
			T1.setTransactionStatus("Success");
			T1.setType("Credit");
			
			Transaction T2 = new Transaction();
			T2.setAccountId(1);
			T2.setAmount(600.00);
			T2.setDate("24-apr-2023");
			T2.setTransactionId(UUID.randomUUID());
			T2.setTransactionStatus("Success");
			T2.setType("Debit");
			
			List<Transaction> ls = new ArrayList<Transaction>();
			
			ls.add(T1);
			ls.add(T2);
			
			
	Mockito.when(TransactionService.getAccountSummary(1)).thenReturn(ls);
	
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/api/v1/transactionlist/{accountId}",1)
					.accept(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			
			String outputInJson = result.getResponse().getContentAsString();
		
			assertNotNull(outputInJson);
			assertTrue(outputInJson.contains("Success"));
			assertTrue(outputInJson.contains("Debit"));
			assertTrue(outputInJson.contains("Credit"));

	
		}

}
