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
    private Integer id;
    @Column(name = "company_name")
    private String company_name;
    private String month;
    private BigDecimal shareprice;
}

