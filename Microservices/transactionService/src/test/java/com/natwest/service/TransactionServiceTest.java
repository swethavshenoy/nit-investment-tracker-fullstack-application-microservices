package com.natwest.service;

import com.natwest.model.Transaction;
import com.natwest.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateTransaction() {
        Transaction mockTransaction = new Transaction(); // Create a mock transaction
        when(transactionRepository.save(any(Transaction.class))).thenReturn(mockTransaction);

        Transaction createdTransaction = transactionService.createTransaction(mockTransaction);

        assertNotNull(createdTransaction);
        assertEquals(mockTransaction, createdTransaction);
    }

    @Test
    void testGetAllTransactions() {
        List<Transaction> mockTransactions = new ArrayList<>();
        when(transactionRepository.findAll()).thenReturn(mockTransactions);

        List<Transaction> transactions = transactionService.getAllTransactions();

        assertNotNull(transactions);
        assertEquals(mockTransactions, transactions);
    }

    @Test
    void testGetTransactionById() {
        String transactionId = "123";
        Transaction mockTransaction = new Transaction(); // Create a mock transaction
        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(mockTransaction));

        Optional<Transaction> transaction = transactionService.getTransactionById(transactionId);

        assertNotNull(transaction);
        assertEquals(mockTransaction, transaction.orElse(null));
    }

    @Test
    void testAddTransaction() {
        Transaction mockTransaction = new Transaction(); // Create a mock transaction
        when(transactionRepository.save(any(Transaction.class))).thenReturn(mockTransaction);

        Transaction addedTransaction = transactionService.addTransaction(mockTransaction);

        assertNotNull(addedTransaction);
        assertEquals(mockTransaction, addedTransaction);
    }
}
