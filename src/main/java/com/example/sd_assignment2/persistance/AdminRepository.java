package com.example.sd_assignment2.persistance;

import com.example.sd_assignment2.business.model.Admin;
import com.example.sd_assignment2.business.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByUser(User user);
    Admin findById(long id);
}
