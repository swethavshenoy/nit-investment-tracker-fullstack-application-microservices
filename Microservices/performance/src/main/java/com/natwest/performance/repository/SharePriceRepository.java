package com.natwest.performance.repository;

import com.natwest.performance.domain.SharePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharePriceRepository extends JpaRepository<SharePrice, String> {
}
