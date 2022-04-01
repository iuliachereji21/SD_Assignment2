package com.example.sd_assignment2.business.service;

import com.example.sd_assignment2.business.model.Admin;
import com.example.sd_assignment2.business.model.User;
import com.example.sd_assignment2.persistance.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin logInAdmin(User user){
        return adminRepository.findByUser(user);
    }

    public Admin findById(long id){
        return adminRepository.findById(id);
    }
}
