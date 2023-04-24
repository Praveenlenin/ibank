package com.ibank.service.bankApplication.controller;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibank.service.bankApplication.model.AccountBalance;
import com.ibank.service.bankApplication.service.AccountBalanceService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=AccountBalanceController.class)
class AccountBalanceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountBalanceService AccountBalanceService;
			

	@Test
	public void testGetAccBalance() throws Exception {
		
		AccountBalance mockBalance1 = new AccountBalance();
		
		mockBalance1.setAccountId(1);
		mockBalance1.setBalance(2000);
		
		AccountBalance mockBalance2 = new AccountBalance();
		
		mockBalance2.setAccountId(2);
		mockBalance2.setBalance(2300);
		
		
		
		List<AccountBalance> mockList = new ArrayList<AccountBalance>();
		mockList.add(mockBalance1);

		mockList.add(mockBalance2);
		
		
		
		Mockito.when(AccountBalanceService.getAllAccBalance()).thenReturn(mockList);
		
		String URI = "/api/v1/getAccBalance";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();


		String expectedJson = net.minidev.json.JSONArray.toJSONString(mockList);
		
		String outputInJson = result.getResponse().getContentAsString();
		
		assertThat(outputInJson).isEqualTo(expectedJson);
 
	
		
	}
	
	@Test
	public void checkWithdraw() throws Exception {
		
		AccountBalance accbalance = new AccountBalance();
		accbalance.setAccountId(1);
		accbalance.setBalance(2000.00);
		
		double withDrawBalance = 1000.00;
		double balanceAfterwithdraw= accbalance.getBalance() - withDrawBalance;
		
		accbalance.setBalance(balanceAfterwithdraw);
		
		
			
		Mockito.when(AccountBalanceService.withDrawAmountByAccountId(accbalance.getAccountId(),accbalance))
				.thenReturn(accbalance);
		
		assertThat(accbalance.getBalance()).isEqualTo(balanceAfterwithdraw);
				
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
	      .put("/api/v1/withdraw/{id}", 1)
	      .content(asJsonString(new AccountBalance(1, 2000)))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();


		String expectedJson = "";
		
		String outputInJson = result.getResponse().getContentAsString();
		
		assertThat(outputInJson).isEqualTo(expectedJson);
 
	
		
	}
	
	@Test
	public void checkDeposit() throws Exception {
		
		AccountBalance accbalance = new AccountBalance();
		accbalance.setAccountId(1);
		accbalance.setBalance(2000.00);
		
		double depositAmount = 1000.00;
		double balanceAfterDeposit= accbalance.getBalance() + depositAmount;
		
		accbalance.setBalance(balanceAfterDeposit);
		
		
			
		Mockito.when(AccountBalanceService.depositAmountByAccountId(accbalance.getAccountId(),accbalance))
				.thenReturn(accbalance);
		
		assertThat(accbalance.getBalance()).isEqualTo(balanceAfterDeposit);
				
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
			      .put("/api/v1/deposit/{id}", 1)
			      .content(asJsonString(new AccountBalance(1, 2000)))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();


				String expectedJson = "";
				
				String outputInJson = result.getResponse().getContentAsString();
				
				assertThat(outputInJson).isEqualTo(expectedJson);
		 
			
		
	}
	
	
	
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	
	
	}
	
}
