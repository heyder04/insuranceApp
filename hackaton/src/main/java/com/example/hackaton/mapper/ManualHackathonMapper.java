package com.example.hackaton.mapper;

import com.example.hackaton.dto.feedBack.FeedBackRequest;
import com.example.hackaton.dto.feedBack.FeedBackResponse;
import com.example.hackaton.dto.receiptImage.ReceiptImageResponseDto;
import com.example.hackaton.entity.FeedBackEntity;
import com.example.hackaton.entity.ReceiptImageEntity;

import java.util.List;

public interface ManualHackathonMapper {

    FeedBackResponse toFAQResponse(FeedBackEntity feedBackEntity);
    List<FeedBackResponse> toFAQResponseList(List<FeedBackEntity> faqEntities);
    FeedBackEntity convertToEntity(FeedBackRequest feedBackRequest);

    ReceiptImageResponseDto toReceiptImageResponseDto(ReceiptImageEntity receiptImage);
    List<ReceiptImageResponseDto> toReceiptImageResponseDtoList(List<ReceiptImageEntity> all);

}
