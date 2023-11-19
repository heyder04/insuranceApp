package com.example.hackaton.exception;

import com.example.hackaton.exception.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(FeedBackException.class)
    public ResponseEntity<ErrorResponse> feedBackExceptionHandler(FeedBackException ex){
        return ResponseEntity.status(NOT_FOUND).body(new ErrorResponse(NOT_FOUND.value(), ex.getMessage()));
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(ReceiptImageException.class)
    public ResponseEntity<ErrorResponse> receiptImageExceptionHandler(ReceiptImageException ex){
        return ResponseEntity.status(NOT_FOUND).body(new ErrorResponse(NOT_FOUND.value(), ex.getMessage()));
    }


}
