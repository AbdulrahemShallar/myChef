package com.example.mychef.service;


import com.example.mychef.convert.VideoRecipeDTOConverter;
import com.example.mychef.dto.VideoRecipeDTO;
import com.example.mychef.model.VideoRecipeEntity;
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

    public VideoRecipeEntity newRecipe(VideoRecipeEntity videoRecipeEntity) {
        return videoRecipeRepository.save(videoRecipeEntity);
    }

    public VideoRecipeEntity updateRecipe(VideoRecipeEntity videoRecipeEntity, Integer id) {
        VideoRecipeEntity foundRecipe = videoRecipeRepository.findVideoRecipeEntityById(id);
        if (foundRecipe != null) {
            foundRecipe.setTitle(videoRecipeEntity.getTitle());
            foundRecipe.setPicture(videoRecipeEntity.getPicture());
            foundRecipe.setComponent(videoRecipeEntity.getComponent());
            foundRecipe.setPreparationMethod(videoRecipeEntity.getPreparationMethod());
            //****** it should br object inside object ***************
            foundRecipe.setCategory(videoRecipeEntity.getCategory());

            return videoRecipeRepository.save(foundRecipe);
        }
        return null;
    }
    public VideoRecipeEntity updateRecipeLikes(Integer id)
    {   VideoRecipeEntity foundRecipe = videoRecipeRepository.findVideoRecipeEntityById(id);
        if(foundRecipe != null){
            foundRecipe.setLikes(1+foundRecipe.getLikes());
            return videoRecipeRepository.save(foundRecipe);
        }
        return null;
    }
    public List<VideoRecipeDTO> getAllRecipe(){
        return videoRecipeRepository.findAll()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public VideoRecipeDTO getVideoRecipeById(int id){
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeRepository.findVideoRecipeEntityById(id));
    }

    //******* I still need for total rate update i think i should get average for userRating Service

}
