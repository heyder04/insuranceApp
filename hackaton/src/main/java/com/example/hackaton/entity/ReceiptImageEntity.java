package com.example.hackaton.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class ReceiptImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long receiptId;

    private String receiptImageSource;

    private String receiptImageName;
    private String receiptImageNameForDisplay;

    private LocalDateTime createdAt;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "branch_id")
//    private ReceiptEntity receiptEntity;
}
