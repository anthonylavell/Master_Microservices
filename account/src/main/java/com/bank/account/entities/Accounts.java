package com.bank.account.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter @ToString
public class Accounts {
    @Id
    @Column(name="account_number")
    private long accountNumber;

    @Column(name="customer_id")
    private int customerId;

    @Column(name="loan_type")
    private String loanType;

    @Column(name="branch_address")
    private String branchAddress;

    @Column(name="create_dt")
    private LocalDate createDt;
}
