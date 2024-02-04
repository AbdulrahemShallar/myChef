package com.example.mychef.service;


import com.example.mychef.model.VideoUserRatingsEntity;
import com.example.mychef.repository.VideoUserRatingsRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class VideoUserRatingsService {
    
    final
    VideoUserRatingsRepository videoUserRatingsRepository;

    public VideoUserRatingsService(VideoUserRatingsRepository videoUserRatingsRepository) {
        this.videoUserRatingsRepository = videoUserRatingsRepository;
    }


    public VideoUserRatingsEntity newUserRatings(VideoUserRatingsEntity videoUserRatings){
        return videoUserRatingsRepository.save(videoUserRatings);
    }

    // I Should work here by found one element by to Integer Id ???????
//    public VideoUserRatingsEntity updateUserRatings(VideoUserRatingsEntity videoUserRatings,Integer id){
//        VideoUserRatingsEntity foundEntity = videoUserRatingsRepository.
//    }


    public List<VideoUserRatingsEntity> getUserRatingsByUserId(Integer userId){
        return videoUserRatingsRepository.findByUser(userId);
    }
    public List<VideoUserRatingsEntity> getUserRatingsByRecipeId(Integer recipeId){
        return videoUserRatingsRepository.findByRecipe(recipeId);
    }

    public VideoUserRatingsEntity getUserRatingsById(Integer userId,Integer recipeId){
        return videoUserRatingsRepository.findByUserAndRecipe(userId,recipeId);
    }

    public List<VideoUserRatingsEntity> getAllUserUserRatings(){
        return  videoUserRatingsRepository.findAll();
    }

    public List<VideoUserRatingsEntity> getUserRatingsByRate(int rate) {
        return videoUserRatingsRepository.findByRate(rate);
    }

    public List<VideoUserRatingsEntity> getUserRatingsByRateBetween(int minRate, int maxRate) {
        return videoUserRatingsRepository.findByRateBetween(minRate, maxRate);
    }

    public List<VideoUserRatingsEntity> getUserRatingsByDateRange(Instant startDate, Instant endDate) {
        return videoUserRatingsRepository.findByDateRange(startDate, endDate);
    }

    public List<VideoUserRatingsEntity> getRatingsWithComments() {
        return videoUserRatingsRepository.findRatingsWithComments();
    }

    public List<VideoUserRatingsEntity> getRatingsWithoutComments() {
        return videoUserRatingsRepository.findRatingsWithoutComments();
    }

    public List<VideoUserRatingsEntity> getUserRatingsByUserAndRate(int userId, int rate) {
        return videoUserRatingsRepository.findByUserAndRate(userId, rate);
    }
    public List<VideoUserRatingsEntity> getUserRatingsByRecipeAndRate(int recipeId, int rate) {
        return videoUserRatingsRepository.findByRecipeAndRate(recipeId, rate);
    }

    public List<VideoUserRatingsEntity> getMaxRatedRatings() {
        return videoUserRatingsRepository.findMaxRatedRatings();
    }

    public List<VideoUserRatingsEntity> getMinRatedRatings() {
        return videoUserRatingsRepository.findMinRatedRatings();
    }
}
