package com.example.mychef.service;


import com.example.mychef.convert.UserDTOConverter;
import com.example.mychef.dto.UserDTO;
import com.example.mychef.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

     @Autowired
     UserDTOConverter userDTOConverter;

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUser(int id){
        return userDTOConverter.convertUsertoUserDTO(userRepository.findUserEntityById(id));
    }
}
