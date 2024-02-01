package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.AllAccountDTO;
import com.example.demo.DTO.CreateAccountDTO;
import com.example.demo.DTO.ResponseInfo;
import com.example.demo.entity.Account;

@Service
public interface AccountService {
	
	public String deleteAccountById(Long accountId);
	
	public AccountDTO updateAccountById(CreateAccountDTO createAccountDTO, Long accountId);
	
	public AccountDTO getAccountById(Long accountId);
	
	public AccountDTO createAccount(CreateAccountDTO createAccountDTO);

	public AllAccountDTO getAllAccount(int pageNo, int pageSize, String sortBy, String ascDir);
	
}
