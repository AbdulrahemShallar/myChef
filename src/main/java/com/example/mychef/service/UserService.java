package com.example.mychef.service;


import com.example.mychef.convert.UserDTOConverter;
import com.example.mychef.dto.UserDTO;
import com.example.mychef.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

     final
     UserDTOConverter userDTOConverter;
    private final UserRepository userRepository;

    public UserService(UserDTOConverter userDTOConverter, UserRepository userRepository) {
        this.userDTOConverter = userDTOConverter;
        this.userRepository = userRepository;
    }

    public UserDTO getUserById(int id){
        return userDTOConverter.convertUserEntityToDTO(userRepository.findUserEntityById(id));
    }
}
