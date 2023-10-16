package com.natwest.service;

import com.natwest.model.Trending;
import com.natwest.repository.TrendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrendingService {
    @Autowired
    private TrendingRepository trendingRepository;

    public List<Trending> getAllTrending(){
        return trendingRepository.findAll();
    }

    public Trending saveATrending (Trending trending){
        return trendingRepository.save(trending);
    }
}
