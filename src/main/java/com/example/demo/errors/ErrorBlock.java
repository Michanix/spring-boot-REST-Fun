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
  //private final List<Error> errors;

  public ErrorBlock(
      final String code,
      final String message,
      final String path,
      final String details) {
    this.id = UUID.randomUUID();
    this.code = code;
    this.message = message;
    this.path = path;
    this.details = details;
    //this.errors = List.of(new Error(domain, reason, errorMessage, errorReportUri + "?id=" + id));
  }
/*
  private ErrorBlock(
      final UUID id, final String code, final String message) {
    this.id = id;
    this.code = code;
    this.message = message;
    //this.errors = errors;
  }

  public ErrorBlock copyWithMessage(final ErrorBlock s, final String message) {
    return new ErrorBlock(s.id, s.code, message); //errors);
  }

 */
}
