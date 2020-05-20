package com.example.demo.errors;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

/*
Custom error message built by JSON:API standards
 */
@Getter
@JsonPropertyOrder({"apiVersion", "sendReportUrl", "errors"})
public class ApiError {

  private @Value("${current-api-version}")
  final String apiVersion;
  private @Value("${send-report-url}")
  final String sendReportUrl;
  private final List<ErrorBlock> errors;

  public ApiError(
          String apiVersion,
          String sendReportUrl,
          String code,
          String message,
          String path,
          String reason) {
    this.apiVersion = apiVersion;
    this.sendReportUrl = sendReportUrl;
    this.errors = List.of(new ErrorBlock(code, message, path, reason));
  }

  public static ApiError fromDefaultAttributeMap(
          String apiVersion, String sendReportUrl, Map<String, Object> defaultErrorAttributes) {
    return new ApiError(
            apiVersion,
            sendReportUrl,
            String.valueOf(defaultErrorAttributes.get("status")),
            String.valueOf(defaultErrorAttributes.getOrDefault("message", "no message available")),
            String.valueOf(defaultErrorAttributes.getOrDefault("path", "no domain available")),
            String.valueOf(defaultErrorAttributes.getOrDefault("error", "no reason available")));
  }

  public Map<String, Object> toAttributeMap() {
    return Map.of(
            "apiVersion", apiVersion,
            "errors", errors,
            "sendReport", sendReportUrl);
  }
}
