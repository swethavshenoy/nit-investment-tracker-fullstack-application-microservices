package com.natwest.performance.controller;

import com.natwest.performance.domain.SharePrice;
import com.natwest.performance.repository.SharePriceRepository;
import com.natwest.performance.service.SharePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/share-prices")
public class SharePriceController {
    @Autowired
    private SharePriceRepository sharepricerepository;

    @GetMapping("/")
    public List<SharePrice> getAllSharePrice(){
        return sharepricerepository.findAll();
    }
}

