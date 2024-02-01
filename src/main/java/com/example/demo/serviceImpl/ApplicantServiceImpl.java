package com.example.demo.serviceImpl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.ApplicantResponseDTO;
import com.example.demo.DTO.CreateApplicantDTO;
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
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Applicant createApplicant(Long accountId, CreateApplicantDTO createApplicantDTO) {
		Account account = accountRepo.findById(accountId).orElseThrow(()->new ResourceNotFoundException("Account","Account Id",accountId));
		Applicant applicant = new Applicant();
		applicant.setAge(createApplicantDTO.getAge());
		applicant.setDob(createApplicantDTO.getDob());
		Applicant applicantDb = null;
		if(account!=null) {
			applicant.setAccount(account);
			applicantDb = applicantRepo.save(applicant);
		}
		
		return applicantDb;
	}

	@Override
	public ApplicantResponseDTO getApplicant(Long applicantId) {
		ApplicantResponseDTO accDTO = new ApplicantResponseDTO();
		Applicant applicant = applicantRepo.findById(applicantId).orElseThrow(()->new ResourceNotFoundException("Applicant","Applicant Id",applicantId));
		
		accDTO = Stream.of(applicant).map((app)->new ApplicantResponseDTO(app.getApplicantId(), app.getAge(), app.getDob())).collect(Collectors.toList()).get(0);
		Account account = applicant.getAccount();
		AccountDTO res = Stream.of(account).map((acc)-> new AccountDTO(acc.getAccNo(), acc.getAccHolderName(), acc.getAadhar())).collect(Collectors.toList()).get(0);
		
		accDTO.setAccount(res);
		return accDTO;
	}

}
