package com.example.mychef.service;


import com.example.mychef.convert.ImageUserRatingsDTOConverter;
import com.example.mychef.dto.requestDTO.ImageUserRatingsRequestDTO;
import com.example.mychef.dto.responseDTO.ImageUserRatingsResponseDTO;
import com.example.mychef.model.ImageUserRatingsEntity;
import com.example.mychef.repository.ImageUserRatingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageUserRatingsService {
    final ImageUserRatingsDTOConverter imageUserRatingsDTOConverter;
    final
    ImageUserRatingsRepository imageUserRatingsRepository;

    public ImageUserRatingsService(ImageUserRatingsDTOConverter imageUserRatingsDTOConverter, ImageUserRatingsRepository imageUserRatingsRepository) {
        this.imageUserRatingsDTOConverter = imageUserRatingsDTOConverter;
        this.imageUserRatingsRepository = imageUserRatingsRepository;
    }

    public ImageUserRatingsEntity newUserRatings(ImageUserRatingsResponseDTO imageUserRatings){
        return imageUserRatingsRepository.save(imageUserRatingsDTOConverter.convertImageUserRatingsDTOToEntity(imageUserRatings));
    }

    // I Should work here by found one element by to Integer Id ???????
//    public ImageUserRatingsEntity updateUserRatings(ImageUserRatingsResponseDTO imageUserRatings,Integer id){
//        ImageUserRatingsEntity foundEntity = imageUserRatingsRepository.
//    }

    public List<ImageUserRatingsRequestDTO> getUserRatingsByUserId(Integer userId){

        List<ImageUserRatingsEntity> entityList = imageUserRatingsRepository.findByUser(userId);
        if(entityList != null){
            return entityList.stream()
                    .map(imageUserRatingsDTOConverter::convertImageUserRatingsEntityToDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }
    public List<ImageUserRatingsRequestDTO> getUserRatingsByRecipeId(Integer recipeId){
        List<ImageUserRatingsEntity> entityList = imageUserRatingsRepository.findByRecipe(recipeId);
        if(entityList != null){

            return entityList.stream()
                    .map(imageUserRatingsDTOConverter::convertImageUserRatingsEntityToDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public ImageUserRatingsRequestDTO getUserRatingsById(Integer userId,Integer recipeId){

        ImageUserRatingsEntity entity = imageUserRatingsRepository.findByUserAndRecipe(userId,recipeId);
        if(entity != null){
            return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(entity);
        }
        return null;
    }


    public List<ImageUserRatingsRequestDTO> getAllUserUserRatings(){
        return imageUserRatingsRepository.findAll()
                .stream()
                .map(imageUserRatingsDTOConverter::convertImageUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }
}
