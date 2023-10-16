package com.natwest.controller;

import com.natwest.model.Transaction;
import com.natwest.repository.TransactionRepository;
import com.natwest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("transactions")
@CrossOrigin
public class    TransactionController {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionService transactionservice;

    @GetMapping("/")
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Transaction> getById(@PathVariable String id) {
        return transactionRepository.findById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction) {
        try {
            Transaction savedTransaction = transactionservice.addTransaction(transaction);
               return ResponseEntity.ok(savedTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
