package com.example.mychef.convert;


import com.example.mychef.dto.ImageRecipeDTO;
import com.example.mychef.model.ImageRecipeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageRecipeDTOConverter {

    private final ModelMapper modelMapper;

    public ImageRecipeDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageRecipeDTO convertImageRecipeEntityToDTO(ImageRecipeEntity imageRecipe){
        return  modelMapper.map(imageRecipe,ImageRecipeDTO.class);
    }

    public ImageRecipeEntity convertImageRecipeDTOtoEntity(ImageRecipeDTO imageRecipeDTO){
        return  modelMapper.map(imageRecipeDTO,ImageRecipeEntity.class);
    }
}
