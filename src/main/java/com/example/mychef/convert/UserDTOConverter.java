package com.example.mychef.convert;


import com.example.mychef.dto.UserDTO;
import com.example.mychef.model.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public  UserDTO convertUsertoUserDTO(UserEntity user){
        return  modelMapper.map(user, UserDTO.class);
    }

    public UserEntity convertUserDTOtoUser(UserDTO userDTO){
        return  modelMapper.map(userDTO,UserEntity.class);
    }
}
