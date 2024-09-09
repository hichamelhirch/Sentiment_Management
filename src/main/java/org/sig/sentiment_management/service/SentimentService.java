package org.sig.sentiment_management.service;

import org.sig.sentiment_management.entities.Client;
import org.sig.sentiment_management.entities.Sentiment;
import org.sig.sentiment_management.enums.TypeSentiment;
import org.sig.sentiment_management.repository.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void create(Sentiment sentiment) {
        Client client = this.clientService.readOrCreate(sentiment.getClient());
        sentiment.setClient(client);

        // Sentiment Analysis
        if (sentiment.getDescription().contains("not")) {
            sentiment.setType(TypeSentiment.NEGATIF);
        } else {
            sentiment.setType(TypeSentiment.POSITIF);
        }
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> search(TypeSentiment type) {
        if (type == null) {
            return this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(type);
        }
    }

    public void delete(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
