package com.example.arboostapi.service;

import com.example.arboostapi.model.Card;
import com.example.arboostapi.model.User;
import com.example.arboostapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public String addCard(String card_number, String type, Float account_limit, Float debt, Boolean is_contactless,
                          Boolean is_ecom, Boolean mail_order, String e_account_statement) {
        try {
            Card card = new Card();

            User user = new User();
            user.setName("Egecan");
            user.setSurname("Ceylan");

            card.setType(type);
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
        } catch (Exception e) {
            return "Error occurred while saving the card." + e.toString();
        }
    }

    public Iterable<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getCard(String card_number) {
        return cardRepository.findById(card_number).get();
    }
}
