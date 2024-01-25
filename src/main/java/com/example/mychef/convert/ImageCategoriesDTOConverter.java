package com.example.mychef.convert;

import com.example.mychef.dto.responseDTO.ImageCategoriesResponseDTO;
import com.example.mychef.dto.requestDTO.ImageCategoriesRequestDTO;
import com.example.mychef.model.ImageCategoriesEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageCategoriesDTOConverter {

    private final ModelMapper modelMapper;
    public ImageCategoriesDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageCategoriesRequestDTO convertImageCategoriesEntityToDTO(ImageCategoriesEntity imageCategories){
        return  modelMapper.map(imageCategories, ImageCategoriesRequestDTO.class);
    }

    public ImageCategoriesEntity convertImageCategoriesDTOToDEntity(ImageCategoriesResponseDTO imageCategoriesResponseDTO){
        return  modelMapper.map(imageCategoriesResponseDTO,ImageCategoriesEntity.class);
    }

}
