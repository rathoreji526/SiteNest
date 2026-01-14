package com.sitenest.patform.repositories;

import com.sitenest.patform.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperationRepository extends JpaRepository<Operation , UUID> {
    public Operation findByOperationName(String name);
    public boolean existsByOperationName(String name);
}
