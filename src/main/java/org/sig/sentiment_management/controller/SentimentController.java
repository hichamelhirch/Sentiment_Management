package org.sig.sentiment_management.controller;

import org.sig.sentiment_management.entities.Sentiment;
import org.sig.sentiment_management.service.SentimentService;
import org.sig.sentiment_management.enums.TypeSentiment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RestController
@RequestMapping(path = "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {
    private final SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Sentiment sentiment) {
        this.sentimentService.create(sentiment);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> search(@RequestParam(required = false) TypeSentiment type) {
        return this.sentimentService.search(type);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) {
        this.sentimentService.delete(id);
    }
}

