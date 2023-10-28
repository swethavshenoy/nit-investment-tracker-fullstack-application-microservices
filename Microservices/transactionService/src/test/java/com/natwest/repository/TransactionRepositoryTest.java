package com.natwest.repository;

import com.natwest.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@DirtiesContext
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setUp() {
        // Clear the MongoDB collections before each test
        mongoTemplate.getDb().drop();
    }

    @Test
     void testSaveAndFindAllByEmailid() {
        // Create a test transaction
        Transaction transaction = new Transaction();
        transaction.setEmailid("test@example.com");

        // Save the transaction to the database
        transactionRepository.save(transaction);

        // Find transactions by email
        List<Transaction> foundTransactions = transactionRepository.findAllByEmailid("test@example.com");

        // Assertions
        assertNotNull(foundTransactions);
        assertEquals(1, foundTransactions.size());
        assertEquals("test@example.com", foundTransactions.get(0).getEmailid());
    }
}
