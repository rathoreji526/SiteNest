package com.sitenest.patform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "companies")
public class Company extends GlobalRecord{

    @Column(unique = true )
    private String companyId;
    @Column(unique = true )
    private String companyName;
    @Column(unique = true )
    private String legalName;
    //business & compilance
    @Column(unique = true )
    private String gstNumber;
    @Column(unique = true )
    private String panNumber;
    @Column(unique = true )
    private String cinNumber;
    //address
    private String companyType;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;
    private String country;
    private int pincode;
    private String geoLatitude;
    private String geoLongitude;
    private boolean isKycCompleted;
    //contact info
    @Column(unique = true )
    private String supportMail;
    @Column(unique = true)
    private String supportPhoneNumber;
    //Finance & banking details
    @Column(unique = true)
    private String bankAccountNumber;
    private String bankName;
    private String ifscCode;
    private String creditLimitForDistributors;

    @OneToMany
    List<Document> documentList;
    private String status;

}
//company will be inherited by manufacturer company and distributor company
