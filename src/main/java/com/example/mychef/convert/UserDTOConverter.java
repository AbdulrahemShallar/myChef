package com.example.mychef.convert;


import com.example.mychef.dto.UserDTO;
import com.example.mychef.model.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter {

    private final ModelMapper modelMapper;

    public UserDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public  UserDTO convertUserEntityToDTO(UserEntity user){
        return  modelMapper.map(user, UserDTO.class);
    }

    public UserEntity convertUserDTOToEntity(UserDTO userDTO){
        return  modelMapper.map(userDTO,UserEntity.class);
    }
}
