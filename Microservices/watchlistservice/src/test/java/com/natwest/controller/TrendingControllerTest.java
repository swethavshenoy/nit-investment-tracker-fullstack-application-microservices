package com.natwest.controller;

import com.natwest.model.Trending;
import com.natwest.service.TrendingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TrendingControllerTest {

    @InjectMocks
    private TrendingController trendingController;

    @Mock
    private TrendingService trendingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllTrending() {
        List<Trending> mockTrending = new ArrayList<>();
        when(trendingService.getAllTrending()).thenReturn(mockTrending);

        ResponseEntity<List<Trending>> response = trendingController.getAllTrending();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockTrending, response.getBody());
    }

    @Test
    void testSaveATrending() {
        Trending mockTrending = new Trending();
        when(trendingService.saveATrending(any(Trending.class))).thenReturn(mockTrending);

        Trending inputTrending = new Trending();
        ResponseEntity<Trending> response = trendingController.saveAWatchlist(inputTrending);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockTrending, response.getBody());
    }
}
