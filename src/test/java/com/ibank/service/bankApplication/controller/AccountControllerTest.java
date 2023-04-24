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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibank.service.bankApplication.model.Account;
import com.ibank.service.bankApplication.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=AccountController.class)
class AccountControllerTest {

	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService AccountService;
			
	@Test
	public void getAllAccounts() throws Exception {
		
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
		
		List<Account> ls = new ArrayList<Account>();
		
		ls.add(ac1);
		ls.add(ac2);
Mockito.when(AccountService.getAllAccountDetails()).thenReturn(ls);

		
		String URI = "/api/v1/getAllAccounts";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();


		String expectedJson = net.minidev.json.JSONArray.toJSONString(ls);
		
		String outputInJson = result.getResponse().getContentAsString();
		
		assertThat(outputInJson).isEqualTo(expectedJson);
 
		
				
		
	}
	
	
	@Test
	public void getAccountById() throws Exception {

		Account ac1 = new Account();
		ac1.setAccountId(1);
		ac1.setAccountName("Praveen");
		ac1.setEmail("ash@gmail.com");
		ac1.setPhone("8870176832");
		ac1.setStatus("Active");
		
		Mockito.when(AccountService.getAccountDetailByID(1)).thenReturn(ac1);

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
			      .get("/api/v1/getAccount/1")
			      .accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		
		
		String outputInJson = result.getResponse().getContentAsString();
		
		
		
		assertThat(outputInJson.contains("Praveen"));
		assertThat(outputInJson.contains("ash@gmail.com"));
		assertThat(outputInJson.contains("8870176832"));
		assertThat(outputInJson.contains("Active"));


	}
	
	@Test
	public void checkUpdateAccountDetails() throws Exception {
		Account ac1 = new Account();
		ac1.setAccountId(1);
		ac1.setAccountName("Praveen");
		ac1.setEmail("ash@gmail.com");
		ac1.setPhone("8870173832");
		ac1.setStatus("Active");
		
		Mockito.when(AccountService.getAccountDetailByID(1)).thenReturn(ac1);
		Account ac2 = new Account();
		ac2.setAccountId(1);
		ac2.setAccountName("Praveen");
		ac2.setEmail("ash@gmail.com");
		ac2.setPhone("8870177832");
		ac2.setStatus("Active");
		
		Mockito.when(AccountService.updateAccountDetails(1,ac2)).thenReturn(ac2);
		assertThat(ac2.getPhone()!=ac1.getPhone());
		
		
		 
	}
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	

	}
	
}
