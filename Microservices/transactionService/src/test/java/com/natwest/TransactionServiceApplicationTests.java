package com.natwest;

import com.natwest.model.Transaction;
import com.natwest.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private TransactionRepository transactionRepository;

	@Test
	void testGetAllTransactions() {
		ResponseEntity<Transaction[]> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/transactions/", Transaction[].class);
		Transaction[] transactions = responseEntity.getBody();
		assertNotNull(transactions);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}
	@Test
	void testAddTransaction() {
		Transaction transaction = new Transaction(/* Initialize your test transaction here */);
		ResponseEntity<Transaction> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/transactions/add", transaction, Transaction.class);
		assertNotNull(responseEntity.getBody());
		assertEquals(200, responseEntity.getStatusCodeValue());
	}
}
