package com.natwest.controller;

import com.natwest.model.Trending;
import com.natwest.service.TrendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@RestController
@RequestMapping("trending")
@CrossOrigin(origins = "http://localhost:3000")
public class TrendingController {

    @Autowired
    private TrendingService trendingService;
    @GetMapping("/")
    public ResponseEntity<List<Trending>> getAllTrending(){
        return new ResponseEntity<List<Trending>>(trendingService.getAllTrending(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Trending> saveAWatchlist(@RequestBody Trending trending){
        return new ResponseEntity<Trending>(trendingService.saveATrending(trending), HttpStatus.CREATED);
    }

}
