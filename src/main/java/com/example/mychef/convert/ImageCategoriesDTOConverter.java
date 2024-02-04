package com.example.mychef.convert;

import com.example.mychef.dto.responseDTO.ImageCategoriesResponseDTO;
import com.example.mychef.dto.requestDTO.ImageCategoriesRequestDTO;
import com.example.mychef.model.ImageCategoriesEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

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

    public List<ImageCategoriesRequestDTO> convertImageCategoriesEntityToDTO(List<ImageCategoriesEntity> list){
       return list.stream()
                .map(entity -> modelMapper.map(entity, ImageCategoriesRequestDTO.class))
                .collect(Collectors.toList());
            }

    public List<ImageCategoriesEntity> convertImageCategoriesDTOToDEntity(List<ImageCategoriesResponseDTO> list){
        return list.stream()
                .map(dto -> modelMapper.map(dto,ImageCategoriesEntity.class))
                .collect(Collectors.toList());
    }

}
