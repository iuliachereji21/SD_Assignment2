package com.example.sd_assignment2.presentation;

import com.example.sd_assignment2.business.model.User;
import com.example.sd_assignment2.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        System.out.println("user for id: "+id);
        User newUser = new User(1,"iulia","1234");
        //userService.addUser(newUser);
        return newUser;
    }
}
