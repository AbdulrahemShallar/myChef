package com.example.mychef.service;


import com.example.mychef.convert.VideoUserRatingsDTOConverter;
import com.example.mychef.dto.requestDTO.VideoUserRatingsRequestDTO;
import com.example.mychef.dto.responseDTO.VideoUserRatingsResponseDTO;
import com.example.mychef.model.VideoUserRatingsEntity;
import com.example.mychef.repository.VideoUserRatingsRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

    public List<VideoUserRatingsRequestDTO> getUserRatingsByRate(int rate) {
        return videoUserRatingsRepository.findByRate(rate)
                .stream()
                .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoUserRatingsRequestDTO> getUserRatingsByRateBetween(int minRate, int maxRate) {
        return videoUserRatingsRepository.findByRateBetween(minRate, maxRate)
                .stream()
                .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoUserRatingsRequestDTO> getUserRatingsByDateRange(Instant startDate, Instant endDate) {
        return videoUserRatingsRepository.findByDateRange(startDate, endDate)
                .stream()
                .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoUserRatingsRequestDTO> getRatingsWithComments() {
        return videoUserRatingsRepository.findRatingsWithComments()
                .stream()
                .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoUserRatingsRequestDTO> getRatingsWithoutComments() {
        return videoUserRatingsRepository.findRatingsWithoutComments()
                .stream()
                .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoUserRatingsRequestDTO> getUserRatingsByUserAndRate(int userId, int rate) {
        return videoUserRatingsRepository.findByUserAndRate(userId, rate)
                .stream()
                .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }
    public List<VideoUserRatingsRequestDTO> getUserRatingsByRecipeAndRate(int recipeId, int rate) {
        return videoUserRatingsRepository.findByRecipeAndRate(recipeId, rate)
                .stream()
                .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoUserRatingsRequestDTO> getMaxRatedRatings() {
        return videoUserRatingsRepository.findMaxRatedRatings()
                .stream()
                .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoUserRatingsRequestDTO> getMinRatedRatings() {
        return videoUserRatingsRepository.findMinRatedRatings()
                .stream()
                .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }
}
