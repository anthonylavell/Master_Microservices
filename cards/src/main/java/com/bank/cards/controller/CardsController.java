package com.bank.cards.controller;

import com.bank.account.entities.Customer;
import com.bank.cards.entities.*;
import com.bank.cards.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {
    @Autowired
    private CardsRepository cardsRepository;

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer){
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        return cards;
    }
}
