package com.natwest.performance.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Table(name="performance")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SharePrice {

    @Id
    private String id;
    @Column(name = "name")
    private String name;
    private String month;
    private BigDecimal amount;

}

