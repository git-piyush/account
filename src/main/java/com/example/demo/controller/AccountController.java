package com.example.demo.controller;

import java.security.Principal;

import com.example.demo.security.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.AllAccountDTO;
import com.example.demo.DTO.CreateAccountDTO;
import com.example.demo.DTO.ResponseInfo;
import com.example.demo.entity.Account;
import com.example.demo.exception.ApplicationSqlException;
import com.example.demo.service.AccountService;
import com.example.demo.service.UserService;
import com.example.demo.utils.AppConstants;
import jakarta.validation.Valid;

//@Controller: Primarily for traditional Spring MVC applications where methods return view names.

//@RestController: Designed for RESTful services; methods return data directly to the client. 
@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	private static Logger log = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;


	@Autowired
	private JwtHelper helper;


	@PreAuthorize("hasAuthority('CREATE')")
	@PostMapping("/createAccountAPI")
	public ResponseEntity<ResponseInfo> createAccount(@Valid @RequestBody CreateAccountDTO createAccountDTO, Principal p){
		ResponseInfo info = new ResponseInfo();

		try {
			System.out.println(p.getName());
			AccountDTO newAccount = accountService.createAccount(createAccountDTO);
			info.setStatus("Sucess");
			info.setMessage("Account has been created successfully with Account No: "+newAccount.getAccNo());
		} catch (Exception e) {
			info.setStatus("Fail");
			info.setMessage(e.getMessage());
		}
		return new ResponseEntity<ResponseInfo>(info, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('READ')")
	@GetMapping("/getAllAccount")
	public ResponseEntity<AllAccountDTO> getAllAccount(
			@RequestParam(value="pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NO, required = false) int pageNo,
			@RequestParam(value="pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value="sortBy", defaultValue = AppConstants.DEFAULT_PAGE_SORT_BY, required = false) String sortBy,
			@RequestParam(value="ascDir", defaultValue = AppConstants.DEFAULT_PAGE_SORT_DIR, required = false) String ascDir,
			Principal p
			){
		ResponseInfo info = new ResponseInfo();
		AllAccountDTO result = new AllAccountDTO();
		try {
			result = accountService.getAllAccount(pageNo, pageSize, sortBy, ascDir);
			info.setStatus("Success");
			info.setMessage("Account details has been fetched successfully.");
			result.setInfo(info);
		} catch (Exception e) {
			info.setStatus("Fail");
			info.setMessage(e.getMessage());
			result.setInfo(info);
		}
		return new ResponseEntity<AllAccountDTO>(result, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('READ')")
	@GetMapping("/getAccount/{accountId}")
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long accountId){
		
		AccountDTO accDTO = accountService.getAccountById(accountId);
		return new ResponseEntity<AccountDTO>(accDTO, HttpStatus.OK);
		
	}

	@PreAuthorize("hasAuthority('DELETE')")
	@DeleteMapping("/deleteAccount/{accountId}")
	public ResponseEntity<String> deleteAccountById(@PathVariable Long accountId){
		
		String msg = accountService.deleteAccountById(accountId);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}

	@PreAuthorize("hasAuthority('UPDATE')")
	@PutMapping("/updateAccount/{accountId}")
	public ResponseEntity<AccountDTO> updateAccount(@RequestBody CreateAccountDTO createAccountDTO,
			@PathVariable Long accountId){
		AccountDTO accDTO = null;
		try {
			accDTO = accountService.updateAccountById(createAccountDTO, accountId);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new ApplicationSqlException(e.getMessage());
		}
		return new ResponseEntity<AccountDTO>(accDTO, HttpStatus.OK);
		
	}
	
}
