package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {
  //  @OneToMany
  //  private @Embedded ProductsToSell productsToSell;
  private final LocalDateTime created =
          LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS); // when was customer created
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstname;
  private String lastname;
  private String email;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "creditcard_id", referencedColumnName = "id")
  private CreditCard creditCard;
}
