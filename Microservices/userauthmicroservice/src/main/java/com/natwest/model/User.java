package com.natwest.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "userdetails")
public class User {
    @MongoId
    private String _id;
    private String firstname;
    private String lastname;
    private Date dob;
    private String address;
    private String emailaddress;
    private String password;
    private String usertype;

    // Getters and setters
}
