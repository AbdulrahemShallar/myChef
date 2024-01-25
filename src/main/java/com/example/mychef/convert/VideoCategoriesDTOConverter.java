package com.example.mychef.convert;

import com.example.mychef.dto.requestDTO.VideoCategoriesRequestDTO;
import com.example.mychef.dto.responseDTO.VideoCategoriesResponseDTO;
import com.example.mychef.model.VideoCategoriesEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoCategoriesDTOConverter {

    private final ModelMapper modelMapper;

    public VideoCategoriesDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VideoCategoriesRequestDTO convertVideoCategoriesEntityToDTO(VideoCategoriesEntity videoCategoriesEntity)
    {return  modelMapper.map(videoCategoriesEntity, VideoCategoriesRequestDTO.class);
    }

    public VideoCategoriesEntity convertVideoCategoriesDTOToEntity(VideoCategoriesResponseDTO videoCategoriesResponseDTO){
        return  modelMapper.map(videoCategoriesResponseDTO,VideoCategoriesEntity.class);
    }

}
