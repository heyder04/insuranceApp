package com.example.hackaton.mapper;

import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface HackatonMapper {

//    FAQResponse toFAQResponse(FAQEntity faqEntity);
//    List<FAQResponse> toFAQResponseList(List<FAQEntity> faqEntities);
//    FAQEntity convertToEntity(FAQRequest faqRequest);
}
