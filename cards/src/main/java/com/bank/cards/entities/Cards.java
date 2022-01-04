package com.bank.cards.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter @Setter @ToString
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private int cardId;

    @Column(name="customer_id")
    private int customerId;

    @Column(name="card_number")
    private String cardNumber;

    @Column(name="card_type")
    private String cardType;

    @Column(name="total_limit")
    private int totalLimit;

    @Column(name="amount_used")
    private int amountUsed;

    @Column(name="available_amount")
    private int availableAmount;

    @Column(name="create_dt")
    private String createDt;

    public Cards(){

    }
    public Cards(int cardId, int customerId, String cardNumber, String cardType, int totalLimit, int amountUsed, int availableAmount, String createDt) {
        this.cardId = cardId;
        this.customerId = customerId;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.totalLimit = totalLimit;
        this.amountUsed = amountUsed;
        this.availableAmount = availableAmount;
        this.createDt = createDt;
    }
}
