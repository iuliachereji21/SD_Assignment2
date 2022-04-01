package com.example.sd_assignment2.persistance;

import com.example.sd_assignment2.business.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
