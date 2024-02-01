package com.example.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AccountDTO {


	public AccountDTO(Long accNo, String accHolderName, Long aadhar) {
		super();
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.aadhar = aadhar;
	}

	private Long accNo;
	
	private String accHolderName;
	
	private Long aadhar;
	
	private ResponseApplicantDTO applicant;
	
}
