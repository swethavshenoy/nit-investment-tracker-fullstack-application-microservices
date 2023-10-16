package com.natwest.repository;

import com.natwest.model.Trending;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendingRepository extends MongoRepository<Trending, String> {
}
