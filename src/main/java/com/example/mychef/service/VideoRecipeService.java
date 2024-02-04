package com.example.mychef.service;


import com.example.mychef.model.*;
import com.example.mychef.repository.VideoRecipeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VideoRecipeService {



    final
    VideoRecipeRepository videoRecipeRepository;

    public VideoRecipeService(VideoRecipeRepository videoRecipeRepository) {
        this.videoRecipeRepository = videoRecipeRepository;
    }

    public VideoRecipeEntity newRecipe(VideoRecipeEntity entity) {
        return videoRecipeRepository.save(entity);
    }

    public VideoRecipeEntity updateRecipe(VideoRecipeEntity entity, Integer id) {
        VideoRecipeEntity foundRecipe = videoRecipeRepository.findVideoRecipeEntityById(id);
        if (foundRecipe != null) {
            foundRecipe.setTitle(entity.getTitle());
            foundRecipe.setPicture(entity.getPicture());
            foundRecipe.setComponent(entity.getComponent());
            foundRecipe.setPreparationMethod(entity.getPreparationMethod());

            if(entity.getCategory() != null)
                foundRecipe.setCategory(entity.getCategory());

            if(entity.getChef() != null)
                foundRecipe.setChef(entity.getChef());

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

    public List<VideoRecipeEntity> getAllRecipe(){
        return videoRecipeRepository.findAll();
    }


    public VideoRecipeEntity getVideoRecipeById(int id){
        return videoRecipeRepository.findVideoRecipeEntityById(id);
    }
    public List<VideoRecipeEntity> getRecipesWithTitleContaining(String keyword) {
        return videoRecipeRepository.findByTitleContaining(keyword);
    }


    public List<VideoRecipeEntity> getRecipesByCategory(VideoCategoriesEntity category) {
        return videoRecipeRepository.findByCategory(category);
    }

    public List<VideoRecipeEntity> getRecipesByTotalRateGreaterThan(int rate) {
        return videoRecipeRepository.findByTotalRateGreaterThan(rate);
    }

    public List<VideoRecipeEntity> getRecipesByLikesGreaterThan(int likes) {
        return videoRecipeRepository.findByLikesGreaterThan(likes);
    }

    public List<VideoRecipeEntity> getRecipesByDateAfter(LocalDate date) {
        return videoRecipeRepository.findByDateAfter(date);
    }

    public List<VideoRecipeEntity> getRecipesOrderByTotalRateDesc() {
        return videoRecipeRepository.findByOrderByTotalRateDesc();
    }

    public List<VideoRecipeEntity> getMostLikedRecipe() {
        return videoRecipeRepository.findMostLikedRecipe();
    }

    public List<VideoRecipeEntity> getRecipesByMinRatings(int minRatings) {
        return videoRecipeRepository.findByMinRatings(minRatings);
    }

    public List<VideoRecipeEntity> getRecipesByTotalRateBetween(int minRate, int maxRate) {
        return videoRecipeRepository.findByTotalRateBetween(minRate, maxRate);
    }

    public List<VideoRecipeEntity> getRecipesByDateBetween(LocalDate startDate, LocalDate endDate) {
        return videoRecipeRepository.findByDateBetween(startDate, endDate);
    }

    public List<VideoRecipeEntity> getLeastLikedRecipe() {
        return videoRecipeRepository.findLeastLikedRecipe();
    }

    public List<VideoRecipeEntity> getRecipesWithTitleContainingIgnoreCase(String keyword) {
        return videoRecipeRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public List<VideoRecipeEntity> getTopRatedRecipe() {
        return videoRecipeRepository.findTopRatedRecipe();
    }

    public List<VideoRecipeEntity> getRecipesCreatedToday() {
        return videoRecipeRepository.findRecipesCreatedToday();
    }

    public List<VideoRecipeEntity> getRecipesWithNoLikes() {
        return videoRecipeRepository.findRecipesWithNoLikes();
    }

    public List<VideoRecipeEntity> getLatestRecipe() {
        return videoRecipeRepository.findLatestRecipe();
    }


    public List<VideoRecipeEntity> getRecipesByChef(ChefEntity chef) {
        return videoRecipeRepository.findByChef(chef);
    }

    public List<VideoRecipeEntity> getRecipesByLink(String link) {
        return videoRecipeRepository.findByLink(link);
    }

    public List<VideoRecipeEntity> getRecipesByCategoryAndTotalRateBetween(
            VideoCategoriesEntity category, int minRate, int maxRate) {
        return videoRecipeRepository.findByCategoryAndTotalRateBetween(category, minRate, maxRate);
    }

    public List<VideoRecipeEntity> getLatestRecipeByChef() {
        return videoRecipeRepository.findLatestRecipeByChef();
    }

    public List<VideoRecipeEntity> getOldestRecipeByChef() {
        return videoRecipeRepository.findOldestRecipeByChef();
    }

    public List<VideoRecipeEntity> getLowestRatedRecipe() {
        return videoRecipeRepository.findLowestRatedRecipe();
    }

    public List<VideoRecipeEntity> getHighestRatedRecipe() {
        return videoRecipeRepository.findHighestRatedRecipe();
    }

    public List<VideoRecipeEntity> getUnratedRecipes() {
        return videoRecipeRepository.findUnratedRecipes();
    }

    //******* I still need for total rate update i think i should get average for userRating Service

}
