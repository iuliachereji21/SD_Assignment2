package com.example.sd_assignment2.business.service;

import com.example.sd_assignment2.business.model.User;
import com.example.sd_assignment2.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }
}
