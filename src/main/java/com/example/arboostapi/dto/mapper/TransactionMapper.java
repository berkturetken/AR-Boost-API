package com.example.arboostapi.dto.mapper;

import com.example.arboostapi.dto.model.TransactionDTO;
import com.example.arboostapi.model.Transaction;

public class TransactionMapper {
    public static TransactionDTO toTransactionDTO(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setCard_number(transaction.getCard().getCard_number());
        transactionDTO.setSector(transaction.getSector());
        transactionDTO.setStore(transaction.getStore());
        transactionDTO.setTotal_amount(transaction.getTotal_amount());
        transactionDTO.setDate(transaction.getDate());
        transactionDTO.setWorld_point(transaction.getWorld_point());

        return transactionDTO;
    }
}
