package com.example.hackaton.controller;

import com.example.hackaton.dto.feedBack.FeedBackRequest;
import com.example.hackaton.dto.feedBack.FeedBackResponse;
import com.example.hackaton.service.FeedBackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feedBack")
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
public class FeedBackController {
    private final FeedBackService feedBackService;

    @GetMapping
    public ResponseEntity<List<FeedBackResponse>> getAllFeedBacks(){
        return ResponseEntity.ok(feedBackService.getAllFeedBacks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedBackResponse> getFeedBackById(@PathVariable Long id){
        return ResponseEntity.ok(feedBackService.getFeedBackById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> addFeedBack(@RequestBody FeedBackRequest feedBackRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(feedBackService.addFeedBack(feedBackRequest));
    }

    @DeleteMapping("/{id}")
    public Boolean deleteFeedBack(@PathVariable Long id){
        return feedBackService.deleteFeedBack(id);
    }
}
