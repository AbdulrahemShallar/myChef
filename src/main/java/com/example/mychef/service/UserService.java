package com.example.mychef.service;


import com.example.mychef.convert.UserDTOConverter;
import com.example.mychef.dto.requestDTO.UserRequestDTO;
import com.example.mychef.dto.responseDTO.UserResponseDTO;
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

    public UserEntity newUser(UserResponseDTO user){
        return userRepository.save(userDTOConverter.convertUserDTOToEntity(user));
    }

    public UserEntity updateUser(UserResponseDTO userUpdate,Integer id){
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

    public UserRequestDTO getUserById(int id){
        return userDTOConverter.convertUserEntityToDTO(userRepository.findUserEntityById(id));
    }

    public List<UserRequestDTO> getAllUser(){
        return userRepository.findAll()
                .stream()
                .map(userDTOConverter::convertUserEntityToDTO)
                .collect(Collectors.toList());
    }

}
