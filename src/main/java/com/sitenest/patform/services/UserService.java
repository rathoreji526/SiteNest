package com.sitenest.patform.services;

import com.sitenest.patform.model.Role;
import com.sitenest.patform.model.User;
import com.sitenest.patform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserByEmail(String email){
        if(email!=null){
            return userRepository.findByEmail(email);
        }else return null;
    }

//    public List<Role>
}
