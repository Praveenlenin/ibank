package com.ibank.service.bankApplication.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibank.service.bankApplication.model.BeneficiaryAccount;
import com.ibank.service.bankApplication.service.BeneficiaryService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=BeneficirayController.class)
class BeneficirayControllerTest {

	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BeneficiaryService BeneficiaryService;
	
	
	@Test
	public void getAllbeneficiary() throws Exception {
		
		BeneficiaryAccount b1 = new BeneficiaryAccount();
		b1.setAccountId(1);
		b1.setBeneficiaryAccountId(1);
		b1.setBeneficiaryIfscCode("IFSC0123456");
		b1.setStatus("Active");
	List<BeneficiaryAccount> ls = new ArrayList<BeneficiaryAccount>();
		
		ls.add(b1);
		
Mockito.when(BeneficiaryService.getAllBeneficiary()).thenReturn(ls);

		
		
		String URI = "/api/v1/addBeneficiary";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();


		String expectedJson = "";
		
		String outputInJson = result.getResponse().getContentAsString();
		
		assertThat(outputInJson).isEqualTo(expectedJson);
 
		
				
		
	}
	
	@Test
	public void checkUpdateBenebyID() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
			      .put("/api/v1//updateBene/{transactionId}", 1)
			      .content(asJsonString(new BeneficiaryAccount()))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();


				String expectedJson = "";
				
				String outputInJson = result.getResponse().getContentAsString();
				
				assertThat(outputInJson).isEqualTo(expectedJson);
		
	}
	
	@Test
	public void deleteEmployeeAPI() throws Exception 
	{
		BeneficiaryAccount b1 = new BeneficiaryAccount();
		b1.setAccountId(1);
		b1.setBeneficiaryAccountId(1);
		b1.setBeneficiaryIfscCode("IFSC0123456");
		b1.setStatus("Active");
		
		BeneficiaryService.addBeneficiary(b1);
		
		ResponseEntity<HttpStatus> deleteBeneficiary = BeneficiaryService.deleteBeneficiary(b1.getBeneficiaryAccountId());
		
		assertNull(deleteBeneficiary);	
		

		
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	

	}}
