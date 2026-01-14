package com.sitenest.patform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pricing")
public class Pricing extends GlobalRecord{
    private String priceId;
    @ManyToOne
    private Product product;
    private Double basePrice;
    private Double tradePrice;
    private Double purchasePrice;
    private String currency;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private String regionCode;
    private String priceType;
    private String discountType;
    private double discountPercentage;
    private boolean isGstIncluded;
}
