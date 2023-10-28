package com.natwest.controller;

import com.natwest.model.Watchlist;
import com.natwest.service.WatchlistService;
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

class WatchlistControllerTest {

    @InjectMocks
    private WatchlistController watchlistController;

    @Mock
    private WatchlistService watchlistService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllWatchlist() {
        List<Watchlist> mockWatchlist = new ArrayList<>();
        when(watchlistService.getAllWatchlist()).thenReturn(mockWatchlist);

        ResponseEntity<List<Watchlist>> response = watchlistController.getAllWatchlist();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockWatchlist, response.getBody());
    }

    @Test
    void testSaveAWatchlist() {
        Watchlist mockWatchlist = new Watchlist();
        when(watchlistService.saveAWatchlist(any(Watchlist.class))).thenReturn(mockWatchlist);

        Watchlist inputWatchlist = new Watchlist();
        ResponseEntity<Watchlist> response = watchlistController.saveAWatchlist(inputWatchlist);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockWatchlist, response.getBody());
    }
}
