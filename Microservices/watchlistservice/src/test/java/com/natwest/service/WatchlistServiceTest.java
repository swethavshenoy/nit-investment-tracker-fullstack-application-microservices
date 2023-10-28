package com.natwest.service;

import com.natwest.model.Watchlist;
import com.natwest.repository.WatchlistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class WatchlistServiceTest {

    @InjectMocks
    private WatchlistService watchlistService;

    @Mock
    private WatchlistRepository watchlistRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllWatchlist() {
        List<Watchlist> mockWatchlist = new ArrayList<>();
        when(watchlistRepository.findAll()).thenReturn(mockWatchlist);

        List<Watchlist> result = watchlistService.getAllWatchlist();

        assertEquals(mockWatchlist, result);
    }

    @Test
    void testSaveAWatchlist() {
        Watchlist watchlist = new Watchlist();
        when(watchlistRepository.save(watchlist)).thenReturn(watchlist);

        Watchlist result = watchlistService.saveAWatchlist(watchlist);

        assertEquals(watchlist, result);
    }
}
