package com.sitenest.patform.services;

import com.sitenest.patform.model.Company;
import com.sitenest.patform.model.CompanyEmployee;
import com.sitenest.patform.model.Role;
import com.sitenest.patform.repositories.CompanyEmployeeRepository;
import com.sitenest.patform.utilities.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompanyEmployeeService {
    @Autowired
    CompanyEmployeeRepository companyEmployeeRepository;

    public CompanyEmployee save(CompanyEmployee companyEmployee){
        return companyEmployeeRepository.save(companyEmployee);
    }

    public CompanyEmployee createFirstAdminAccount(Company company){
        CompanyEmployee companyEmployee = new CompanyEmployee();
        companyEmployee.setCompany(company);
        companyEmployee.setCompanyEmployeeId(CommonUtility.generateIdForEntity("COMP-EMP"));
        companyEmployee.setEmail(company.getSupportMail());
        companyEmployee.setPassword(CommonUtility.generateRandomPassword(15));
        companyEmployee.setCreatedAt(LocalDateTime.now());
        companyEmployee.setUpdatedAt(LocalDateTime.now());
        companyEmployee.setAddressLine1(company.getAddressLine1());
        companyEmployee.setAddressLine2(company.getAddressLine2());
        companyEmployee.setAddressLine3(company.getAddressLine3());
        companyEmployee.setFullName(company.getCompanyName()+" "+"Admin");
        companyEmployee.setPhoneNumber(company.getSupportPhoneNumber());
        companyEmployee.setPincode(company.getPincode());
        Role role = new Role();
        companyEmployee.setRoles(List.of(role));
        return this.save(companyEmployee);

    }
}
