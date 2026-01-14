package com.sitenest.patform.repositories;

import com.sitenest.patform.model.CompanyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyEmployeeRepository extends JpaRepository<CompanyEmployee , UUID> {
}
