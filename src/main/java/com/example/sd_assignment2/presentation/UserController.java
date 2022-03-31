package com.example.sd_assignment2.presentation;

import com.example.sd_assignment2.business.DTOs.LogInDTO;
import com.example.sd_assignment2.business.DTOs.RegisterDTO;
import com.example.sd_assignment2.business.DTOs.ResponseDTO;
import com.example.sd_assignment2.business.model.Admin;
import com.example.sd_assignment2.business.model.Customer;
import com.example.sd_assignment2.business.model.User;
import com.example.sd_assignment2.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
public class UserController {

    private User currentUser;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerController customerController;

    @Autowired AdminController adminController;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        System.out.println("user for id: "+id);
        User newUser = new User("iulia","1234");

        return newUser;
    }

    @PostMapping( "/register")
    public ResponseEntity registerUser(@RequestBody RegisterDTO registerDTO){
        if(registerDTO.getUsername()==null || registerDTO.getUsername().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("username required"));
        if(registerDTO.getPassword()==null || registerDTO.getPassword().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("password required"));
        if(registerDTO.getRepeated_password()==null || registerDTO.getRepeated_password().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("repeated password required"));
        if(!registerDTO.getRepeated_password().equals(registerDTO.getPassword()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("passwords don't match"));

        if(registerDTO.getPhone()!=null){
            String regexPattern = "^\\d{10}$";
            if(!Pattern.compile(regexPattern).matcher(registerDTO.getPhone()).matches())
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ResponseDTO("invalid phone number"));
        }

        try{
            User newUser = addUser(registerDTO.getUsername(), registerDTO.getPassword());
            customerController.addCustomer(registerDTO.getPhone(),newUser);

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(e.getMessage()));
        }


        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO("registered"));
    }

    public User addUser(String userName, String password) throws Exception{
        User newUser = new User(userName, password);
        userService.addUser(newUser);
        currentUser=newUser;
        return newUser;
    }

    @PostMapping( "/login")
    public ResponseEntity logIn(@RequestBody LogInDTO logInDTO){
        if(logInDTO.getUsername()==null || logInDTO.getUsername().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("username required"));
        if(logInDTO.getPassword()==null || logInDTO.getPassword().equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO("password required"));


        try{
            User user = userService.logIn(new User(logInDTO.getUsername(), logInDTO.getPassword()));
            currentUser= user;
            Customer customer = customerController.logInCustomer(user);
            if(customer==null){
                Admin admin = adminController.logInAdmin(user);
                if(admin!=null)
                    System.out.println(admin.getEmail());
            }
            else
                System.out.println(customer.getPhone());

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(e.getMessage()));
        }


        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO("logged in"));
    }


}
