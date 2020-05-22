package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersController extends CrudRepository<Customer, Long> {}
