package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/*
Simple CreditCard class. With only card number, holder and expiration date fields.
The rest fields omitted for simplicity.
 */

@Embeddable
@Getter
@AllArgsConstructor
public class CreditCard {
    private final @Embedded
    CreditCardNumber cardNumber;
    private final String cardHolder;
    private final @Embedded
    ExpirationDate expirationDate;
}
