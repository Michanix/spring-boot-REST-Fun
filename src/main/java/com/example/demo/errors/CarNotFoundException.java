package com.example.demo.errors;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(Long id) {
        super(id + " not found.");
    }
}
