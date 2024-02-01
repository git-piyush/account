package com.example.demo.DTO;

import com.example.demo.entity.Account;
import com.example.demo.entity.Applicant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AccountResponseDTO {
	
	private AccountDTO account;
	
}
