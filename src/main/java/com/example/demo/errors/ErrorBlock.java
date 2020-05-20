package com.example.demo.errors;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ErrorBlock {

  private final UUID id;
  private final String code;
  private final String message;
  private final String path;
  private final String details;

  public ErrorBlock(
          final String code, final String message, final String path, final String details) {
    this.id = UUID.randomUUID();
    this.code = code;
    this.message = message;
    this.path = path;
    this.details = details;
  }
}
