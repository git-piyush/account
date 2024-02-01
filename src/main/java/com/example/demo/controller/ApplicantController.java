package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ApplicantResponseDTO;
import com.example.demo.DTO.CreateApplicantDTO;
import com.example.demo.entity.Applicant;
import com.example.demo.service.ApplicantService;

@RequestMapping("/api/applicant")
@RestController
public class ApplicantController {
	
	@Autowired
	ApplicantService applicantService;
	
	@PostMapping("account/{accId}/createApplicantAPI")
	public ResponseEntity<Applicant> createApplicant(@PathVariable Long accId, @RequestBody CreateApplicantDTO createApplicantDTO){
		Applicant applicant = applicantService.createApplicant(accId, createApplicantDTO);
		return new ResponseEntity<Applicant>(applicant, HttpStatus.OK);
	}
	
	@GetMapping("getApplicantAPI/{applicantId}")
	public ResponseEntity<ApplicantResponseDTO> getApplicant(@PathVariable Long applicantId){
		ApplicantResponseDTO applicant = applicantService.getApplicant(applicantId);
		return new ResponseEntity<ApplicantResponseDTO>(applicant, HttpStatus.OK);
	}
	
}
