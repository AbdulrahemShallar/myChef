package com.example.mychef.service;


import com.example.mychef.convert.VideoRecipeDTOConverter;
import com.example.mychef.dto.responseDTO.VideoRecipeResponseDTO;
import com.example.mychef.dto.requestDTO.VideoRecipeRequestDTO;
import com.example.mychef.model.*;
import com.example.mychef.repository.VideoRecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoRecipeService {

    final
    VideoRecipeDTOConverter videoRecipeDTOConverter;

    final
    VideoRecipeRepository videoRecipeRepository;

    public VideoRecipeService(VideoRecipeDTOConverter videoRecipeDTOConverter, VideoRecipeRepository videoRecipeRepository) {
        this.videoRecipeDTOConverter = videoRecipeDTOConverter;
        this.videoRecipeRepository = videoRecipeRepository;
    }

    public VideoRecipeEntity newRecipe(VideoRecipeResponseDTO recipeDTO) {
        VideoRecipeEntity videoRecipeEntity = videoRecipeDTOConverter.convertVideoRecipeDTOToEntity(recipeDTO);

        if(recipeDTO.getCategoryID() > 0)
            videoRecipeEntity.setCategory(getCategory(recipeDTO));

        if(recipeDTO.getChefID() > 0)
            videoRecipeEntity.setChef(getChef(recipeDTO));

        return videoRecipeRepository.save(videoRecipeEntity);
    }

    public VideoRecipeEntity updateRecipe(VideoRecipeResponseDTO videoRecipeResponseDTO, Integer id) {
        VideoRecipeEntity foundRecipe = videoRecipeRepository.findVideoRecipeEntityById(id);
        if (foundRecipe != null) {
            foundRecipe.setTitle(videoRecipeResponseDTO.getTitle());
            foundRecipe.setPicture(videoRecipeResponseDTO.getPicture());
            foundRecipe.setComponent(videoRecipeResponseDTO.getComponent());
            foundRecipe.setPreparationMethod(videoRecipeResponseDTO.getPreparationMethod());

            if(videoRecipeResponseDTO.getCategoryID() > 0)
                foundRecipe.setCategory(getCategory(videoRecipeResponseDTO));

            if(videoRecipeResponseDTO.getChefID() > 0)
                foundRecipe.setChef(getChef(videoRecipeResponseDTO));

            return videoRecipeRepository.save(foundRecipe);
        }
        return null;
    }

    private ChefEntity getChef(VideoRecipeResponseDTO recipeResponseDTO){
        ChefEntity chef = new ChefEntity();
        chef.setId(recipeResponseDTO.getChefID());
        return  chef;
    }
    private VideoCategoriesEntity getCategory(VideoRecipeResponseDTO recipeResponseDTO){
        VideoCategoriesEntity category = new VideoCategoriesEntity();
        category.setId(recipeResponseDTO.getCategoryID());
        return  category;
    }
    public VideoRecipeEntity updateRecipeLikes(Integer id)
    {   VideoRecipeEntity foundRecipe = videoRecipeRepository.findVideoRecipeEntityById(id);
        if(foundRecipe != null){
            foundRecipe.setLikes(1+foundRecipe.getLikes());
            return videoRecipeRepository.save(foundRecipe);
        }
        return null;
    }
    public List<VideoRecipeRequestDTO> getAllRecipe(){
        return videoRecipeRepository.findAll()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public VideoRecipeRequestDTO getVideoRecipeById(int id){
        VideoRecipeEntity videoRecipeEntity = videoRecipeRepository.findVideoRecipeEntityById(id);
        // Check if the entity exists
        if (videoRecipeEntity == null) {
            // Handle the case where the entity with the provided id is not found
            // You might throw an exception or return null based on your requirements
            return null;
        }
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeEntity);
    }

    //******* I still need for total rate update i think i should get average for userRating Service

}
