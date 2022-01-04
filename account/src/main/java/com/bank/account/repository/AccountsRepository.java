package com.bank.account.repository;

import com.bank.account.entities.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts,Long> {
    Accounts findByCustomerId(int customerId);
}
