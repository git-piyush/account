package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.ApplicantDTO;
import com.example.demo.entity.Applicant;
@Service
public interface ApplicantService {

	public Applicant createApplicant(Long accountId, ApplicantDTO applicantDTO);

	public Applicant getApplicant(Long applicantId);
	
}
