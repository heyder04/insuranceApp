package com.example.hackaton.dto.feedBack;

import lombok.Data;

@Data
public class FeedBackRequest {
    private Integer rating;
    private String text;
}
