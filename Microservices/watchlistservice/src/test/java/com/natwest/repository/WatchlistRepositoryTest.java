package com.natwest.repository;

import com.natwest.model.Watchlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
class WatchlistRepositoryTest {

    @Autowired
    private WatchlistRepository watchlistRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void setUp() {
        // Clear the MongoDB collections before each test
        mongoTemplate.getDb().drop();
    }

    @Test
    void testCrudOperations() {
        // Create a test watchlist
        Watchlist watchlist = new Watchlist();
        watchlist.setName("Test Watchlist");

        // Save the watchlist to the database
        Watchlist savedWatchlist = watchlistRepository.save(watchlist);

        // Find the watchlist by ID
        Watchlist foundWatchlist = watchlistRepository.findById(savedWatchlist.getId()).orElse(null);

        // Update the watchlist
        foundWatchlist.setName("Updated Watchlist");
        watchlistRepository.save(foundWatchlist);

        // Delete the watchlist
        watchlistRepository.deleteById(foundWatchlist.getId());

        // Verify the watchlist is deleted
        Watchlist deletedWatchlist = watchlistRepository.findById(foundWatchlist.getId()).orElse(null);

        // Assertions
        assertNotNull(savedWatchlist);
        assertNotNull(foundWatchlist);
        assertEquals(null, deletedWatchlist);
        assertEquals("Test Watchlist", savedWatchlist.getName());
        assertEquals("Updated Watchlist", foundWatchlist.getName());
        assertEquals(null, deletedWatchlist);
    }
}
