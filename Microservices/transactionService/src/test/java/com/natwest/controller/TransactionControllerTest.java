package com.natwest.controller;

import com.natwest.model.Transaction;
import com.natwest.repository.TransactionRepository;
import com.natwest.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TransactionControllerTest {

    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionService transactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllTransactions() {
        List<Transaction> mockTransactions = new ArrayList<>();
        when(transactionRepository.findAll()).thenReturn(mockTransactions);

        List<Transaction> transactions = transactionController.getAllTransactions();

        assertNotNull(transactions);
        assertEquals(mockTransactions, transactions);
    }

    @Test
    void testGetTransactionById() {
        String transactionId = "123";
        Transaction mockTransaction = new Transaction(); // Create a mock transaction
        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(mockTransaction));

        Optional<Transaction> transaction = transactionController.getById(transactionId);

        assertNotNull(transaction);
        assertEquals(mockTransaction, transaction.orElse(null));
    }

    @Test
    void testFindTransactionsByEmail() {
        String emailId = "test@example.com";
        List<Transaction> mockTransactions = new ArrayList<>();
        when(transactionRepository.findAllByEmailid(emailId)).thenReturn(mockTransactions);

        List<Transaction> transactions = transactionController.findTransactionsByEmail(emailId);

        assertNotNull(transactions);
        assertEquals(mockTransactions, transactions);
    }


    @Test
    void testAddTransactionError() {
        Transaction mockTransaction = new Transaction(); // Create a mock transaction
        when(transactionService.addTransaction(any(Transaction.class))).thenThrow(new RuntimeException("Test error"));

        ResponseEntity<?> response = transactionController.addTransaction(mockTransaction);

        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An error occurred: Test error", response.getBody());
    }
}
