package com.example.mychef.convert;


import com.example.mychef.dto.ImageRecipeDTO;
import com.example.mychef.model.ImageRecipeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageRecipeDTOCOnverter {

    private final ModelMapper modelMapper;

    public ImageRecipeDTOCOnverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageRecipeDTO convertImageRecipetoImageRecipeDTO(ImageRecipeEntity imageRecipe){
        return  modelMapper.map(imageRecipe,ImageRecipeDTO.class);
    }

    public ImageRecipeEntity convertImageRecipeDTOtoImageRecipe(ImageRecipeDTO imageRecipeDTO){
        return  modelMapper.map(imageRecipeDTO,ImageRecipeEntity.class);
    }
}
