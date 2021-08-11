package com.example.arboostapi.repository;

import com.example.arboostapi.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, String> {
}
