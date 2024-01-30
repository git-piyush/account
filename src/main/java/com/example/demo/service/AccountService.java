package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.AllAccountDTO;
import com.example.demo.DTO.ResponseInfo;
import com.example.demo.entity.Account;

@Service
public interface AccountService {
	
	public String deleteAccountById(Long accountId);
	
	public AccountDTO updateAccountById(AccountDTO accountDTO);
	
	public AccountDTO getAccountById(Long accountId);
	
	public void createAccount(AccountDTO accountDTO);

	public AllAccountDTO getAllAccount(int pageNo, int pageSize, String sortBy, String ascDir);
	
}
