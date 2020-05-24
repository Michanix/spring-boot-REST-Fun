package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import java.util.List;

@Data
@Embeddable
@AllArgsConstructor
public class ProductsToSell {

    private final List<Product> products;
}
