package com.sitenest.patform.repositories;

import com.sitenest.patform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User , UUID> {
    public User findByEmail(String email);
}
