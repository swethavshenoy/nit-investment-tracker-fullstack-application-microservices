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
@Document(collection = "trending")
public class Trending {

    @MongoId
    private String id;
    private String logo;
    private String name;
    private String shares;
    private String returns;
    private String state;
}
