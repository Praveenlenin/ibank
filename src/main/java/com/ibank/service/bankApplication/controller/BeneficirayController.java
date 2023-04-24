package com.ibank.service.bankApplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibank.service.bankApplication.model.BeneficiaryAccount;

@RestController
@RequestMapping("/api/v1")
public class BeneficirayController {
	
	@Autowired
	private  com.ibank.service.bankApplication.service.BeneficiaryService BeneficiaryService;
	
	@GetMapping("/getAllBeneficiary")
	public List<BeneficiaryAccount> getAllBeneficiary() {
		return BeneficiaryService.getAllBeneficiary();
		
	}
	
	@GetMapping("/getBeneficiaryByid/{beneficiaryId}")
	public BeneficiaryAccount getBeneficiarByID(@PathVariable long beneficiaryId) {
		return BeneficiaryService.getBeneficiarByID(beneficiaryId);
	}
		
	
	@PostMapping("/addBeneficiary")
	public String addBeneficiary( @RequestBody BeneficiaryAccount beneRequestBody) {
		return BeneficiaryService.addBeneficiary(beneRequestBody);
	}
	
	@PutMapping("/updateBene/{transactionId}")
	public String updateBeneficiaryById(@PathVariable long beneficiaryId , @RequestBody BeneficiaryAccount beneRequestBody) {
		return BeneficiaryService.updateBeneficiaryById(beneficiaryId, beneRequestBody);
	}
	
	
	@DeleteMapping("/deleteBybeneficiaryId/{beneficiaryId}")
	public ResponseEntity<HttpStatus> deleteBeneficiary(@PathVariable long beneficiaryId) {
		return  BeneficiaryService.deleteBeneficiary(beneficiaryId);
	}

}
