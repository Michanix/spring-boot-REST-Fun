package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

//TODO

@Data
public class Payment {
  private final Cart cart;
  private final LocalDateTime paymentDate;

  public Payment(Cart cart) {
    this.cart = Objects.requireNonNull(cart, "Cart is empty.");
    paymentDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
  }
}
