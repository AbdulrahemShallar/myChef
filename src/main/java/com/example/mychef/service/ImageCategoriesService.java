package com.example.mychef.service;

import com.example.mychef.convert.ImageCategoriesDTOConverter;
import com.example.mychef.dto.responseDTO.ImageCategoriesResponseDTO;
import com.example.mychef.dto.requestDTO.ImageCategoriesRequestDTO;
import com.example.mychef.model.ImageCategoriesEntity;
import com.example.mychef.repository.ImageCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageCategoriesService {
    final ImageCategoriesDTOConverter imageCategoriesDTOConverter;
    private final ImageCategoriesRepository imageCategoriesRepository;

    public ImageCategoriesService(ImageCategoriesDTOConverter imageCategoriesDTOConverter, ImageCategoriesRepository imageCategoriesRepository) {
        this.imageCategoriesDTOConverter = imageCategoriesDTOConverter;
        this.imageCategoriesRepository = imageCategoriesRepository;
    }

    public ImageCategoriesEntity newCategory(ImageCategoriesResponseDTO imageCategoriesResponseDTO){
        return imageCategoriesRepository.save(imageCategoriesDTOConverter.convertImageCategoriesDTOToDEntity(imageCategoriesResponseDTO));
    }

    public ImageCategoriesEntity updateCategory(ImageCategoriesResponseDTO imageCategories,Integer id){
        ImageCategoriesEntity foundCategory = imageCategoriesRepository.findImageCategoriesEntityById(id);
        if(foundCategory != null){
            foundCategory.setName(imageCategories.getName());
            foundCategory.setPicture(imageCategories.getPicture());
            return  imageCategoriesRepository.save(foundCategory);
        }
        return null;
    }

    public ImageCategoriesRequestDTO getImageCategoryById(int id){
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesRepository.findImageCategoriesEntityById(id));
    }

    public List<ImageCategoriesRequestDTO> getAllCategories(){
        return  imageCategoriesRepository.findAll()
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageCategoriesRequestDTO> getCategoriesWithImageRecipes() {
        return imageCategoriesRepository.findCategoriesWithImageRecipes()
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageCategoriesRequestDTO> getCategoriesByNameContaining(String keyword) {
        return imageCategoriesRepository.findByNameContaining(keyword)
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageCategoriesRequestDTO> getCategoriesByPicture(String pictureUrl) {
        return imageCategoriesRepository.findByPicture(pictureUrl)
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageCategoriesRequestDTO> getAllCategoriesOrderByNameAsc() {
        return imageCategoriesRepository.findAllByOrderByNameAsc()
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageCategoriesRequestDTO> getAllCategoriesOrderByNameDesc() {
        return imageCategoriesRepository.findAllByOrderByNameDesc()
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageCategoriesRequestDTO> getCategoriesWithMostImageRecipes() {
        return imageCategoriesRepository.findCategoriesWithMostImageRecipes()
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageCategoriesRequestDTO> getCategoriesWithNoImageRecipes() {
        return imageCategoriesRepository.findCategoriesWithNoImageRecipes()
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageCategoriesRequestDTO> getCategoriesWithImageRecipesAndPicture() {
        return imageCategoriesRepository.findCategoriesWithImageRecipesAndPicture()
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageCategoriesRequestDTO> getCategoriesByExcludingName(String excludeKeyword) {
        return imageCategoriesRepository.findByExcludingName(excludeKeyword)
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageCategoriesRequestDTO> getCategoriesByNameContainingOrderByImageRecipeCountDesc(String keyword) {
        return imageCategoriesRepository.findByNameContainingOrderByImageRecipeCountDesc(keyword)
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

}
