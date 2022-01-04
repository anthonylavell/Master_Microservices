
package com.bank.loans.controller;



import com.bank.account.entities.Customer;
import com.bank.loans.entities.Loan;
import com.bank.loans.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
public class LoansController {

    @Autowired
    LoansRepository loansRepository;

    @PostMapping("/myLoans")
    public List<Loan> getLoansDetails(@RequestBody Customer customer){
       List<Loan> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        return loans;
    }
}
