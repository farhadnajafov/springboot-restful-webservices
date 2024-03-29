package com.example.springboot.service.impl;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.AutoUserMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {


//        User user = UserMapper.mapToUser(userDto);
//        User user = modelMapper.map(userDto,User.class);
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);

        User savedUser = userRepository.save(user);

//        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
//        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
            UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override

    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
//        return users
//                .stream()
//                .map(UserMapper:: mapToUserDto)
//                .collect(Collectors.toList());

//        return users
//                .stream()
//                .map((user) -> modelMapper.map(user,UserDto.class))
//                .collect(Collectors.toList());

        return users
                .stream()
                .map((user)->AutoUserMapper.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());
    }
    public UserDto getUserById(Long id) {
        Optional<User> optionalUser =userRepository.findById(id);

        User user = optionalUser.get();

//        return UserMapper.mapToUserDto(user);
//        return modelMapper.map(user,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);


    }

    @Override
    public UserDto updateUser(UserDto user) {

        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updateUser = userRepository.save(existingUser);

//        return UserMapper.mapToUserDto(updateUser);
//        return modelMapper.map(updateUser,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updateUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }
}
