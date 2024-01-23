package com.example.demo.DTO;

import java.util.List;

import com.example.demo.entity.Account;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AllAccountDTO {

	private List<AccountDTO> accountList;
	
	private int pageNo;

	private int pageSize;

	private long totalElements;

	private int totalPages;

	private boolean last;
	
	private ResponseInfo info;
	
}
