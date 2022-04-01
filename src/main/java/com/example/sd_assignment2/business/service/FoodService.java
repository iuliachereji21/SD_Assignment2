package com.example.sd_assignment2.business.service;

import com.example.sd_assignment2.business.model.Food;
import com.example.sd_assignment2.business.model.Restaurant;
import com.example.sd_assignment2.persistance.FoodRepository;
import com.example.sd_assignment2.persistance.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public void addFood(Food food){
        foodRepository.save(food);
    }

    public ArrayList<Food> getFoodsByRestaurantId(Long id){
        return foodRepository.getAllByRestaurant_Id(id);
    }
}
