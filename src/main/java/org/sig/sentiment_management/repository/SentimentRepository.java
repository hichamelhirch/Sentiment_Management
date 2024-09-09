package org.sig.sentiment_management.repository;

import org.sig.sentiment_management.entities.Sentiment;
import org.sig.sentiment_management.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment,Integer> {
    List<Sentiment> findByType(TypeSentiment type);
}
