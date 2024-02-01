package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.AccountResponseDTO;
import com.example.demo.DTO.AllAccountDTO;
import com.example.demo.DTO.CreateAccountDTO;
import com.example.demo.DTO.ResponseApplicantDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Applicant;
import com.example.demo.exception.AccountAppException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.AccountRepo;
import com.example.demo.service.AccountService;

import jakarta.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Transactional
	@Override
	public AccountDTO createAccount(CreateAccountDTO createAccountDTO) {
		
		Account account = mapper.map(createAccountDTO, Account.class);
		account = accountRepo.save(account);
		
		return mapper.map(account, AccountDTO.class);
		
	}

	@Transactional
	@Override
	public AllAccountDTO getAllAccount(int pageNo, int pageSize, String sortBy, String ascDir) {
			
		Sort sort = ascDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():
			Sort.by(sortBy).descending();
		Pageable page = PageRequest.of(pageNo, pageSize, sort);
		Page<Account> allAccount = accountRepo.findAll(page);
		
		if (allAccount != null) {
			List<AccountDTO> allAccounts = allAccount.getContent().stream().map(account -> mapAccountToAccountDTO(account)).collect(Collectors.toList());
			AllAccountDTO allAccountDTO = new AllAccountDTO();
			allAccountDTO.setAccountList(allAccounts);
			allAccountDTO.setPageNo(allAccount.getNumber());
			allAccountDTO.setPageSize(allAccount.getSize());
			allAccountDTO.setTotalElements(allAccount.getTotalElements());
			allAccountDTO.setTotalPages(allAccount.getTotalPages());
			allAccountDTO.setLast(allAccount.isLast());
			allAccountDTO.setNumber(allAccount.getNumber());
			return allAccountDTO;
		}else {
			throw new ResourceNotFoundException("No DATA Available.");
		}
	}
	
	private AccountDTO mapAccountToAccountDTO(Account account) {
		
		AccountDTO accDTO = mapper.map(account, AccountDTO.class);

		return accDTO;
	}

	@Transactional
	@Override
	public AccountDTO getAccountById(Long accountId) {
		List<Account> accList = new ArrayList<>();
		AccountDTO res = new AccountDTO();
		Account account = accountRepo.findById(accountId).orElseThrow(()->new ResourceNotFoundException("Account","Account id",accountId));
		res.setAccNo(account.getAccNo());
		res.setAccHolderName(account.getAccHolderName());
		res.setAadhar(account.getAadhar());
		
		if(account.getApplicant()!=null) {
			ResponseApplicantDTO app = new ResponseApplicantDTO();
			app.setAge(account.getApplicant().getAge());
			app.setDob(account.getApplicant().getDob());
			app.setApplicantId(account.getApplicant().getApplicantId());
			res.setApplicant(app);
		}
		return res;
	}

	@Transactional
	@Override
	public AccountDTO updateAccountById(CreateAccountDTO createAccountDTO, Long accountId) {
		
		Account accountDB = accountRepo.findById(accountId).orElseThrow(()->new ResourceNotFoundException("Account","Account id",accountId));
		
		accountDB.setAccHolderName(createAccountDTO.getAccHolderName());
		accountDB.setAadhar(createAccountDTO.getAadhar());
		Account account = accountRepo.save(accountDB);
		AccountDTO accDTO = mapper.map(account, AccountDTO.class);
		return accDTO;
	}

	@Transactional
	@Override
	public String deleteAccountById(Long accountId) {
		
		Account account = accountRepo.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Account", "Account Id", accountId));
		if(account !=null) {
			try {
				accountRepo.deleteById(accountId);
			} catch (Exception e) {
				throw new AccountAppException("System Error while deleting the account");
			}
		}
		return "Account has been Deleted Successfully";
	}

}
