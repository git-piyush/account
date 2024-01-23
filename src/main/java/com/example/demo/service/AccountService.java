package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.ResponseInfo;
import com.example.demo.entity.Account;

@Service
public interface AccountService {

	public void createAccount(AccountDTO accountDTO);

	public List<AccountDTO> getAllAccount();
	
}
