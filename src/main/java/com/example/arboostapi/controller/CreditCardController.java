package com.example.arboostapi.controller;

import com.example.arboostapi.model.CreditCard;
import com.example.arboostapi.model.User;
import com.example.arboostapi.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

// Main functionality of a Controller: Take a request and return a response!

@RestController
@RequestMapping(path = "/creditcard")
public class CreditCardController {
    @Autowired
    private CreditCardRepository creditCardRepository;

    // Alternative: Use constructor injection for the dependencies
    /*
    private final CreditCardRepository creditCardRepository;
    public CreditCardController(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }
    */

    @PostMapping(path = "/add")
    public String addCreditCard (@RequestParam String card_number, @RequestParam Float account_limit, @RequestParam Float debt,
                                               @RequestParam Boolean is_contactless, @RequestParam Boolean is_ecom,
                                               @RequestParam Boolean mail_order, @RequestParam String e_account_statement)
    {
        CreditCard creditCard = new CreditCard();

        User user = new User();
        user.setName("Anıl");
        user.setSurname("Erdoğan");

        creditCard.setUser_id(user);
        creditCard.setCard_number(card_number);
        creditCard.setAccount_limit(account_limit);
        creditCard.setDebt(debt);
        creditCard.setIs_contactless(is_contactless);
        creditCard.setIs_ecom(is_ecom);
        creditCard.setMail_order(mail_order);
        creditCard.setE_account_statement(e_account_statement);

        // Below code should be changed!
        Date date = new Date();
        creditCard.setCutoff_date(date);
        creditCard.setPayment_due_date(date);
        creditCard.setExpire_date(date);

        creditCardRepository.save(creditCard);
        return "Credit card is saved successfully :)";
    }


    @GetMapping(path = "/all")
    public Iterable<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }


    @GetMapping(path="/{card_number}")
    public CreditCard getCreditCard(@PathVariable String card_number) {
        return creditCardRepository.findById(card_number).get();
    }

}
