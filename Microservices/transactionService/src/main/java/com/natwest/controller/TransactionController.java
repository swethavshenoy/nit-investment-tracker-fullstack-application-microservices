package com.natwest.controller;

import com.natwest.model.Transaction;
import com.natwest.repository.TransactionRepository;
import com.natwest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("transactions")
public class TransactionController {

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

    @GetMapping("/by-email/{emailid}")
    public List<Transaction> findTransactionsByEmail(@PathVariable String emailid) {
        return transactionRepository.findAllByEmailid(emailid);
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
