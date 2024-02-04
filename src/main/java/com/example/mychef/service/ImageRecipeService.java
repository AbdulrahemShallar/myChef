package com.example.mychef.service;


import com.example.mychef.model.ImageCategoriesEntity;
import com.example.mychef.model.ImageRecipeEntity;
import com.example.mychef.repository.ImageRecipeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ImageRecipeService {

    

    private final ImageRecipeRepository imageRecipeRepository;

    public ImageRecipeService(ImageRecipeRepository imageRecipeRepository) {
        this.imageRecipeRepository = imageRecipeRepository;
    }

    public ImageRecipeEntity newRecipe(ImageRecipeEntity imageRecipeEntity) {
        return imageRecipeRepository.save(imageRecipeEntity);
    }

   // I have to work in this part Because It Git To Many Query
    public ImageRecipeEntity updateRecipe(ImageRecipeEntity imageRecipe, Integer id) {
        ImageRecipeEntity foundRecipe = imageRecipeRepository.findImageRecipeEntityById(id);

        if (foundRecipe != null) {
            foundRecipe.setTitle(imageRecipe.getTitle());
            foundRecipe.setPicture(imageRecipe.getPicture());
            foundRecipe.setComponent(imageRecipe.getComponent());
            foundRecipe.setPreparationMethod(imageRecipe.getPreparationMethod());

            if(imageRecipe.getCategory().getId() > 0)
                foundRecipe.setCategory(imageRecipe.getCategory());

            return imageRecipeRepository.save(foundRecipe);
        }
        return null;
    }
    //**********   I have to work in this Part ***************
    public ImageRecipeEntity updateRecipeLikes(Integer id)
    {   ImageRecipeEntity foundRecipe = imageRecipeRepository.findImageRecipeEntityById(id);
        if(foundRecipe != null){
            foundRecipe.setLikes( 1 + foundRecipe.getLikes());
            return imageRecipeRepository.save(foundRecipe);
        }
        return null;
    }

    public ImageRecipeEntity getImageRecipe(int id) {
        return imageRecipeRepository.findImageRecipeEntityById(id);
    }


    public List<ImageRecipeEntity> getAllRecipe(){
        return imageRecipeRepository.findAll();
    }

    public List<ImageRecipeEntity> getRecipesWithTitleContaining(String keyword) {
        return imageRecipeRepository.findByTitleContaining(keyword);
    }

    public List<ImageRecipeEntity> getRecipesByCategory(ImageCategoriesEntity category) {
        return imageRecipeRepository.findByCategory(category);
    }

    public List<ImageRecipeEntity> getRecipesByTotalRateGreaterThan(int rate) {
        return imageRecipeRepository.findByTotalRateGreaterThan(rate);
    }

    public List<ImageRecipeEntity> getRecipesByLikesGreaterThan(int likes) {
        return imageRecipeRepository.findByLikesGreaterThan(likes);
    }

    public List<ImageRecipeEntity> getRecipesByDateAfter(LocalDate date) {
        return imageRecipeRepository.findByDateAfter(date);
    }

    public List<ImageRecipeEntity> getRecipesOrderByTotalRateDesc() {
        return imageRecipeRepository.findByOrderByTotalRateDesc();
    }

    public List<ImageRecipeEntity> getMostLikedRecipe() {
        return imageRecipeRepository.findMostLikedRecipe();
    }

    public List<ImageRecipeEntity> getRecipesByMinRatings(int minRatings) {
        return imageRecipeRepository.findByMinRatings(minRatings);
    }

    public List<ImageRecipeEntity> getRecipesByTotalRateBetween(int minRate, int maxRate) {
        return imageRecipeRepository.findByTotalRateBetween(minRate, maxRate);
    }

    public List<ImageRecipeEntity> getRecipesByDateBetween(LocalDate startDate, LocalDate endDate) {
        return imageRecipeRepository.findByDateBetween(startDate, endDate);
    }

    public List<ImageRecipeEntity> getLeastLikedRecipe() {
        return imageRecipeRepository.findLeastLikedRecipe();
    }

    public List<ImageRecipeEntity> getRecipesWithTitleContainingIgnoreCase(String keyword) {
        return imageRecipeRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public List<ImageRecipeEntity> getTopRatedRecipe() {
        return imageRecipeRepository.findTopRatedRecipe();
    }

    public List<ImageRecipeEntity> getRecipesCreatedToday() {
        return imageRecipeRepository.findRecipesCreatedToday();
    }

    public List<ImageRecipeEntity> getRecipesWithNoLikes() {
        return imageRecipeRepository.findRecipesWithNoLikes();
    }

    public List<ImageRecipeEntity> getLatestRecipe() {
        return imageRecipeRepository.findLatestRecipe();
    }

    //******* i still need for total rate update i think i should get average for userRating Service
}
