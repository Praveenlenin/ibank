package com.ibank.service.bankApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ibank.service.bankApplication.exception.ResourecNotFoundException;
import com.ibank.service.bankApplication.model.BeneficiaryAccount;
import com.ibank.service.bankApplication.repository.BeneficiaryRepo;
import com.ibank.service.bankApplication.utils.ValidationInputs;

@Service
public class BeneficiaryService {
	
	@Autowired
	private  BeneficiaryRepo BeneficiaryRepo;
	
	public List<BeneficiaryAccount> getAllBeneficiary() {
		 List<BeneficiaryAccount> list = BeneficiaryRepo.findAll();
	ResponseEntity.ok(list);
	return list;
		
	}
	
	public BeneficiaryAccount getBeneficiarByID( long beneficiaryId) {
		BeneficiaryAccount account = BeneficiaryRepo.findById(beneficiaryId)
		.orElseThrow(()-> new ResourecNotFoundException("Beneficiary Account not found on given id as" + beneficiaryId));	;
			 ResponseEntity.ok(account);
			 return account;
	}
	
	public String addBeneficiary( BeneficiaryAccount beneRequestBody) {
		if(ValidationInputs.isBeneNameValid(beneRequestBody) && ValidationInputs.isStatusValidForBene(beneRequestBody) &&
				ValidationInputs.isIFSCCODEValid(beneRequestBody)){		
				BeneficiaryRepo.save(beneRequestBody);
				}else{
					throw new ResourecNotFoundException("Please add valid credentials") ;
				};
				
		
		
		 new ResponseEntity<BeneficiaryAccount>(HttpStatus.CREATED);	
		 return "Added successfully";
		
	}
	
	public String updateBeneficiaryById( long beneficiaryId ,  BeneficiaryAccount beneRequestBody) {
		BeneficiaryAccount beneAccount = BeneficiaryRepo.findById(beneficiaryId)
		.orElseThrow(()-> new ResourecNotFoundException("BeneficiaryAccount not found on given id :" + beneficiaryId));
		
		beneAccount.setAccountId(beneRequestBody.getAccountId());
		beneAccount.setBeneficiaryIfscCode(beneRequestBody.getBeneficiaryIfscCode());
		beneAccount.setBeneficiaryName(beneRequestBody.getBeneficiaryName());
		beneAccount.setStatus(beneRequestBody.getStatus());
		
		if(ValidationInputs.isBeneNameValid(beneRequestBody) && ValidationInputs.isStatusValidForBene(beneRequestBody) &&
				ValidationInputs.isIFSCCODEValid(beneRequestBody)){		
			BeneficiaryRepo.save(beneAccount);
				}else{
					throw new ResourecNotFoundException("Please add valid credentials") ;
				};
				
		
	
				 new ResponseEntity<BeneficiaryAccount>(HttpStatus.ACCEPTED);	
				 return "Update suucessfully";
	
	}
	
	public ResponseEntity<HttpStatus> deleteBeneficiary( long beneficiaryId) {
		BeneficiaryRepo.deleteById(beneficiaryId);
		  return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
		
	}
	
	
	

}
