package com.example.arboostapi.controller;

import com.example.arboostapi.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Main functionality of a Controller: Take a request and return a response!

@RestController
@RequestMapping(path = "/card")
public class CardController {
    @Autowired
    private CardService cardService;

    // Alternative: Use constructor injection for the dependencies
    /*
    private final CreditCardRepository creditCardRepository;
    public CreditCardController(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }
    */

    @PostMapping(path = "/add")
    public ResponseEntity<String> addCard(@RequestParam String card_number, @RequestParam String type,
                                          @RequestParam Float account_limit, @RequestParam Float debt,
                                          @RequestParam Boolean is_contactless, @RequestParam Boolean is_ecom,
                                          @RequestParam Boolean mail_order, @RequestParam String e_account_statement) {
        try {
            cardService.addCard(card_number, type, account_limit, debt, is_contactless, is_ecom, mail_order, e_account_statement);
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
    public ResponseEntity getAllCards() {
        try {
            return new ResponseEntity(
                    cardService.getAllCards(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(
                    "Error occurred while returning the cards.",
                    HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(path = "/info/{card_number}")
    public ResponseEntity getCard(@PathVariable String card_number, @RequestParam Integer id) {
        try {
            return new ResponseEntity(
                    cardService.getCard(card_number, id),
                    HttpStatus.OK);
        } catch (Exception e) {
            // Get the second part (meaningful part) of the exception message
            String exception = e.toString().split(":")[1];
            return new ResponseEntity(
                    "Kart bilgilerini getirirken bir hata oluştu:" + exception,
                    HttpStatus.BAD_REQUEST);
        }
    }
}