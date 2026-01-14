package com.sitenest.patform.services;

import com.sitenest.patform.dto.CompanyOnBoardingRequestDto;
import com.sitenest.patform.model.Company;
import com.sitenest.patform.model.CompanyEmployee;
import com.sitenest.patform.repositories.CompanyRepository;
import com.sitenest.patform.utilities.MappingUtility;
import io.imagekit.sdk.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CompanyService {
    @Autowired
    DocumentService documentService;
    @Autowired
    MappingUtility mappingUtility;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CompanyEmployeeService companyEmployeeService;

    public void startOnBoarding(
            MultipartFile gstCertificate,
            MultipartFile panCard,
            MultipartFile companyRegistrationDoc,
            MultipartFile companyLogo,
            CompanyOnBoardingRequestDto companyDetails
    ) throws ForbiddenException, TooManyRequestsException, InternalServerException, UnauthorizedException, BadRequestException, UnknownException, IOException {
        Company company = mappingUtility.mapCompanyDetailsToCompany(companyDetails);
        company = this.save(company);
        CompanyEmployee admin = companyEmployeeService.createFirstAdminAccount(company);

        String folderName = "company/"+company.getCompanyId();

        documentService.uploadDocument(gstCertificate , "gstcertificate", "gst-certificate" , folderName);
        documentService.uploadDocument(panCard , "pancard" , "pan-card" , folderName);
        documentService.uploadDocument(companyRegistrationDoc , "companyregistrationdoc" , "company-registration-doc" , folderName);
        documentService.uploadDocument(companyLogo , "companylogo" , "company-logo" , folderName);
        //mail the company
    }

    public Company save(Company company){
        return companyRepository.save(company);
    }
}
