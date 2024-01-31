package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ApplicantDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Applicant;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.AccountRepo;
import com.example.demo.repo.ApplicantRepo;
import com.example.demo.service.AccountService;
import com.example.demo.service.ApplicantService;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	ApplicantRepo applicantRepo;
	
	@Override
	public Applicant createApplicant(Long accountId, ApplicantDTO applicantDTO) {
		Account account = accountRepo.findById(accountId).orElseThrow(()->new ResourceNotFoundException("Account","Account Id",accountId));
		
		Applicant applicant = new Applicant();
		applicant.setAge(applicantDTO.getAge());
		applicant.setDob(applicantDTO.getDob());
		Applicant applicantDb = null;
		if(account!=null) {
			applicant.setAccount(account);
			applicantDb = applicantRepo.save(applicant);
		}
		
		return applicantDb;
	}

	@Override
	public Applicant getApplicant(Long applicantId) {
		
		Applicant applicant = applicantRepo.findById(applicantId).orElseThrow(()->new ResourceNotFoundException("Applicant","Applicant Id",applicantId));
		
		return applicant;
	}

}
