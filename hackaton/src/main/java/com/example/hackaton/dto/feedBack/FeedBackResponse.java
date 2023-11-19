package com.example.hackaton.dto.feedBack;

import lombok.*;

//@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedBackResponse {
    private Long deviceId;
    private Integer rating;
    private String text;
}
