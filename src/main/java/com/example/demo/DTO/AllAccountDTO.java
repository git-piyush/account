package com.example.demo.DTO;

import java.util.List;

import com.example.demo.entity.Account;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AllAccountDTO {

	private List<AccountDTO> accountList;
	
	private ResponseInfo info;
	
}
