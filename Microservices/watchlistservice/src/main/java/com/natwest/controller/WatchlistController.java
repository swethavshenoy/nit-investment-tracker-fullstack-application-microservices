package com.natwest.controller;

import com.natwest.model.Watchlist;
import com.natwest.service.WatchlistService;
import org.hibernate.boot.jaxb.Origin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.natwest.repository.WatchlistRepository;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("watchlist")
@CrossOrigin(origins = "*")
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

}
