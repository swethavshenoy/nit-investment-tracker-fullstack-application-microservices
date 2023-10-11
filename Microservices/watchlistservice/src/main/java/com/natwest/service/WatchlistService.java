package com.natwest.service;

import com.natwest.model.Watchlist;
import com.natwest.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WatchlistService {
    @Autowired
    private WatchlistRepository watchlistRepository;

    public Watchlist addToWatchlist(String investmentName, String assetType, BigDecimal currentPrice, Long volume, String industry, BigDecimal gainLoss) {
        Watchlist watchlistItem = new Watchlist();
        watchlistItem.setInvestmentName(investmentName);
        watchlistItem.setAssetType(assetType);
        watchlistItem.setCurrentPrice(currentPrice);
        watchlistItem.setVolume(volume);
        watchlistItem.setIndustry(industry);
        watchlistItem.setGainLoss(gainLoss);

        return watchlistRepository.save(watchlistItem);
    }
    public List<Watchlist> getAllTransactions() {
        return watchlistRepository.findAll();
    }

    public Watchlist addToWatchlist(Watchlist watchlist) {
        // You can add logic here to validate the input or perform any other operations.
        // For example, you might want to set the user ID or generate an ID for the watchlist item.

        // Save the watchlist item to the repository
        return watchlistRepository.save(watchlist);
    }
    }
