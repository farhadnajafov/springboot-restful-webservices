package com.example.springboot.controller;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;
import com.example.springboot.exception.ErrorDetails;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUserDto = userService.createUser(userDto);

        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }


    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);


    }

    @GetMapping("getUserById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        UserDto getUserById = userService.getUserById(id);
        return new ResponseEntity<>(getUserById, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody UserDto userDto) {
        userDto.setId(userId);
        UserDto updateUser = userService.updateUser(userDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Successfully Deleted", HttpStatus.OK);
    }


//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }

}
