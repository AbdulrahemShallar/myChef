package com.example.mychef.service;


import com.example.mychef.convert.ImageRecipeDTOConverter;
import com.example.mychef.dto.ImageRecipeDTO;
import com.example.mychef.repository.ImageRecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImageRecipeService {

    final
    ImageRecipeDTOConverter imageRecipeDTOCOnverter;

    private final ImageRecipeRepository imageRecipeRepository;

    public ImageRecipeService(ImageRecipeDTOConverter imageRecipeDTOCOnverter, ImageRecipeRepository imageRecipeRepository) {
        this.imageRecipeDTOCOnverter = imageRecipeDTOCOnverter;
        this.imageRecipeRepository = imageRecipeRepository;
    }

    public ImageRecipeDTO getImageRecipe(int id){
        return imageRecipeDTOCOnverter.convertImageRecipeEntityToDTO(imageRecipeRepository.findImageRecipeEntityById(id));

    }
}
