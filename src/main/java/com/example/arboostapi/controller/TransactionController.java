package com.example.arboostapi.controller;

import com.example.arboostapi.model.Card;
import com.example.arboostapi.model.Transaction;
import com.example.arboostapi.repository.CardRepository;
import com.example.arboostapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/transaction")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;

    @PostMapping(path = "/add")
    public String addTransaction (@RequestParam String sector, @RequestParam String store, @RequestParam Float total_amount, @RequestParam Float world_point)
    {
        Transaction transaction = new Transaction();

        String card_number = "4943141382383860";
        System.out.println(cardRepository.findById(card_number));
        Card tempCard = cardRepository.findById(card_number).get();

        transaction.setCard(tempCard);
        transaction.setSector(sector);
        transaction.setStore(store);
        transaction.setTotal_amount(total_amount);
        transaction.setWorld_point(world_point);

        // For debugging purposes
        Date date = new Date();
        transaction.setDate(date);

        transactionRepository.save(transaction);
        return "Transaction is saved successfully :)";
    }


    @GetMapping(path = "/all")
    public Iterable<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }


    @GetMapping(path="")
    public List<Transaction> getCardTransaction(@RequestBody Card card) {
        List<Transaction> results = new ArrayList<>();
        String card_number = card.getCard_number();
        Iterable<Transaction> allTransactions = transactionRepository.findAll();
        for (Transaction transaction : allTransactions) {
            if (transaction.getCard().getCard_number().equals(card_number)) {
                results.add(transaction);
            }
        }
        return results;
    }
}
