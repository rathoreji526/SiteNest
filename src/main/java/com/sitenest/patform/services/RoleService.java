package com.sitenest.patform.services;

import com.sitenest.patform.model.Company;
import com.sitenest.patform.model.Role;
import com.sitenest.patform.model.User;
import com.sitenest.patform.repositories.RoleRepository;

import com.sitenest.patform.utilities.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    OperationService operationService;

    public Role createBotRole(){
        Role role = new Role();
        role.setRoleId(CommonUtility.generateIdForEntity("ROLE"));
        role.setRoleName("SupplyNest_Bot");
        role.setOperations(operationService.fetchAllOperations());
        role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        return this.save(role);
    }

    public Role createFirstAdminRoleForCompany(Company company , User botUser){
        Role role = new Role();
        role.setRoleId(CommonUtility.generateIdForEntity("ROLE"));
        role.setRoleName(company.getLegalName() + "_" + "Admin");
        role.setOperations(operationService.fetchAllOperations());
        role.setCreatedBy(botUser);
        role.setUpdatedBy(List.of(botUser));
        role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        return this.save(role);
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }
}
