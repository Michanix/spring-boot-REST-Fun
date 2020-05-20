package com.example.demo.errors;

import lombok.Getter;

import java.util.List;
import java.util.Map;

/*
Custom error message built by JSON:API standards
 */
@Getter
public class ApiError {

  private final String apiVersion;
  private final String sendReport = "link to reports";
  private final List<ErrorBlock> errors;

  public ApiError(String apiVersion, String code, String message, String path, String reason) {
    this.apiVersion = apiVersion;
    this.errors = List.of(new ErrorBlock(code, message, path, reason));
  }

  public static ApiError fromDefaultAttributeMap(
      String apiVersion, Map<String, Object> defaultErrorAttributes) {
    return new ApiError(
        apiVersion,
        String.valueOf(defaultErrorAttributes.get("status")),
        String.valueOf(defaultErrorAttributes.getOrDefault("message", "no message available")),
        String.valueOf(defaultErrorAttributes.getOrDefault("path", "no domain available")),
        String.valueOf(defaultErrorAttributes.getOrDefault("error", "no reason available")));
  }

  public Map<String, Object> toAttributeMap() {
    return Map.of(
        "apiVersion", apiVersion,
        "errors", errors,
        "sendReport", sendReport);
  }
}
