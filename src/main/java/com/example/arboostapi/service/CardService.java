package com.example.arboostapi.service;

import com.example.arboostapi.model.Card;

public interface CardService {
    String addCard(String card_number, String type, Float account_limit, Float debt, Boolean is_contactless,
                   Boolean is_ecom, Boolean mail_order, String e_account_statement);

    Iterable<Card> getAllCards();

    Card getCard(String card_number, Integer id) throws Exception;
}
