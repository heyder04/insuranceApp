package com.example.hackaton.service;

import com.example.hackaton.dto.feedBack.FeedBackRequest;
import com.example.hackaton.dto.feedBack.FeedBackResponse;
import com.example.hackaton.entity.FeedBackEntity;
import com.example.hackaton.exception.FeedBackException;
import com.example.hackaton.mapper.ManualHackathonMapper;
import com.example.hackaton.repository.FeedBackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedBackService {
    private final FeedBackRepository feedBackRepository;
    private final ManualHackathonMapper maunalHackatonMapper;

    public List<FeedBackResponse> getAllFeedBacks(){
        return maunalHackatonMapper.toFAQResponseList(feedBackRepository.findAll());
    }

    public FeedBackResponse getFeedBackById(Long id){
        return feedBackRepository.findById(id)
                .map(faq -> maunalHackatonMapper.toFAQResponse(faq))
                .orElseThrow(() -> new FeedBackException(id));
    }

    public Boolean addFeedBack(FeedBackRequest feedBackRequest){
        FeedBackEntity feedBackEntity = maunalHackatonMapper.convertToEntity(feedBackRequest);
        feedBackRepository.save(feedBackEntity);
        return true;
    }

    public boolean deleteFeedBack(Long id){
        FeedBackEntity feedBackEntity = feedBackRepository.findById(id)
                .orElseThrow(() -> new FeedBackException(id));
        feedBackRepository.delete(feedBackEntity);
        return true;
    }
}
