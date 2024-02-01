package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.AllAccountDTO;
import com.example.demo.DTO.CreateAccountDTO;
import com.example.demo.DTO.ResponseInfo;
import com.example.demo.service.AccountService;
import com.example.demo.utils.AppConstants;

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
	public String createAccountUI(@ModelAttribute("accountDTO") CreateAccountDTO createAccountDTO) {
		accountService.createAccount(createAccountDTO);
		return "redirect:/ui/account/getAllAccountUI";
	}
	
	@GetMapping("/getAllAccountUI")
	public String getAllAccountUI(Model model,
			@RequestParam(value="pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NO, required = false) int pageNo,
			@RequestParam(value="pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value="sortBy", defaultValue = AppConstants.DEFAULT_PAGE_SORT_BY, required = false) String sortBy,
			@RequestParam(value="ascDir", defaultValue = AppConstants.DEFAULT_PAGE_SORT_DIR, required = false) String ascDir
			){
		ResponseInfo info = new ResponseInfo();
		AllAccountDTO result = new AllAccountDTO();
		try {
			AllAccountDTO bankAccounts = accountService.getAllAccount(pageNo, pageSize, sortBy, ascDir);
			model.addAttribute("accountList", bankAccounts.getAccountList());
			model.addAttribute("currentPage", bankAccounts.getPageNo());
			model.addAttribute("totalPages", bankAccounts.getTotalPages());
			model.addAttribute("sortField", sortBy);
			model.addAttribute("sortOrder", ascDir);
			model.addAttribute("number", bankAccounts.getNumber());
			model.addAttribute("size", bankAccounts.getAccountList().size());
		} catch (Exception e) {
			info.setMessage(e.getMessage());
			result.setInfo(info);
		}
		return "accountlist";
	}
	
}
