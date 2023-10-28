package com.natwest.repository;

import com.natwest.model.Trending;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
public class TrendingRepositoryTest {

    @Autowired
    private TrendingRepository trendingRepository;

    @Test
    public void testSaveAndFindById() {
        // Create a test Trending object
        Trending trending = new Trending();
        trending.setName("Test Trending");

        // Save the Trending object to the repository
        Trending savedTrending = trendingRepository.save(trending);

        // Find the Trending object by its ID
        Optional<Trending> foundTrending = trendingRepository.findById(savedTrending.getId());

        // Assertions
        assertTrue(foundTrending.isPresent()); // Ensure it's found
        assertEquals("Test Trending", foundTrending.get().getName()); // Verify the name
    }

    @Test
    public void testUpdate() {
        // Create a test Trending object
        Trending trending = new Trending();
        trending.setName("Test Trending");

        // Save the Trending object to the repository
        Trending savedTrending = trendingRepository.save(trending);

        // Modify the name
        savedTrending.setName("Updated Trending");
        trendingRepository.save(savedTrending);

        // Find the Trending object by its ID
        Optional<Trending> updatedTrending = trendingRepository.findById(savedTrending.getId());

        // Assertions
        assertTrue(updatedTrending.isPresent());
        assertEquals("Updated Trending", updatedTrending.get().getName());
    }

    @Test
    public void testDelete() {
        // Create a test Trending object
        Trending trending = new Trending();
        trending.setName("Test Trending");

        // Save the Trending object to the repository
        Trending savedTrending = trendingRepository.save(trending);

        // Delete the Trending object
        trendingRepository.deleteById(savedTrending.getId());

        // Attempt to find the deleted Trending object
        Optional<Trending> deletedTrending = trendingRepository.findById(savedTrending.getId());

        // Assertions
        assertTrue(deletedTrending.isEmpty()); // Ensure it's not found
    }
}
