package com.example.arboostapi.controller;

import com.example.arboostapi.model.Card;
import com.example.arboostapi.model.User;
import com.example.arboostapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

// Main functionality of a Controller: Take a request and return a response!

@RestController
@RequestMapping(path = "/card")
public class CardController {
    @Autowired
    private CardRepository cardRepository;

    // Alternative: Use constructor injection for the dependencies
    /*
    private final CreditCardRepository creditCardRepository;
    public CreditCardController(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }
    */

    @PostMapping(path = "/add")
    public String addCard (@RequestParam String card_number, @RequestParam Float account_limit, @RequestParam Float debt,
                                               @RequestParam Boolean is_contactless, @RequestParam Boolean is_ecom,
                                               @RequestParam Boolean mail_order, @RequestParam String e_account_statement)
    {
        Card card = new Card();

        User user = new User();
        user.setName("Egecan");
        user.setSurname("Ceylan");

        card.setUser_id(user);
        card.setCard_number(card_number);
        card.setAccount_limit(account_limit);
        card.setDebt(debt);
        card.setIs_contactless(is_contactless);
        card.setIs_ecom(is_ecom);
        card.setMail_order(mail_order);
        card.setE_account_statement(e_account_statement);

        // Below code should be changed!
        Date date = new Date();
        card.setCutoff_date(date);
        card.setPayment_due_date(date);
        card.setExpire_date(date);

        cardRepository.save(card);
        return "Credit card is saved successfully :)";
    }


    @GetMapping(path = "/all")
    public Iterable<Card> getAllCards() {
        return cardRepository.findAll();
    }


    @GetMapping(path="/info")
    public Card getCard(@RequestBody Card card) {
        //System.out.println(card.getCard_number());
        String card_number = card.getCard_number();
        return cardRepository.findById(card_number).get();
    }
}