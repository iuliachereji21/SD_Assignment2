package com.example.sd_assignment2.persistance;

import com.example.sd_assignment2.business.model.Customer;
import com.example.sd_assignment2.business.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("select c from Customer c where c.user.id = ?1")
    Customer findByUserId(Long user_id);

    //Customer findBy

}
