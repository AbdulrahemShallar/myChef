package com.example.mychef.service;


import com.example.mychef.convert.ImageRecipeDTOCOnverter;
import com.example.mychef.dto.ImageRecipeDTO;
import com.example.mychef.model.ImageRecipeEntity;
import com.example.mychef.repository.ImageRecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageRecipeService {

    final
    ImageRecipeDTOCOnverter imageRecipeDTOCOnverter;

    private final ImageRecipeRepository imageRecipeRepository;

    public ImageRecipeService(ImageRecipeDTOCOnverter imageRecipeDTOCOnverter, ImageRecipeRepository imageRecipeRepository) {
        this.imageRecipeDTOCOnverter = imageRecipeDTOCOnverter;
        this.imageRecipeRepository = imageRecipeRepository;
    }

    public ImageRecipeDTO getImageRecipe(int id){
        ImageRecipeEntity imageRecipeEntities = imageRecipeRepository.findImageRecipeEntityById(id);
        return imageRecipeDTOCOnverter.convertImageRecipetoImageRecipeDTO(imageRecipeEntities);

    }
}
