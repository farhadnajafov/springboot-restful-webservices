package com.example.springboot.service.impl;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail());

        User savedUser = userRepository.save(user);

        UserDto savedUserDto = new UserDto(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );

        return savedUserDto;
    }

    @Override

    public List<User> getAllUser() {
        return userRepository.findAll();

    }
    public User getUserById(Long id) {
        Optional<User> optionalUser =userRepository.findById(id);

        return optionalUser.get();


    }

    @Override
    public User updateUser(User user) {

        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updateUser = userRepository.save(existingUser);

        return updateUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }
}
