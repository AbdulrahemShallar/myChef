package com.example.mychef.service;


import com.example.mychef.convert.VideoRecipeDTOConverter;
import com.example.mychef.dto.VideoRecipeDTO;
import com.example.mychef.repository.VideoRecipeRepository;
import org.springframework.stereotype.Service;

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

    public VideoRecipeDTO getVideoRecipeById(int id){
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeRepository.findVideoRecipeEntityById(id));
    }

}
