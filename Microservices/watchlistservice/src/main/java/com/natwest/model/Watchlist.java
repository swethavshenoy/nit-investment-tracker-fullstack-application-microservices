package com.natwest.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.math.BigDecimal;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "watchlist_items")
public class Watchlist {
        @MongoId
        private String id;
        private String investmentName;
        private String assetType;
        private BigDecimal currentPrice;
        private Long volume;
        private String industry;
        private Double gainLoss;
        private String state;
}
