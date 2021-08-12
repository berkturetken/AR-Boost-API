package com.example.arboostapi.controller;

import com.example.arboostapi.model.Card;
import com.example.arboostapi.model.Transaction;
import com.example.arboostapi.repository.CardRepository;
import com.example.arboostapi.repository.TransactionRepository;
import com.example.arboostapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private TransactionService transactionService;

    @PostMapping(path = "/add")
    public ResponseEntity<String> addTransaction(@RequestParam String sector, @RequestParam String store, @RequestParam Float total_amount, @RequestParam Float world_point) {
        try {
            transactionService.addTransaction(sector, store, total_amount, world_point);
            return new ResponseEntity<>(
                    "Transaction is saved successfully :)",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error occurred while saving transaction.",
                    HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(path = "/all")
    public ResponseEntity<String> getAllTransactions() {
        try {
            transactionService.getAllTransactions();
            return new ResponseEntity<>(
                    "Transactions are returned successfully :)",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error occurred while returning transactions.",
                    HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(path = "")
    public ResponseEntity<String> getCardTransaction(@RequestBody Card card) {
        try {
            transactionService.getCardTransaction(card);
            return new ResponseEntity<>(
                    "Transactions of the card are returned successfully :)",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error occurred while returning transactions of the card.",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
