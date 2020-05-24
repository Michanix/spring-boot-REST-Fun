package com.example.demo.errors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/*
Overriding the default Error attributes
 */

// TODO: handle errors on /api

public class JsonErrorAttributes extends DefaultErrorAttributes {
  private @Value("${current-api-version}")
  final String curretApiversion;
  private @Value("${send-report-url}")
  final String sendReportUrl;

  public JsonErrorAttributes(String curretApiversion, String sendReportUrl) {
    this.curretApiversion = curretApiversion;
    this.sendReportUrl = sendReportUrl;
  }

  @Override
  public Map<String, Object> getErrorAttributes(
          WebRequest webRequest, ErrorAttributeOptions options) {
    Map<String, Object> defAttributes = super.getErrorAttributes(webRequest, options);
    ApiError apiError =
            ApiError.fromDefaultAttributeMap(curretApiversion, sendReportUrl, defAttributes);
    return apiError.toAttributeMap();
  }
}
