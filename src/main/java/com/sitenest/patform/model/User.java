package com.sitenest.patform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sysId;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private int pincode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
//user model/entiry will be inherited by every class and user will be everyone admin also
