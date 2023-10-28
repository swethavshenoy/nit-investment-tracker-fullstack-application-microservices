package com.natwest.service;

import com.natwest.model.Trending;
import com.natwest.repository.TrendingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TrendingServiceTest {

    @InjectMocks
    private TrendingService trendingService;

    @Mock
    private TrendingRepository trendingRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllTrending() {
        List<Trending> mockTrending = new ArrayList<>();
        when(trendingRepository.findAll()).thenReturn(mockTrending);

        List<Trending> result = trendingService.getAllTrending();

        assertEquals(mockTrending, result);
    }

    @Test
    void testSaveATrending() {
        Trending trending = new Trending();
        when(trendingRepository.save(trending)).thenReturn(trending);

        Trending result = trendingService.saveATrending(trending);

        assertEquals(trending, result);
    }
}
