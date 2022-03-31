package com.example.sd_assignment2.persistance;

import com.example.sd_assignment2.business.model.Customer;
import com.example.sd_assignment2.business.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByUser(User user);

}
