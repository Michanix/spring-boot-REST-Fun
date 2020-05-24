package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private Double price;
  private final LocalDateTime added =
          LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS); // when the product was added
}
