package com.thepracticaldeveloper.reactiveweb.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.thepracticaldeveloper.reactiveweb.repository.QuoteMongoDeleteRepository;

@RestController
public class QuoteDeleteController {

    private QuoteMongoDeleteRepository quoteMongoDeleteRepository;

    public QuoteDeleteController(final QuoteMongoDeleteRepository quoteMongoDeleteRepository) {
        this.quoteMongoDeleteRepository = quoteMongoDeleteRepository;
    }
    
    @DeleteMapping(value = "/quote-delete/{id}")
    public String deleteQuote(@PathVariable String id) {
        this.quoteMongoDeleteRepository.deleteById(id);

        return "Quote has been deleted successfully";
    }    
}
