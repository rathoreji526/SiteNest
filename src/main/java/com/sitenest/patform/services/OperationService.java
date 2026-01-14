package com.sitenest.patform.services;

import com.sitenest.patform.model.Operation;
import com.sitenest.patform.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    @Autowired
    OperationRepository operationRepository;
    public List<Operation> fetchAllOperations(){
        return  operationRepository.findAll();
    }
}
