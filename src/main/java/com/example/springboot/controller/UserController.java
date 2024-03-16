package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
}
