package com.example.mychef.convert;


import com.example.mychef.dto.requestDTO.ImageRecipeRequestDTO;
import com.example.mychef.dto.responseDTO.ImageRecipeResponseDTO;
import com.example.mychef.model.ImageRecipeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageRecipeDTOConverter {

    private final ModelMapper modelMapper;

    public ImageRecipeDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageRecipeRequestDTO convertImageRecipeEntityToDTO(ImageRecipeEntity imageRecipe){
        return  modelMapper.map(imageRecipe, ImageRecipeRequestDTO.class);
    }

    public ImageRecipeEntity convertImageRecipeDTOtoEntity(ImageRecipeResponseDTO imageRecipeResponseDTO){
        return  modelMapper.map(imageRecipeResponseDTO,ImageRecipeEntity.class);
    }
}
