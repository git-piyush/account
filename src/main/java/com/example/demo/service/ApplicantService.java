package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.ApplicantResponseDTO;
import com.example.demo.DTO.CreateApplicantDTO;
import com.example.demo.entity.Applicant;
@Service
public interface ApplicantService {

	public Applicant createApplicant(Long accountId, CreateApplicantDTO createApplicantDTO);

	public ApplicantResponseDTO getApplicant(Long applicantId);
	
}
