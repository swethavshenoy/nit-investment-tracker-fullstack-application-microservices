package com.natwest.controller;

import com.natwest.model.Watchlist;
import com.natwest.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("watchlist")
public class WatchlistController {
    @Autowired
    private WatchlistService watchlistService;
    @GetMapping("/")
    public ResponseEntity<List<Watchlist>> getAllWatchlist(){
        return new ResponseEntity<List<Watchlist>>(watchlistService.getAllWatchlist(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Watchlist> saveAWatchlist(@RequestBody Watchlist watchlist){
        return new ResponseEntity<Watchlist>(watchlistService.saveAWatchlist(watchlist), HttpStatus.CREATED);
    }

    @PostMapping("/savelist")
    public ResponseEntity<List<Watchlist>> saveAllWatchlist(@RequestBody List<Watchlist> watchlists){
        return new ResponseEntity<List<Watchlist>>(watchlistService.saveAllWatchlist(watchlists), HttpStatus.CREATED);
    }
}
