package com.sitenest.patform.repositories;

import com.sitenest.patform.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentRepository extends JpaRepository<Document , UUID> {
}
