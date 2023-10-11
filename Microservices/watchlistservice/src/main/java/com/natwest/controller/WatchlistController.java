package com.natwest.controller;

import com.natwest.model.Watchlist;
import com.natwest.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.natwest.repository.WatchlistRepository;
import java.util.List;

@RestController
@RequestMapping("watchlist")
@CrossOrigin
public class WatchlistController {
    @Autowired
    private WatchlistService watchlistService;
    @Autowired
    WatchlistRepository watchlistrepository;
    @GetMapping("/")
    public List<Watchlist> getAllTransactions() {

       return watchlistrepository.findAll();
    }
    @PostMapping("/add")
    public ResponseEntity<?> addToWatchlist(@RequestBody Watchlist watchlist) {
        try {
            Watchlist updatedWatchlist = watchlistService.addToWatchlist(watchlist);
            return ResponseEntity.ok(updatedWatchlist);
        } catch (Exception e) {
            // Handle the exception, you can log it or return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

}
