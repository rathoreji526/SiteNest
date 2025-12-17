package com.sitenest.patform.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "global_records")
public class GlobalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sysId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private User createdBy;
    private User updatedBy;
}
//general records will be interited by admins who will creatd or update anything
