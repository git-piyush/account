package com.example.demo.config;

import com.example.demo.entity.Account;
import org.springframework.batch.item.ItemProcessor;


public class AccountProcessor implements ItemProcessor<Account, Account> {

    @Override
    public Account process(Account account) throws Exception {
//        if(customer.getCountry().equals("United States")) {
//            return customer;
//        }else{
//            return null;
//        }
        return account;
    }
}
