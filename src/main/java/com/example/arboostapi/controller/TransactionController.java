package com.example.arboostapi.controller;

import com.example.arboostapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/transaction")
public class TransactionController {
    @Autowired
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
    public ResponseEntity getAllTransactions() {
        try {
            return new ResponseEntity(
                    transactionService.getAllTransactions(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(
                    "Error occurred while returning transactions.",
                    HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(path = "/info/{card_number}")
    public ResponseEntity getCardTransaction(@PathVariable String card_number) {
        try {
            return new ResponseEntity(
                    transactionService.getCardTransaction(card_number),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(
                    "Error occurred while returning transactions of the card.",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
