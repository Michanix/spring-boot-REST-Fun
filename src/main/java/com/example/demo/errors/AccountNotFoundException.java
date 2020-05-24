package com.example.demo.errors;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Long id) {
        super("Account with id " + id + " not found.");
    }
}
