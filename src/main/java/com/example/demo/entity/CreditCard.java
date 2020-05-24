package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/*
Simple CreditCard class. With only card number, holder and expiration date fields.
The rest fields omitted for simplicity.
 */

@Data
@AllArgsConstructor
@Entity
public class CreditCard {
  private final String number;
  private final String cardHolder;
  private final int year;
  private final int month;
  @OneToOne(mappedBy = "creditCard")
  private final Account account;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
}
