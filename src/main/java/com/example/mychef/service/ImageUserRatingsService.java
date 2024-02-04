package com.example.mychef.service;


import com.example.mychef.model.ImageUserRatingsEntity;
import com.example.mychef.repository.ImageUserRatingsRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ImageUserRatingsService {
    
    final
    ImageUserRatingsRepository imageUserRatingsRepository;

    public ImageUserRatingsService(ImageUserRatingsRepository imageUserRatingsRepository) {
        this.imageUserRatingsRepository = imageUserRatingsRepository;
    }

    public ImageUserRatingsEntity newUserRatings(ImageUserRatingsEntity imageUserRatings){
        return imageUserRatingsRepository.save(imageUserRatings);
    }

    // I Should work here by found one element by to Integer Id ???????
//    public ImageUserRatingsEntity updateUserRatings(ImageUserRatingsEntity imageUserRatings,Integer id){
//        ImageUserRatingsEntity foundEntity = imageUserRatingsRepository.
//    }

    public List<ImageUserRatingsEntity> getUserRatingsByUserId(Integer userId){
        return imageUserRatingsRepository.findByUser(userId);
    }
    public List<ImageUserRatingsEntity> getUserRatingsByRecipeId(Integer recipeId){
        return imageUserRatingsRepository.findByRecipe(recipeId);
    }

    public ImageUserRatingsEntity getUserRatingsById(Integer userId,Integer recipeId){
        return imageUserRatingsRepository.findByUserAndRecipe(userId,recipeId);
    }


    public List<ImageUserRatingsEntity> getAllUserUserRatings(){
        return imageUserRatingsRepository.findAll();
                
    }

    public List<ImageUserRatingsEntity> getUserRatingsByRate(int rate) {
        return imageUserRatingsRepository.findByRate(rate);
                
    }

    public List<ImageUserRatingsEntity> getUserRatingsByRateBetween(int minRate, int maxRate) {
        return imageUserRatingsRepository.findByRateBetween(minRate, maxRate);
                
    }

    public List<ImageUserRatingsEntity> getUserRatingsByDateRange(Instant startDate, Instant endDate) {
        return imageUserRatingsRepository.findByDateRange(startDate, endDate);
                
    }

    public List<ImageUserRatingsEntity> getRatingsWithComments() {
        return imageUserRatingsRepository.findRatingsWithComments();
                
    }

    public List<ImageUserRatingsEntity> getRatingsWithoutComments() {
        return imageUserRatingsRepository.findRatingsWithoutComments();
                
    }

    public List<ImageUserRatingsEntity> getUserRatingsByUserAndRate(int userId, int rate) {
        return imageUserRatingsRepository.findByUserAndRate(userId, rate);
                
    }
    public List<ImageUserRatingsEntity> getUserRatingsByRecipeAndRate(int recipeId, int rate) {
        return imageUserRatingsRepository.findByRecipeAndRate(recipeId, rate);
                
    }

    public List<ImageUserRatingsEntity> getMaxRatedRatings() {
        return imageUserRatingsRepository.findMaxRatedRatings();
                
    }

    public List<ImageUserRatingsEntity> getMinRatedRatings() {
        return imageUserRatingsRepository.findMinRatedRatings();
                
    }
}
