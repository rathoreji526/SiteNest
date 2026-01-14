package com.sitenest.patform.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sitenest.patform.dto.CompanyOnBoardingRequestDto;
import com.sitenest.patform.services.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/c2d/api/v1/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/start-onboarding")
    public ResponseEntity startOnBoarding(
            @RequestPart(value = "gstCertificate") MultipartFile gstCertificate,
            @RequestPart(value = "panCard") MultipartFile panCard,
            @RequestPart(value = "companyRegistrationDocument") MultipartFile companyRegistrationDoc,
            @RequestPart(value = "companyLogo") MultipartFile companyLogo,
            @RequestPart(value = "companyInfo") String companyDetails
            ) throws JsonProcessingException {
        CompanyOnBoardingRequestDto companyOnBoardingRequestDto = objectMapper.readValue(companyDetails , CompanyOnBoardingRequestDto.class);

        try{
            companyService.startOnBoarding(gstCertificate,panCard , companyRegistrationDoc , companyLogo , companyOnBoardingRequestDto);
            HashMap<String,String> resp = new HashMap<>();
            resp.put("mesage" , "Company Details uploaded successfully");
            return new ResponseEntity(resp , HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            HashMap<String , String> resp = new HashMap<>();
            resp.put("message" , e.getMessage());
            return new ResponseEntity<>(resp , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
