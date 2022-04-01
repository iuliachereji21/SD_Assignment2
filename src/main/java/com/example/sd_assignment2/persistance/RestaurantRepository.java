package com.example.sd_assignment2.persistance;

import com.example.sd_assignment2.business.model.Admin;
import com.example.sd_assignment2.business.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    ArrayList<Restaurant> getAllByAdmin_Id(Long id);

    Restaurant findById(long id);
}
