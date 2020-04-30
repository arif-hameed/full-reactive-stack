package com.thepracticaldeveloper.reactiveweb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thepracticaldeveloper.reactiveweb.domain.Quote;

@Repository
public interface QuoteMongoDeleteRepository extends CrudRepository<Quote, String> {
	
}
