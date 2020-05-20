package com.example.demo.errors;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/*
Overriding the default Error attributes
 */

public class JsonErrorAttributes extends DefaultErrorAttributes {
    private final String curretApiversion;
    private final String sendReport;

    public JsonErrorAttributes(String curretApiversion,
                               String sendReport) {
        this.curretApiversion = curretApiversion;
        this.sendReport = sendReport;
    }

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> defAttributes =  super.getErrorAttributes(webRequest, options);
        ApiError apiError = ApiError.fromDefaultAttributeMap(curretApiversion, defAttributes);
        return apiError.toAttributeMap();
    }
}
