package com.example.demo.customJson;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomJSONResponse {
    private final String code;
    private final String status;
    private final String message;
}
