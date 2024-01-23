package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.AllAccountDTO;
import com.example.demo.DTO.ResponseInfo;
import com.example.demo.service.AccountService;

@RequestMapping("/ui/account")
@Controller
public class AccountControllerUI {
	
	@Autowired
	AccountService accountService;

	@GetMapping("/dashboard")
	public String getDashBoard() {
		return "index";
	}
	
	@GetMapping("/accountform")
	public String getAccountForm(Model model) {
		model.addAttribute("accountDTO", new AccountDTO());
		return "accountform";
	}
	
	@PostMapping("/createAccountUI")
	public String createAccountUI(@ModelAttribute("accountDTO") AccountDTO accountDTO) {
		accountService.createAccount(accountDTO);
		return "redirect:/ui/account/getAllAccountUI";
	}
	
	@GetMapping("/getAllAccountUI")
	public String getAllAccountUI(Model model){
		System.out.println("getAllAccountUI");
		ResponseInfo info = new ResponseInfo();
		AllAccountDTO result = new AllAccountDTO();
		try {
			List<AccountDTO> bankAccounts = accountService.getAllAccount();
			model.addAttribute("accountList", bankAccounts);
		} catch (Exception e) {
			info.setMessage(e.getMessage());
			result.setInfo(info);
		}
		return "accountlist";
	}
	
}
