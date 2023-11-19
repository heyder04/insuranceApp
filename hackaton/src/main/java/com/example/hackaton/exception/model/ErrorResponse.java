package com.example.hackaton.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class ErrorResponse {
    private Integer httpStatus;
    private final String message;

}