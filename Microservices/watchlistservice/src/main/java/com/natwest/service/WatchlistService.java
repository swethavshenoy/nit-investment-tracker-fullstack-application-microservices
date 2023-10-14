package com.natwest.service;

import com.natwest.model.Watchlist;
import com.natwest.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WatchlistService {
    @Autowired
    private WatchlistRepository watchlistRepository;

    public Watchlist addToWatchlist(String investmentName, String assetType, BigDecimal currentPrice, Long volume, String industry, Double gainLoss, String state) {
        Watchlist watchlistItem = new Watchlist();
        watchlistItem.setInvestmentName(investmentName);
        watchlistItem.setAssetType(assetType);
        watchlistItem.setCurrentPrice(currentPrice);
        watchlistItem.setVolume(volume);
        watchlistItem.setIndustry(industry);
        watchlistItem.setGainLoss(gainLoss);
        watchlistItem.setState(state);

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
    public Map<String, String> getTrendingStocks() {
        // Implement logic to retrieve trending stocks with grow/fall state
        Map<String, String> trendingStocks = new HashMap<>();

        // Example: Assume you have a list of stocks with their recent price changes
        Map<String, Double> stockPriceChanges = new HashMap<>();
        stockPriceChanges.put("AAPL", 2.5);  // Example: Apple stock increased by 2.5%
        stockPriceChanges.put("GOOGL", 3.2); // Example: Google stock increased by 3.2%
        stockPriceChanges.put("TSLA", -1.8); // Example: Tesla stock decreased by 1.8%
        // ...

        // Define a threshold for identifying trending stocks
        double threshold = 2.0; // Stocks with a price change of more than 2% are considered trending

        for (Map.Entry<String, Double> entry : stockPriceChanges.entrySet()) {
            String stockSymbol = entry.getKey();
            double priceChange = entry.getValue();
            String state;

            if (priceChange > threshold) {
                state = "Grow";
            } else if (priceChange < -threshold) {
                state = "Fall";
            } else {
                state = "Stable";
            }

            trendingStocks.put(stockSymbol, state);
        }

        return trendingStocks;
    }

}
