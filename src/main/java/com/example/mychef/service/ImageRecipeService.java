package com.example.mychef.service;


import com.example.mychef.convert.ImageRecipeDTOConverter;
import com.example.mychef.dto.requestDTO.ImageRecipeRequestDTO;
import com.example.mychef.dto.responseDTO.ImageRecipeResponseDTO;
import com.example.mychef.model.ImageCategoriesEntity;
import com.example.mychef.model.ImageRecipeEntity;
import com.example.mychef.repository.ImageRecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ImageRecipeService {

    final
    ImageRecipeDTOConverter imageRecipeDTOConverter;

    private final ImageRecipeRepository imageRecipeRepository;

    public ImageRecipeService(ImageRecipeDTOConverter imageRecipeDTOCOnverter, ImageRecipeRepository imageRecipeRepository) {
        this.imageRecipeDTOConverter = imageRecipeDTOCOnverter;
        this.imageRecipeRepository = imageRecipeRepository;
    }

    public ImageRecipeEntity newRecipe(ImageRecipeResponseDTO imageRecipeResponseDTO) {
        ImageRecipeEntity imageRecipeEntity = imageRecipeDTOConverter.convertImageRecipeDTOtoEntity(imageRecipeResponseDTO);

        ImageCategoriesEntity category = new ImageCategoriesEntity();
        category.setId(imageRecipeResponseDTO.getCategory_id());
        imageRecipeEntity.setCategory(category);

        return imageRecipeRepository.save(imageRecipeEntity);
    }

    public ImageRecipeEntity updateRecipe(ImageRecipeResponseDTO imageRecipeResponseDTO, Integer id) {
        ImageRecipeEntity foundRecipe = imageRecipeRepository.findImageRecipeEntityById(id);

        if (foundRecipe != null) {
            foundRecipe.setTitle(imageRecipeResponseDTO.getTitle());
            foundRecipe.setPicture(imageRecipeResponseDTO.getPicture());
            foundRecipe.setComponent(imageRecipeResponseDTO.getComponent());
            foundRecipe.setPreparationMethod(imageRecipeResponseDTO.getPreparationMethod());

            if(imageRecipeResponseDTO.getCategory_id() > 0)
                foundRecipe.setCategory(getCategory(imageRecipeResponseDTO));

            return imageRecipeRepository.save(foundRecipe);
        }
        return null;
    }

    public ImageRecipeEntity updateRecipeLikes(Integer id)
    {   ImageRecipeEntity foundRecipe = imageRecipeRepository.findImageRecipeEntityById(id);
        if(foundRecipe != null){
            foundRecipe.setLikes(1+foundRecipe.getLikes());
            return imageRecipeRepository.save(foundRecipe);
        }
        return null;
    }

    private ImageCategoriesEntity getCategory(ImageRecipeResponseDTO recipeResponseDTO){
        ImageCategoriesEntity category = new ImageCategoriesEntity();
        category.setId(recipeResponseDTO.getCategory_id());
        return  category;
    }


    public ImageRecipeRequestDTO getImageRecipe(int id) {

        ImageRecipeEntity imageRecipeEntity = imageRecipeRepository.findImageRecipeEntityById(id);
        // Check if the entity exists
        if (imageRecipeEntity == null) {
            // Handle the case where the entity with the provided id is not found
            // You might throw an exception or return null based on your requirements
            return null;
        }
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeEntity);
    }


    public List<ImageRecipeRequestDTO> getAllRecipe(){
        return imageRecipeRepository.findAll()
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesWithTitleContaining(String keyword) {
        return imageRecipeRepository.findByTitleContaining(keyword)
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesByCategory(ImageCategoriesEntity category) {
        return imageRecipeRepository.findByCategory(category)
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesByTotalRateGreaterThan(int rate) {
        return imageRecipeRepository.findByTotalRateGreaterThan(rate)
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesByLikesGreaterThan(int likes) {
        return imageRecipeRepository.findByLikesGreaterThan(likes)
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesByDateAfter(LocalDate date) {
        return imageRecipeRepository.findByDateAfter(date)
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesOrderByTotalRateDesc() {
        return imageRecipeRepository.findByOrderByTotalRateDesc()
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getMostLikedRecipe() {
        return imageRecipeRepository.findMostLikedRecipe()
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesByMinRatings(int minRatings) {
        return imageRecipeRepository.findByMinRatings(minRatings)
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesByTotalRateBetween(int minRate, int maxRate) {
        return imageRecipeRepository.findByTotalRateBetween(minRate, maxRate)
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesByDateBetween(LocalDate startDate, LocalDate endDate) {
        return imageRecipeRepository.findByDateBetween(startDate, endDate)
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getLeastLikedRecipe() {
        return imageRecipeRepository.findLeastLikedRecipe()
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesWithTitleContainingIgnoreCase(String keyword) {
        return imageRecipeRepository.findByTitleContainingIgnoreCase(keyword)
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getTopRatedRecipe() {
        return imageRecipeRepository.findTopRatedRecipe()
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesCreatedToday() {
        return imageRecipeRepository.findRecipesCreatedToday()
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getRecipesWithNoLikes() {
        return imageRecipeRepository.findRecipesWithNoLikes()
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageRecipeRequestDTO> getLatestRecipe() {
        return imageRecipeRepository.findLatestRecipe()
                .stream()
                .map(imageRecipeDTOConverter::convertImageRecipeEntityToDTO)
                .collect(Collectors.toList());
    }

    //******* i still need for total rate update i think i should get average for userRating Service
}
