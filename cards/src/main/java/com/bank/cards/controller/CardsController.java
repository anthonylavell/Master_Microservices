package com.bank.cards.controller;

import com.bank.account.entities.Customer;
import com.bank.cards.config.CardServiceConfig;
import com.bank.cards.entities.*;
import com.bank.cards.repository.CardsRepository;
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
public class CardsController {
    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    CardServiceConfig cardConfig;

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer){
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        return cards;
    }

    @GetMapping("cards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardConfig.getMsg(),cardConfig.getBuildVersion(),
                cardConfig.getMailDetails(), cardConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
