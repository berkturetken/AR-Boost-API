package com.example.arboostapi.service;

import com.example.arboostapi.model.Transaction;
import java.util.List;

public interface TransactionService {

    String addTransaction(String sector, String store, Float total_amount, Float world_point);

    Iterable<Transaction> getAllTransactions();

    List<Transaction> getCardTransaction(String card_number);

}
