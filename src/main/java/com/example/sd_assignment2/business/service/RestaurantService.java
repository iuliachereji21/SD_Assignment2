package com.example.sd_assignment2.business.service;

import com.example.sd_assignment2.business.model.Restaurant;
import com.example.sd_assignment2.persistance.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }
}
