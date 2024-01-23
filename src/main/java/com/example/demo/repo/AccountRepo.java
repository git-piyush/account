package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.Account;

public interface AccountRepo extends CrudRepository<Account, Long>, PagingAndSortingRepository<Account, Long> {

}
