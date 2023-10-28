package com.natwest.performance.service;

import com.natwest.performance.domain.SharePrice;
import com.natwest.performance.repository.SharePriceRepository;
import com.natwest.performance.service.SharePriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class SharePriceServiceTest {

    @InjectMocks
    private SharePriceService sharePriceService;

    @Mock
    private SharePriceRepository sharePriceRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllSharePrice() {
        // Create mock data
        List<SharePrice> mockSharePrices = new ArrayList<>();
        SharePrice sharePrice1 = new SharePrice();
        sharePrice1.setId("1");
        sharePrice1.setName("Test SharePrice 1");
        sharePrice1.setMonth("January");
        sharePrice1.setAmount(new BigDecimal("100.0"));

        SharePrice sharePrice2 = new SharePrice();
        sharePrice2.setId("2");
        sharePrice2.setName("Test SharePrice 2");
        sharePrice2.setMonth("February");
        sharePrice2.setAmount(new BigDecimal("200.0"));

        mockSharePrices.add(sharePrice1);
        mockSharePrices.add(sharePrice2);

        when(sharePriceRepository.findAll()).thenReturn(mockSharePrices);

        // Call the service method
        List<SharePrice> result = sharePriceService.getAllSharePrice();

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Test SharePrice 1", result.get(0).getName());
        assertEquals("Test SharePrice 2", result.get(1).getName());
    }

    @Test
    void testSaveAUser() {
        // Create a test SharePrice entity
        SharePrice sharePrice = new SharePrice();
        sharePrice.setId("1");
        sharePrice.setName("Test SharePrice");
        sharePrice.setMonth("March");
        sharePrice.setAmount(new BigDecimal("300.0"));

        // Call the service method
        SharePrice savedSharePrice = sharePriceService.saveAUser(sharePrice);

        // Assertions
        assertNotNull(savedSharePrice);
        assertEquals("Test SharePrice", savedSharePrice.getName());
        assertEquals("March", savedSharePrice.getMonth());
        assertEquals(new BigDecimal("300.0"), savedSharePrice.getAmount());
    }
}
