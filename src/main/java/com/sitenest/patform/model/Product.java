package com.sitenest.patform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product extends GlobalRecord{

    private String productId;
    @ManyToOne
    private Company manufacturerCompany;
    @Column(unique = true)
    private String skuCode;
    private String brandName;
    private String category;
    private String status;
    private String packType;
    private String packSize;
    private String unitsPerCase;
    private String uom;
    private String weightPerUnit;
    private String shelfLifeInDays;
    private String hsnCode;
    private Double taxRate;
    private boolean isReturnable;
    private String description;

    @OneToMany
    private List<Document> productImages;


}
