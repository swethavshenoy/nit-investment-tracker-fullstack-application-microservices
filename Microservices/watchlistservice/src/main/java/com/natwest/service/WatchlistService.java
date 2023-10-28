package com.natwest.service;

import com.natwest.model.Watchlist;
import com.natwest.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {
    @Autowired
    private WatchlistRepository watchlistRepository;

    public List<Watchlist> getAllWatchlist(){
        return watchlistRepository.findAll();
    }

    public Watchlist saveAWatchlist (Watchlist watchlist){
        return watchlistRepository.save(watchlist);
    }

    public List<Watchlist> saveAllWatchlist (List<Watchlist> watchlists) {
        return watchlistRepository.saveAll(watchlists);
    }
}
