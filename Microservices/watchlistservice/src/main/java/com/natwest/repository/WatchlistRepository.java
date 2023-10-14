package com.natwest.repository;

import com.natwest.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WatchlistRepository extends MongoRepository<Watchlist, String> {

}
