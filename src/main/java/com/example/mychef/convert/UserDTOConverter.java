package com.example.mychef.convert;


import com.example.mychef.dto.requestDTO.UserRequestDTO;
import com.example.mychef.dto.responseDTO.UserResponseDTO;
import com.example.mychef.model.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter {

    private final ModelMapper modelMapper;

    public UserDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserRequestDTO convertUserEntityToDTO(UserEntity user){
        return  modelMapper.map(user, UserRequestDTO.class);
    }

    public UserEntity convertUserDTOToEntity(UserResponseDTO userResponseDTO){
        return  modelMapper.map(userResponseDTO,UserEntity.class);
    }
}
