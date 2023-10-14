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

    public class TransactionService1 {

        private final KafkaTemplate<String, String> kafkaTemplate;

        public TransactionService1(KafkaTemplate<String, String> kafkaTemplate) {
            this.kafkaTemplate = kafkaTemplate;
        }

        public void recordTransaction(Transaction transaction) {
            // Your transaction recording logic here
            // This can include saving the transaction to your database

            // For demonstration purposes, let's assume we're simply printing the transaction details
            System.out.println("Recording Transaction: " + transaction.getId() + ", Amount: " + transaction.getAmount());

            // Publish a transaction event to Kafka
            String transactionEvent = "Transaction ID: " + transaction.getId();
            kafkaTemplate.send("transaction-events", transactionEvent);
        }
    }
    public class EmailService {

        // You can inject an EmailSender or use an email service provider's SDK here
        // For this example, let's assume you have an EmailSender class

        @KafkaListener(topics = "transaction-events", groupId = "email-service-group")
        public void sendEmailNotification(@Payload String transactionEvent) {
            // Process the transaction event and send email notifications
            String recipientEmail = "recipient@example.com"; // Replace with actual recipient email
            String subject = "New Transaction Alert";
            String message = "A new transaction has been recorded: " + transactionEvent;

            // Send the email using your email sending logic, e.g., EmailSender
            EmailSender emailSender = new EmailSender();
            emailSender.sendEmail(recipientEmail, subject, message);
        }
}