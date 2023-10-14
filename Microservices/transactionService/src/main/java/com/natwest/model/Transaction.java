package com.natwest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transactions")
public class Transaction {
    @MongoId
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;
    private String description;
    private String companyName;
    private int quantity;
    private double totalAmount;





}
