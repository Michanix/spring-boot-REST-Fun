package com.example.demo.configurations;

import com.example.demo.errors.JsonErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebErrorConfig {
    private String curretApiVersion = "1.0";
    private String sendReportUri = "link/";

    @Bean
    public ErrorAttributes errorAttributes() {
        return new JsonErrorAttributes(curretApiVersion, sendReportUri);
    }
}
