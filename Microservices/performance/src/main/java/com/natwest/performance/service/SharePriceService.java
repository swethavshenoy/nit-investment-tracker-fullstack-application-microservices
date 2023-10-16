package com.natwest.performance.service;

import com.natwest.performance.domain.SharePrice;
import com.natwest.performance.repository.SharePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SharePriceService {
    @Autowired
    private SharePriceRepository sharepricerepository;

    public List<SharePrice> getAllSharePrice(){
        return sharepricerepository.findAll();
    }

    public SharePrice saveAUser(SharePrice sharePrice) {
        return sharePrice;
    }
}