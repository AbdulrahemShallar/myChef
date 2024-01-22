package com.example.mychef.service;


import com.example.mychef.convert.UserDTOConverter;
import com.example.mychef.dto.UserDTO;
import com.example.mychef.model.UserEntity;
import com.example.mychef.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

     final
     UserDTOConverter userDTOConverter;
    private final UserRepository userRepository;

    public UserService(UserDTOConverter userDTOConverter, UserRepository userRepository) {
        this.userDTOConverter = userDTOConverter;
        this.userRepository = userRepository;
    }

    public UserEntity newUser(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity userUpdate,Integer id){
        UserEntity foundUser = userRepository.findUserEntityById(id);
        if (foundUser != null){
            foundUser.setName(userUpdate.getName());
            foundUser.setEmail(userUpdate.getEmail());
            foundUser.setPicture(userUpdate.getPicture());
            foundUser.setPassword(userUpdate.getPassword());
            return userRepository.save(foundUser);
        }
        return null;
    }

    public UserDTO getUserById(int id){
        return userDTOConverter.convertUserEntityToDTO(userRepository.findUserEntityById(id));
    }

    public List<UserDTO> getAllUser(){
        return userRepository.findAll()
                .stream()
                .map(userDTOConverter::convertUserEntityToDTO)
                .collect(Collectors.toList());
    }

}
