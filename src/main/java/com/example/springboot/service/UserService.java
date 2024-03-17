package com.example.springboot.service;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUser();

    UserDto getUserById(Long id);

    UserDto updateUser(UserDto userDto);

    void deleteUser (Long userId);

}
