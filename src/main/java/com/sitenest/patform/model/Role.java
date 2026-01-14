package com.sitenest.patform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role extends GlobalRecord{
    private String roleId;
    private String roleName;
    @ManyToMany
    private List<Operation> operations;
}
