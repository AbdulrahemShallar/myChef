package com.example.mychef.service;


import com.example.mychef.convert.ImageRecipeDTOConverter;
import com.example.mychef.dto.ImageRecipeDTO;
import com.example.mychef.model.ImageRecipeEntity;
import com.example.mychef.repository.ImageRecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public ImageRecipeEntity newRecipe(ImageRecipeEntity imageRecipeEntity) {
        return imageRecipeRepository.save(imageRecipeEntity);
    }

    public ImageRecipeEntity updateRecipe(ImageRecipeEntity imageRecipeEntity, Integer id) {
        ImageRecipeEntity foundRecipe = imageRecipeRepository.findImageRecipeEntityById(id);
        if (foundRecipe != null) {
            foundRecipe.setTitle(imageRecipeEntity.getTitle());
            foundRecipe.setPicture(imageRecipeEntity.getPicture());
            foundRecipe.setComponent(imageRecipeEntity.getComponent());
            foundRecipe.setPreparationMethod(imageRecipeEntity.getPreparationMethod());
            //****** it should br object inside object ***************
            foundRecipe.setCategory(imageRecipeEntity.getCategory());

            return imageRecipeRepository.save(foundRecipe);
        }
        return null;
    }

    public ImageRecipeEntity updateRecipeLikes(Integer id)
    {   ImageRecipeEntity foundRecipe = imageRecipeRepository.findImageRecipeEntityById(id);
        if(foundRecipe != null){
            foundRecipe.setLikes(1+foundRecipe.getLikes());
            return imageRecipeRepository.save(foundRecipe);
        }
        return null;
    }

    public ImageRecipeDTO getImageRecipe(int id){
        return imageRecipeDTOCOnverter.convertImageRecipeEntityToDTO(imageRecipeRepository.findImageRecipeEntityById(id));

    }

    public List<ImageRecipeDTO> getAllRecipe(){
        return imageRecipeRepository.findAll()
                .stream()
                .map(imageRecipeDTOCOnverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    //******* i still need for total rate update i think i should get average for userRating Service
}
