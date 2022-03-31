package com.example.sd_assignment2.business.service;

import com.example.sd_assignment2.business.model.Customer;
import com.example.sd_assignment2.business.model.User;
import com.example.sd_assignment2.persistance.CustomerRepository;
import com.example.sd_assignment2.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer logInCustomer(User user){
        return customerRepository.findByUser(user);
    }
}
