package com.example.hackaton.repository;

import com.example.hackaton.entity.FeedBackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepository extends JpaRepository<FeedBackEntity, Long> {
}
