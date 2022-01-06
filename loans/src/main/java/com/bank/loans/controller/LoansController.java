
package com.bank.loans.controller;



import com.bank.account.entities.Customer;
import com.bank.loans.entities.Properties;
import com.bank.loans.config.LoanServiceConfig;
import com.bank.loans.entities.Loan;
import com.bank.loans.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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

    @Autowired
    LoanServiceConfig loanConfig;

    @PostMapping("/myLoans")
    public List<Loan> getLoansDetails(@RequestBody Customer customer){
       List<Loan> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        return loans;
    }

    @GetMapping("/loans/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loanConfig.getMsg(),loanConfig.getBuildVersion(),loanConfig.getMailDetails(),
                loanConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
