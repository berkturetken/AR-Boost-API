package com.example.arboostapi.service;

import com.example.arboostapi.dto.mapper.TransactionMapper;
import com.example.arboostapi.dto.model.TransactionDTO;
import com.example.arboostapi.model.Card;
import com.example.arboostapi.model.Transaction;
import com.example.arboostapi.repository.CardRepository;
import com.example.arboostapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;

    public String addTransaction(String sector, String store, Float total_amount, Float world_point) {
        Transaction transaction = new Transaction();

        String card_number = "4943141334422544";
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


    public Iterable<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }


    public List<TransactionDTO> getCardTransaction(String card_number) throws Exception {
        List<TransactionDTO> results = new ArrayList<>();
        Iterable<Transaction> allTransactions = transactionRepository.findAll();
        for (Transaction transaction : allTransactions) {
            if (transaction.getCard().getCard_number().equals(card_number)) {
                TransactionDTO dto = TransactionMapper.toTransactionDTO(transaction);
                results.add(dto);
            }
        }
        if (results.isEmpty()) {
            throw new Exception("Bu karta ait hesap hareketi bulunamadı.");
        }
        else {
            return results;
        }
    }
}
