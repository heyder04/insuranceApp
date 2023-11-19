package com.example.hackaton.mapper.impl;

import com.example.hackaton.dto.feedBack.FeedBackRequest;
import com.example.hackaton.dto.feedBack.FeedBackResponse;
import com.example.hackaton.dto.receiptImage.ReceiptImageResponseDto;
import com.example.hackaton.entity.FeedBackEntity;
import com.example.hackaton.entity.ReceiptImageEntity;
import com.example.hackaton.mapper.ManualHackathonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ManualHackathonMapperImpl implements ManualHackathonMapper {

    @Override
    public FeedBackResponse toFAQResponse(FeedBackEntity feedBackEntity) {
        FeedBackResponse feedBackResponse = new FeedBackResponse(feedBackEntity.getDeviceId(), feedBackEntity.getRating(), feedBackEntity.getText());
        return feedBackResponse;
    }

    @Override
    public List<FeedBackResponse> toFAQResponseList(List<FeedBackEntity> faqEntities) {
        List<FeedBackResponse> list = new ArrayList<FeedBackResponse>( faqEntities.size() );
        for ( FeedBackEntity fAQEntity : faqEntities ) {
            list.add( toFAQResponse( fAQEntity ) );
        }

        return list;
    }

    @Override
    public FeedBackEntity convertToEntity(FeedBackRequest feedBackRequest) {
        return FeedBackEntity.builder()
                .text(feedBackRequest.getText())
                .rating(feedBackRequest.getRating())
                .build();
    }

    @Override
    public ReceiptImageResponseDto toReceiptImageResponseDto(ReceiptImageEntity receiptImage) {
        if ( receiptImage == null ) {
            return null;
        }

        ReceiptImageResponseDto receiptImageResponseDto = new ReceiptImageResponseDto();

        receiptImageResponseDto.setReceiptId( receiptImage.getReceiptId() );
        receiptImageResponseDto.setReceiptImageSource( receiptImage.getReceiptImageSource() );
        receiptImageResponseDto.setReceiptImageName( receiptImage.getReceiptImageName() );
        receiptImageResponseDto.setReceiptImageNameForDisplay(receiptImage.getReceiptImageNameForDisplay());

        return receiptImageResponseDto;
    }

    @Override
    public List<ReceiptImageResponseDto> toReceiptImageResponseDtoList(List<ReceiptImageEntity> all) {
        if ( all == null ) {
            return null;
        }

        List<ReceiptImageResponseDto> list = new ArrayList<ReceiptImageResponseDto>( all.size() );
        for ( ReceiptImageEntity corporateFileEntity : all ) {
            list.add( toReceiptImageResponseDto( corporateFileEntity ) );
        }

        return list;
    }
}
