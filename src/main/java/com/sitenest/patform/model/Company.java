package com.sitenest.patform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "companies")
public class Company extends GlobalRecord{

    private String companyId;
    private String companyName;
    private String legalName;
    //business & compilance
    private String gstNumber;
    private String panNumber;
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
    private String supportMail;
    private String supportPhoneNumber;
    //Finance & banking details
    private String bankAccountNumber;
    private String bankName;
    private String ifscCode;
    private String creditLimitForDistributors;

}
//company will be inherited by manufacturer company and distributor company
