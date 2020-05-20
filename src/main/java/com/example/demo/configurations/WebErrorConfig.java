package com.example.demo.configurations;

import com.example.demo.errors.JsonErrorAttributes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebErrorConfig {
  private @Value("${current-api-version}")
  String currentApiVersion;
  private @Value("${send-report-url}")
  String sendReportUrl;

  @Bean
  public ErrorAttributes errorAttributes() {
    return new JsonErrorAttributes(currentApiVersion, sendReportUrl);
  }
}
