package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.AllAccountDTO;
import com.example.demo.DTO.ResponseInfo;
import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.example.demo.utils.AppConstants;

import jakarta.validation.Valid;

//@Controller: Primarily for traditional Spring MVC applications where methods return view names.

//@RestController: Designed for RESTful services; methods return data directly to the client. 
@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	@Autowired
	/*
	 * The @Autowired annotation is used to inject the bean automatically.
	 * The @Autowired annotation is used in Constructor injection, Setter injection,
	 * and Field injection.
	 */
	AccountService accountService;

	@PostMapping("/accountAPI")
	public ResponseEntity<ResponseInfo> createAccount(@Valid @RequestBody AccountDTO accountDTO){
		ResponseInfo info = new ResponseInfo();
		try {
			accountService.createAccount(accountDTO);
			info.setStatus("Sucess");
			info.setMessage("Account has been created successfully.");
		} catch (Exception e) {
			info.setStatus("Fail");
			info.setMessage(e.getMessage());
		}
		return new ResponseEntity<ResponseInfo>(info, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllAccount")
	public ResponseEntity<AllAccountDTO> getAllAccount(
			@RequestParam(value="pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NO, required = false) int pageNo,
			@RequestParam(value="pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value="sortBy", defaultValue = AppConstants.DEFAULT_PAGE_SORT_BY, required = false) String sortBy,
			@RequestParam(value="ascDir", defaultValue = AppConstants.DEFAULT_PAGE_SORT_DIR, required = false) String ascDir
			
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
	
	/*
	 * Usage
	 * 
	 * @PathVariable: Extracts values from the URI path.
	 * 
	 * @RequestParam: Extracts values from query parameters. 
	 * 
	 * 
	 * URL Example
	 * 
	 * @PathVariable: /books/{id} -> /books/5
	 * 
	 * @RequestParam: /books?bookId=5
	 * 
	 * Optional Values
	 * 
	 * @PathVariable: Assumes values are present (though you can set it as
	 * optional).
	 * 
	 * @RequestParam: This can be optional or required. Default Values
	 * 
	 * @PathVariable: Does not support default values.
	 * 
	 * @RequestParam: Supports default values using the defaultValue attribute. Use
	 * Case
	 * 
	 * @PathVariable: Suited for RESTful web services, where the URI is used to
	 * indicate resource hierarchy.
	 * 
	 * @RequestParam: Commonly used in form submissions and traditional web
	 * applications.
	 */
	
}
