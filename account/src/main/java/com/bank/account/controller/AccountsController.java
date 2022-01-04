package com.bank.account.controller;

import com.bank.account.entities.Accounts;
import com.bank.account.entities.Customer;
import com.bank.account.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountsController {
    @Autowired
    private AccountsRepository accountsRepository;

    @PostMapping("/myAccount")
    public Accounts getCardDetails(@RequestBody Customer customer){
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId());
        return account;
    }
}
