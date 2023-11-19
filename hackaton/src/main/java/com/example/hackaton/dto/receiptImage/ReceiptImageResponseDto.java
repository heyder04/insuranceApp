package com.example.hackaton.dto.receiptImage;

import lombok.Data;

@Data
public class ReceiptImageResponseDto {

    private Long receiptId;

    private String receiptImageSource;
    private String receiptImageNameForDisplay;

    private String receiptImageName;
}
