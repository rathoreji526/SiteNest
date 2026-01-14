package com.sitenest.patform.controllers;

import com.sitenest.patform.model.Operation;
import com.sitenest.patform.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class demoAPI {
    @Autowired
    OperationRepository operationRepository;

    @GetMapping("/result")
    public String check(){
        if(operationRepository.existsByOperationName("demo")){
            return "found";
        }else return "not found";
    }
}
