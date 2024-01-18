package com.example.mychef.convert;

import com.example.mychef.dto.VideoCategoriesDTO;
import com.example.mychef.model.VideoCategoriesEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoCategoriesDTOConverter {

    private final ModelMapper modelMapper;

    public VideoCategoriesDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VideoCategoriesDTO convertVideoCategoriesEntityToDTO(VideoCategoriesEntity videoCategoriesEntity)
    {return  modelMapper.map(videoCategoriesEntity, VideoCategoriesDTO.class);
    }

    public VideoCategoriesEntity convertVideoCategoriesDTOToEntity(VideoCategoriesDTO videoCategoriesDTO){
        return  modelMapper.map(videoCategoriesDTO,VideoCategoriesEntity.class);
    }

}
