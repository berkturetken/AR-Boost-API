package com.example.arboostapi.controller;

import com.example.arboostapi.model.CreditCard;
import com.example.arboostapi.model.User;
import com.example.arboostapi.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(path = "/creditcard")
public class CreditCardController {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addCreditCard (@RequestParam Integer card_number, @RequestParam Float account_limit, @RequestParam Float debt) {
        CreditCard creditCard = new CreditCard();
        // test
        User user = new User();
        user.setName("Test");
        user.setSurname("TestSurname");

        creditCard.setUser_id(user);
        creditCard.setCard_number(card_number);
        creditCard.setAccount_limit(account_limit);
        creditCard.setDebt(debt);

        // Below code should be changed!
        Date date = new Date();
        creditCard.setCutoff_date(date);
        creditCardRepository.save(creditCard);
        return "Credit card is saved successfully :)";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }
}
