package com.example.demo.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantResponseDTO {

	
	
	public ApplicantResponseDTO(Long applicantId, int age, Date dob) {
		super();
		this.applicantId = applicantId;
		this.age = age;
		this.dob = dob;
	}

	private Long applicantId;
	
	private int age;
	
	private Date dob;
	
	private AccountDTO account;
	
	
	
}
