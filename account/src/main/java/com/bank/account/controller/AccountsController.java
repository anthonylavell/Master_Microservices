package com.bank.account.controller;

import com.bank.account.config.AccountServiceConfig;
import com.bank.account.entities.*;
import com.bank.account.repository.AccountsRepository;
import com.bank.account.service.client.CardsFeignClient;
import com.bank.account.service.client.LoansFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountsController {
    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    AccountServiceConfig accountsConfig;

    @Autowired
    CardsFeignClient cardsFeignClient;

    @Autowired
    LoansFeignClient loansFeignClient;

    @PostMapping("/myAccount")
    public Accounts getCardDetails(@RequestBody Customer customer){
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId());
        return account;
    }

    @GetMapping("account/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        Properties properties = new Properties(accountsConfig.getMsg(),accountsConfig.getBuildVersion(),
                accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }

    @PostMapping("/myCustomerDetails")
    public CustomerDetails myCustomerDetails(@RequestBody Customer customer) {
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        List<Loans> loans = loansFeignClient.getLoansDetails(customer);
        List<Cards> cards = cardsFeignClient.getCardDetails(customer);

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccounts(accounts);
        customerDetails.setLoans(loans);
        customerDetails.setCards(cards);

        return customerDetails;

    }
}
