package com.sitenest.patform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "documents")
public class Document extends GlobalRecord{
    private String documentName;
    private String documentOriginalName;
    private String documentType;
    private String documentURL;
}
