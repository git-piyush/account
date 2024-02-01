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
public class ResponseApplicantDTO {
	
	private Long applicantId;
	
	private int age;
	
	private Date dob;
}
