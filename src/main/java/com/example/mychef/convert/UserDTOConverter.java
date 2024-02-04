package com.example.mychef.convert;


import com.example.mychef.dto.requestDTO.UserRequestDTO;
import com.example.mychef.dto.responseDTO.UserResponseDTO;
import com.example.mychef.model.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<UserRequestDTO> convertUserEntityToDTO(List<UserEntity> list){
        return  list.stream()
                .map(entity -> modelMapper.map(entity, UserRequestDTO.class))
                .collect(Collectors.toList());
    }

    public List<UserEntity> convertUserDTOToEntity(List<UserResponseDTO> list) {
        return list.stream()
                .map(dto -> modelMapper.map(dto, UserEntity.class))
                .collect(Collectors.toList());
    }
}
