package com.bank.account.controller;
import static org.mockito.ArgumentMatchers.any;

import com.bank.account.entities.Accounts;
import com.bank.account.entities.Customer;
import com.bank.account.repository.AccountsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountsControllerTest {

    @InjectMocks
    AccountsController accountsController;

    @Mock
    AccountsRepository accountsRepository;

    @Test
    public void testGetCardDetails(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Accounts account = new Accounts(186576453,1,"saving","123 flake st, Chicago",LocalDate.now());
        when(accountsRepository.findByCustomerId(1)).thenReturn(account);
        Customer customer = new Customer();
        customer.setCustomerId(1);
        Accounts accountDetails =  accountsController.getCardDetails(customer);
        Assertions.assertEquals(186576453,accountDetails.getAccountNumber());
        Assertions.assertEquals("saving",accountDetails.getLoanType());
        verify(accountsRepository,times(1)).findByCustomerId(1);
    }

}