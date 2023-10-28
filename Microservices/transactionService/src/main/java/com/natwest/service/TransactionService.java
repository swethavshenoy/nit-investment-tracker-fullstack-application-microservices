package com.natwest.service;

import com.natwest.model.Transaction;
import com.natwest.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(String id) {
        return transactionRepository.findById(id);
    }

    public Transaction addTransaction(Transaction transaction) {
        // Assuming your TransactionRepository is a JPA repository, you can save the transaction.
        Transaction savedTransaction = transactionRepository.save(transaction);
        return savedTransaction;
    }

    public List<Transaction> listTransaction(List<Transaction> transactions) {
        // Assuming your TransactionRepository is a JPA repository, you can save the transaction.
        List<Transaction> savedTransaction = transactionRepository.saveAll(transactions);
        return savedTransaction;
    }

}