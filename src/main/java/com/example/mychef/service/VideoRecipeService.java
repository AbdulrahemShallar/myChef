package com.example.mychef.service;


import com.example.mychef.convert.VideoRecipeDTOConverter;
import com.example.mychef.dto.requestDTO.VideoRecipeRequestDTO;
import com.example.mychef.dto.responseDTO.VideoRecipeResponseDTO;
import com.example.mychef.model.*;
import com.example.mychef.repository.VideoRecipeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<VideoRecipeRequestDTO> getRecipesWithTitleContaining(String keyword) {
        return videoRecipeRepository.findByTitleContaining(keyword)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesByCategory(VideoCategoriesEntity category) {
        return videoRecipeRepository.findByCategory(category)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesByTotalRateGreaterThan(int rate) {
        return videoRecipeRepository.findByTotalRateGreaterThan(rate)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesByLikesGreaterThan(int likes) {
        return videoRecipeRepository.findByLikesGreaterThan(likes)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesByDateAfter(LocalDate date) {
        return videoRecipeRepository.findByDateAfter(date)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesOrderByTotalRateDesc() {
        return videoRecipeRepository.findByOrderByTotalRateDesc()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getMostLikedRecipe() {
        return videoRecipeRepository.findMostLikedRecipe()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesByMinRatings(int minRatings) {
        return videoRecipeRepository.findByMinRatings(minRatings)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesByTotalRateBetween(int minRate, int maxRate) {
        return videoRecipeRepository.findByTotalRateBetween(minRate, maxRate)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesByDateBetween(LocalDate startDate, LocalDate endDate) {
        return videoRecipeRepository.findByDateBetween(startDate, endDate)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getLeastLikedRecipe() {
        return videoRecipeRepository.findLeastLikedRecipe()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesWithTitleContainingIgnoreCase(String keyword) {
        return videoRecipeRepository.findByTitleContainingIgnoreCase(keyword)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getTopRatedRecipe() {
        return videoRecipeRepository.findTopRatedRecipe()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesCreatedToday() {
        return videoRecipeRepository.findRecipesCreatedToday()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesWithNoLikes() {
        return videoRecipeRepository.findRecipesWithNoLikes()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getLatestRecipe() {
        return videoRecipeRepository.findLatestRecipe()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }
    ///********************************************

    public List<VideoRecipeRequestDTO> getRecipesByChef(ChefEntity chef) {
        return videoRecipeRepository.findByChef(chef)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesByLink(String link) {
        return videoRecipeRepository.findByLink(link)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getRecipesByCategoryAndTotalRateBetween(
            VideoCategoriesEntity category, int minRate, int maxRate) {
        return videoRecipeRepository.findByCategoryAndTotalRateBetween(category, minRate, maxRate)
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getLatestRecipeByChef() {
        return videoRecipeRepository.findLatestRecipeByChef()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getOldestRecipeByChef() {
        return videoRecipeRepository.findOldestRecipeByChef()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getLowestRatedRecipe() {
        return videoRecipeRepository.findLowestRatedRecipe()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getHighestRatedRecipe() {
        return videoRecipeRepository.findHighestRatedRecipe()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoRecipeRequestDTO> getUnratedRecipes() {
        return videoRecipeRepository.findUnratedRecipes()
                .stream()
                .map(videoRecipeDTOConverter::convertVideoRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    //******* I still need for total rate update i think i should get average for userRating Service

}
