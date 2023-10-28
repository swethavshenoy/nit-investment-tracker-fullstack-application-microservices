package com.natwest.performance.controller;

import com.natwest.performance.domain.SharePrice;
import com.natwest.performance.domain.Transaction;
import com.natwest.performance.repository.SharePriceRepository;
import com.natwest.performance.service.SharePriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SharePriceControllerTest {

    @InjectMocks
    private SharePriceController sharePriceController;

    @Mock
    private SharePriceRepository sharePriceRepository;

    @Mock
    private SharePriceService sharePriceService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllSharePrice() {
        List<SharePrice> mockSharePrices = new ArrayList<>();
        when(sharePriceRepository.findAll()).thenReturn(mockSharePrices);

        List<SharePrice> response = sharePriceController.getAllSharePrice();

        assertEquals(mockSharePrices, response);
    }

    @Test
    void testGetAllTransactions() {
        String transactionUrl = "http://localhost:9975/transactions/";
        List<Transaction> mockTransactions = new ArrayList<>(); // Assuming you have a Transaction class

        when(restTemplate.getForObject(transactionUrl, List.class)).thenReturn(mockTransactions);

        ResponseEntity<List<Transaction>> response = sharePriceController.getAllTransactions();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockTransactions, response.getBody());
    }

    @Test
    void testSaveAuser() {
        SharePrice mockSharePrice = new SharePrice();
        when(sharePriceService.saveAUser(mockSharePrice)).thenReturn(mockSharePrice);

        ResponseEntity<SharePrice> response = sharePriceController.saveAuser(mockSharePrice);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockSharePrice, response.getBody());
    }
}
