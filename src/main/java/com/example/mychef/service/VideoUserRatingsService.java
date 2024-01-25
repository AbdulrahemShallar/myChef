package com.example.mychef.service;


import com.example.mychef.convert.VideoUserRatingsDTOConverter;
import com.example.mychef.dto.requestDTO.VideoUserRatingsRequestDTO;
import com.example.mychef.dto.responseDTO.VideoUserRatingsResponseDTO;
import com.example.mychef.model.VideoUserRatingsEntity;
import com.example.mychef.repository.VideoUserRatingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoUserRatingsService {
    final
    VideoUserRatingsDTOConverter videoUserRatingsDTOConverter;
    final
    VideoUserRatingsRepository videoUserRatingsRepository;

    public VideoUserRatingsService(VideoUserRatingsDTOConverter videoUserRatingsDTOConverter, VideoUserRatingsRepository videoUserRatingsRepository) {
        this.videoUserRatingsDTOConverter = videoUserRatingsDTOConverter;
        this.videoUserRatingsRepository = videoUserRatingsRepository;
    }


    public VideoUserRatingsEntity newUserRatings(VideoUserRatingsResponseDTO videoUserRatings){
        return videoUserRatingsRepository.save(videoUserRatingsDTOConverter.convertVideoUserRatingsDTOToEntity(videoUserRatings));
    }

    // I Should work here by found one element by to Integer Id ???????
//    public VideoUserRatingsEntity updateUserRatings(VideoUserRatingsResponseDTO videoUserRatings,Integer id){
//        VideoUserRatingsEntity foundEntity = videoUserRatingsRepository.
//    }


    public List<VideoUserRatingsRequestDTO> getUserRatingsByUserId(Integer userId){

        List<VideoUserRatingsEntity> entityList = videoUserRatingsRepository.findByUser(userId);
        if(entityList != null){
            return entityList.stream()
                    .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }
    public List<VideoUserRatingsRequestDTO> getUserRatingsByRecipeId(Integer recipeId){
        List<VideoUserRatingsEntity> entityList = videoUserRatingsRepository.findByRecipe(recipeId);
        if(entityList != null){

            return entityList.stream()
                    .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public VideoUserRatingsRequestDTO getUserRatingsById(Integer userId,Integer recipeId){

        VideoUserRatingsEntity entity = videoUserRatingsRepository.findByUserAndRecipe(userId,recipeId);
        if(entity != null){
            return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(entity);
        }
        return null;
    }

    public List<VideoUserRatingsRequestDTO> getAllUserUserRatings(){
        return videoUserRatingsRepository.findAll()
                .stream()
                .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }
}
