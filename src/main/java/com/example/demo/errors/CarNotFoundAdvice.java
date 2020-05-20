package com.example.demo.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CarNotFoundAdvice extends ResponseEntityExceptionHandler {

  private String currentApiVersion = "1.0";

  @ExceptionHandler(CarNotFoundException.class)
  public ResponseEntity<ApiError> handleNonExistingHero(CarNotFoundException ex,
                                                        HttpServletRequest request) {
    ApiError error =
        new ApiError(
            currentApiVersion,
            String.valueOf(HttpStatus.NOT_FOUND.value()),
            ex.getLocalizedMessage(),
            request.getRequestURI(),
            ex.getClass().getSimpleName() + " is thrown. Cannot found the Car object");
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
