package com.example.sd_assignment2.presentation;

import com.example.sd_assignment2.business.model.Admin;
import com.example.sd_assignment2.business.model.Customer;
import com.example.sd_assignment2.business.model.User;
import com.example.sd_assignment2.business.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    private Admin currentAdmin;

    @Autowired
    private AdminService adminService;

    public Admin logInAdmin(User user){
        Admin admin = adminService.logInAdmin(user);
        if(admin!=null)
            currentAdmin=admin;
        return admin;
    }
}
