package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.Month;
import java.time.Year;

@Getter
@Embeddable
@AllArgsConstructor
public class ExpirationDate {
    private final Month month;
    private final Year year;
}
