package com.example.sd_assignment2.presentation;

import com.example.sd_assignment2.business.DTOs.*;
import com.example.sd_assignment2.business.model.Admin;
import com.example.sd_assignment2.business.model.Food;
import com.example.sd_assignment2.business.model.Restaurant;
import com.example.sd_assignment2.business.service.FoodService;
import com.example.sd_assignment2.business.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/admin/{id}/restaurants/{id_restaurant}")
    public ResponseEntity getFoodsByRestaurantId(@PathVariable Long id_restaurant){

        ArrayList<Food> foodsList = foodService.getFoodsByRestaurantId(id_restaurant);
        ArrayList<FoodDTOWithId> foods = new ArrayList<>();
        for(int i=0;i<foodsList.size();i++){
            foods.add(new FoodDTOWithId(foodsList.get(i)));
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(foods);
    }

    @PostMapping( "/admin/{id}/restaurants")
    public ResponseEntity addFood(@RequestBody FoodDTO foodDTO){

        if(foodDTO.getName()==null || foodDTO.getName().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("name required"));
        if(foodDTO.getDescription()==null || foodDTO.getDescription().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("description required"));
        if(foodDTO.getCategory()==null || foodDTO.getCategory().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("category required"));
        if(foodDTO.getPrice()==null || foodDTO.getPrice().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("price required"));

        Float price;
        try{
            price = Float.parseFloat(foodDTO.getPrice());
            if(price<=0)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ResponseDTO("price incorrect"));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("price incorrect"));
        }


        try{
            Food newFood = addFood(foodDTO.getName(),foodDTO.getDescription(),price,foodDTO.getCategory(), foodDTO.getRestaurant_id());
            if(newFood!=null){

                return ResponseEntity.status(HttpStatus.OK)
                        .body(new FoodDTOWithId(newFood));
            }

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(e.getMessage()));
        }


        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO("registered"));
    }

    public Food addFood(String name, String description, Float price, String category, long restaurant_id) throws Exception{
        Restaurant restaurant = restaurantService.findById(restaurant_id);
        if(restaurant==null){
            throw new Exception("restaurant id problem");
        }
        Food newFood = new Food(name,description,price,category,restaurant);
        foodService.addFood(newFood);
        return newFood;
    }
}
