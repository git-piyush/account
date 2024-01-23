package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.AllAccountDTO;
import com.example.demo.entity.Account;
import com.example.demo.repo.AccountRepo;
import com.example.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public void createAccount(AccountDTO accountDTO) {
		Account account = new Account();
		account.setAccHolderName(accountDTO.getAccHolderName());
		account.setAadhar(accountDTO.getAadhar());
		accountRepo.save(account);

	}

	@Override
	public List<AccountDTO> getAllAccount() {
			Iterable<Account> bankAccounts = accountRepo.findAll(); 
		    List<Account> accounrList = new ArrayList<Account>();
		    bankAccounts.forEach(accounrList::add);
		    List<AccountDTO> accountDTO = new ArrayList<>();
		    for(Account acc : accounrList) {
		    	accountDTO.add(mapAccountToAccountDTO(acc));	
		    }
	        return accountDTO;
	}
	
	//convert Post Entity to postResponseDTO
	private AccountDTO mapAccountToAccountDTO(Account account) {
		
		AccountDTO accDTO = mapper.map(account, AccountDTO.class);
		return accDTO;
	}

}
