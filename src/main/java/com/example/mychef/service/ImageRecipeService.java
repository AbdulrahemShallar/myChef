package com.example.mychef.service;


import com.example.mychef.convert.ImageRecipeDTOConverter;
import com.example.mychef.dto.requestDTO.ImageRecipeRequestDTO;
import com.example.mychef.dto.responseDTO.ImageRecipeResponseDTO;
import com.example.mychef.model.ImageCategoriesEntity;
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
    ImageRecipeDTOConverter imageRecipeDTOConverter;

    private final ImageRecipeRepository imageRecipeRepository;

    public ImageRecipeService(ImageRecipeDTOConverter imageRecipeDTOCOnverter, ImageRecipeRepository imageRecipeRepository) {
        this.imageRecipeDTOConverter = imageRecipeDTOCOnverter;
        this.imageRecipeRepository = imageRecipeRepository;
    }

    public ImageRecipeEntity newRecipe(ImageRecipeResponseDTO imageRecipeResponseDTO) {
        ImageRecipeEntity imageRecipeEntity = imageRecipeDTOConverter.convertImageRecipeDTOtoEntity(imageRecipeResponseDTO);

        ImageCategoriesEntity category = new ImageCategoriesEntity();
        category.setId(imageRecipeResponseDTO.getCategory_id());
        imageRecipeEntity.setCategory(category);

        return imageRecipeRepository.save(imageRecipeEntity);
    }

    public ImageRecipeEntity updateRecipe(ImageRecipeResponseDTO imageRecipeResponseDTO, Integer id) {
        ImageRecipeEntity foundRecipe = imageRecipeRepository.findImageRecipeEntityById(id);

        if (foundRecipe != null) {
            foundRecipe.setTitle(imageRecipeResponseDTO.getTitle());
            foundRecipe.setPicture(imageRecipeResponseDTO.getPicture());
            foundRecipe.setComponent(imageRecipeResponseDTO.getComponent());
            foundRecipe.setPreparationMethod(imageRecipeResponseDTO.getPreparationMethod());

            if(imageRecipeResponseDTO.getCategory_id() > 0)
                foundRecipe.setCategory(getCategory(imageRecipeResponseDTO));

            return imageRecipeRepository.save(foundRecipe);
        }
        return null;
    }

    private ImageCategoriesEntity getCategory(ImageRecipeResponseDTO recipeResponseDTO){
        ImageCategoriesEntity category = new ImageCategoriesEntity();
        category.setId(recipeResponseDTO.getCategory_id());
        return  category;
    }
    public ImageRecipeEntity updateRecipeLikes(Integer id)
    {   ImageRecipeEntity foundRecipe = imageRecipeRepository.findImageRecipeEntityById(id);
        if(foundRecipe != null){
            foundRecipe.setLikes(1+foundRecipe.getLikes());
            return imageRecipeRepository.save(foundRecipe);
        }
        return null;
    }

    public ImageRecipeRequestDTO getImageRecipe(int id) {

        ImageRecipeEntity imageRecipeEntity = imageRecipeRepository.findImageRecipeEntityById(id);
        // Check if the entity exists
        if (imageRecipeEntity == null) {
            // Handle the case where the entity with the provided id is not found
            // You might throw an exception or return null based on your requirements
            return null;
        }
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeEntity);
    }


    public List<ImageRecipeRequestDTO> getAllRecipe(){
        return imageRecipeRepository.findAll()
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    //******* i still need for total rate update i think i should get average for userRating Service
}
