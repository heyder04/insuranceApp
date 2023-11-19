package com.example.hackaton.exception;

public class FeedBackException extends RuntimeException{

    public static final String MESSAGE = "Feedback %s does not exist";

    public FeedBackException(Long authorId) {
        super(String.format(MESSAGE, authorId));
    }
}
