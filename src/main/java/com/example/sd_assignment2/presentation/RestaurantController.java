package com.example.sd_assignment2.presentation;

import com.example.sd_assignment2.business.DTOs.RegisterDTO;
import com.example.sd_assignment2.business.DTOs.ResponseDTO;
import com.example.sd_assignment2.business.DTOs.RestaurantDTO;
import com.example.sd_assignment2.business.DTOs.RestaurantDTOWithId;
import com.example.sd_assignment2.business.model.Admin;
import com.example.sd_assignment2.business.model.Restaurant;
import com.example.sd_assignment2.business.model.User;
import com.example.sd_assignment2.business.service.AdminService;
import com.example.sd_assignment2.business.service.RestaurantService;
import com.example.sd_assignment2.persistance.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private AdminService adminService;

//    @GetMapping("/{id}")
//    public ResponseEntity getUserById(@PathVariable String id){
//        System.out.println("user for id: "+id);
//        User newUser = new User("iulia","1234");
//
//        return newUser;
//    }

    @PostMapping( "/admin")
    public ResponseEntity addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        if(restaurantDTO.getName()==null || restaurantDTO.getName().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("name required"));
        if(restaurantDTO.getLocation()==null || restaurantDTO.getLocation().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("location required"));
        if(restaurantDTO.getAvailable_delivery_zones()==null || restaurantDTO.getAvailable_delivery_zones().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("available delivery zones required"));


        try{
            Restaurant newRestaurant = addRestaurant(restaurantDTO.getName(), restaurantDTO.getLocation(), restaurantDTO.getAvailable_delivery_zones(), restaurantDTO.getAdmin_id());
            if(newRestaurant!=null){
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new RestaurantDTOWithId(newRestaurant));
            }

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(e.getMessage()));
        }


        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO("registered"));
    }

    public Restaurant addRestaurant(String name, String location, String available_delivery_zones, long admin_id) throws Exception{
        Admin admin = adminService.findById(admin_id);
        if(admin==null){
            throw new Exception("admin id problem");
        }
        Restaurant newRestaurant = new Restaurant(name,location,available_delivery_zones,admin);
        restaurantService.addRestaurant(newRestaurant);
        return newRestaurant;
    }
}