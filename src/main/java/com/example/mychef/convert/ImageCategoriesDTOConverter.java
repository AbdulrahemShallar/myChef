package com.example.mychef.convert;

import com.example.mychef.dto.ImageCategoriesDTO;
import com.example.mychef.model.ImageCategoriesEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageCategoriesDTOConverter {

    private final ModelMapper modelMapper;
    public ImageCategoriesDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageCategoriesDTO convertImageCategoriesEntityToDTO(ImageCategoriesEntity imageCategories){
        return  modelMapper.map(imageCategories,ImageCategoriesDTO.class);
    }

    public ImageCategoriesEntity convertImageCategoriesDTOToDEntity(ImageCategoriesDTO imageCategoriesDTO){
        return  modelMapper.map(imageCategoriesDTO,ImageCategoriesEntity.class);
    }

}
