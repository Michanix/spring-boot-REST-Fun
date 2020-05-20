package com.example.demo.errors;

public class CarNotFoundException extends RuntimeException {
  public CarNotFoundException(Long id) {
    super("Car object with id " + id + " not found.");
  }
}
