package com.example.demo.serviceImpl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.AllAccountDTO;
import com.example.demo.entity.Account;
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
	public void createAccount(AccountDTO accountDTO) {
		Account account = new Account();
		account.setAccHolderName(accountDTO.getAccHolderName());
		account.setAadhar(accountDTO.getAadhar());
		accountRepo.save(account);
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
		}
		
	        return new AllAccountDTO();
	}
	
	//convert Post Entity to postResponseDTO
	private AccountDTO mapAccountToAccountDTO(Account account) {
		
		Function<AccountDTO, Long> fun = (AccountDTO accDTO) -> accDTO.getAccNo();
		AccountDTO accDTO = mapper.map(account, AccountDTO.class);
		System.out.println(fun.apply(accDTO));
		return accDTO;
	}

}
