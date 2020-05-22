package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Long> {}
