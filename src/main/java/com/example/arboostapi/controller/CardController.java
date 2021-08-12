package com.example.arboostapi.controller;

import com.example.arboostapi.model.Card;
import com.example.arboostapi.model.User;
import com.example.arboostapi.repository.CardRepository;
import com.example.arboostapi.service.CardService;
import com.example.arboostapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

// Main functionality of a Controller: Take a request and return a response!

@RestController
@RequestMapping(path = "/card")
public class CardController {
    @Autowired
    private CardRepository cardRepository;

    private CardService cardService;

    // Alternative: Use constructor injection for the dependencies
    /*
    private final CreditCardRepository creditCardRepository;
    public CreditCardController(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }
    */

    @PostMapping(path = "/add")
    public ResponseEntity<String> addCard(@RequestParam String card_number, @RequestParam Float account_limit, @RequestParam Float debt,
                                          @RequestParam Boolean is_contactless, @RequestParam Boolean is_ecom,
                                          @RequestParam Boolean mail_order, @RequestParam String e_account_statement) {
        try {
            cardService.addCard(card_number, account_limit, debt, is_contactless, is_ecom, mail_order, e_account_statement);
            return new ResponseEntity<>(
                    "Card is saved successfully :)",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error occurred while saving card.",
                    HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(path = "/all")
    public ResponseEntity<String> getAllCards() {
        try {
            cardService.getAllCards();
            return new ResponseEntity<>(
                    "Cards are returned successfully :)",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error occurred while returning the cards.",
                    HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(path = "/info")
    public ResponseEntity<String> getCard(@RequestBody Card card) {
        try {
            cardService.getCard(card);
            return new ResponseEntity<>(
                    "Card info is returned successfully :)",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error occurred while returning the card info.",
                    HttpStatus.BAD_REQUEST);
        }

    }
}