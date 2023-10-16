package com.natwest.repository;

import com.natwest.model.Watchlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepository extends MongoRepository<Watchlist, String> {

}
