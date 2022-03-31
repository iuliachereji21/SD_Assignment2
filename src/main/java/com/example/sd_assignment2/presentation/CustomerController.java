package com.example.sd_assignment2.presentation;

import com.example.sd_assignment2.business.DTOs.RegisterDTO;
import com.example.sd_assignment2.business.DTOs.ResponseDTO;
import com.example.sd_assignment2.business.model.Customer;
import com.example.sd_assignment2.business.model.User;
import com.example.sd_assignment2.business.service.CustomerService;
import com.example.sd_assignment2.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
public class CustomerController {

    private Customer currentCustomer;

    @Autowired
    private CustomerService customerService;


    public Customer logInCustomer(User user){
        Customer  customer = customerService.logInCustomer(user);
        if(customer!=null)
            currentCustomer=customer;
        return customer;
    }

    public Customer addCustomer(String phone, User user){
        Customer newCustomer = new Customer(phone,user);
        customerService.addCustomer(newCustomer);
        currentCustomer=newCustomer;
        return newCustomer;
    }
}
