package com.example.sd_assignment2.business.service;

import com.example.sd_assignment2.business.model.User;
import com.example.sd_assignment2.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) throws Exception{
        ArrayList<User> users = new ArrayList<>(userRepository.findByUsername(user.getUsername()));
        if(users.size()!=0){
            throw new Exception("username already exists");
        }
        else{
            userRepository.save(user);
        }

    }

    public User logIn(User user) throws Exception{
        ArrayList<User> users = new ArrayList<>(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()));
        if(users.size()==0){
            throw new Exception("bad credentials");
        }
        else{
            if(!users.get(0).getPassword().equals(user.getPassword()))
                throw new Exception("bad credentials");
            else return users.get(0);
        }

    }
}
