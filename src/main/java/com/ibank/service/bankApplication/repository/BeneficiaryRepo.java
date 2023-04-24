package com.ibank.service.bankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibank.service.bankApplication.model.BeneficiaryAccount;

@Repository
public interface BeneficiaryRepo extends JpaRepository<BeneficiaryAccount, Long> {

}
