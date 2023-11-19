package com.example.hackaton.exception;

public class ReceiptImageException extends RuntimeException{

    public static final String MESSAGE = "Receipt image %s does not exist";

    public ReceiptImageException(Long authorId) {
        super(String.format(MESSAGE, authorId));
    }
}
