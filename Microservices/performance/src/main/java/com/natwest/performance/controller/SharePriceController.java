package com.natwest.performance.controller;

import com.natwest.performance.domain.SharePrice;
import com.natwest.performance.domain.Transaction;
import com.natwest.performance.repository.SharePriceRepository;
import com.natwest.performance.service.SharePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/share-prices")
public class SharePriceController {
    @Autowired
    private SharePriceRepository sharepricerepository;

    @Autowired
    RestTemplate rt;

    @Autowired
    SharePriceService sharePriceService;

    @GetMapping("/")
    public List<SharePrice> getAllSharePrice(){
        return sharepricerepository.findAll();
    }

    @GetMapping("/shareprice")
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        String url = "http://localhost:9975/transactions/";
        List<Transaction> output = rt.getForObject(url, List.class);
        return new ResponseEntity<List<Transaction>>(output, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SharePrice> saveAuser(@RequestBody SharePrice sharePrice){
        return new ResponseEntity<SharePrice>(sharePriceService.saveAUser(sharePrice), HttpStatus.CREATED);
    }
}

