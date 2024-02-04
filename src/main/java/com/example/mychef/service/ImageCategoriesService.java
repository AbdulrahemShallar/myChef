package com.example.mychef.service;


import com.example.mychef.model.ImageCategoriesEntity;
import com.example.mychef.repository.ImageCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageCategoriesService {
    
    private final ImageCategoriesRepository imageCategoriesRepository;

    public ImageCategoriesService(ImageCategoriesRepository imageCategoriesRepository) {
        this.imageCategoriesRepository = imageCategoriesRepository;
    }

    public ImageCategoriesEntity newCategory(ImageCategoriesEntity imageCategoriesEntity){
        return imageCategoriesRepository.save(imageCategoriesEntity);
    }

    public ImageCategoriesEntity updateCategory(ImageCategoriesEntity imageCategories,Integer id){
        ImageCategoriesEntity foundCategory = imageCategoriesRepository.findImageCategoriesEntityById(id);
        if(foundCategory != null){
            foundCategory.setName(imageCategories.getName());
            foundCategory.setPicture(imageCategories.getPicture());
            return  imageCategoriesRepository.save(foundCategory);
        }
        return null;
    }

    public ImageCategoriesEntity getImageCategoryById(int id){
        return imageCategoriesRepository.findImageCategoriesEntityById(id);
    }

    public List<ImageCategoriesEntity> getAllCategories(){
        return  imageCategoriesRepository.findAll();
    }

    public List<ImageCategoriesEntity> getCategoriesWithImageRecipes() {
        return imageCategoriesRepository.findCategoriesWithImageRecipes();
                
    }

    public List<ImageCategoriesEntity> getCategoriesByNameContaining(String keyword) {
        return imageCategoriesRepository.findByNameContaining(keyword);
                
    }

    public List<ImageCategoriesEntity> getCategoriesByPicture(String pictureUrl) {
        return imageCategoriesRepository.findByPicture(pictureUrl);
                
    }

    public List<ImageCategoriesEntity> getAllCategoriesOrderByNameAsc() {
        return imageCategoriesRepository.findAllByOrderByNameAsc();
                
    }

    public List<ImageCategoriesEntity> getAllCategoriesOrderByNameDesc() {
        return imageCategoriesRepository.findAllByOrderByNameDesc();
                
    }

    public List<ImageCategoriesEntity> getCategoriesWithMostImageRecipes() {
        return imageCategoriesRepository.findCategoriesWithMostImageRecipes();
                
    }

    public List<ImageCategoriesEntity> getCategoriesWithNoImageRecipes() {
        return imageCategoriesRepository.findCategoriesWithNoImageRecipes();
                
    }

    public List<ImageCategoriesEntity> getCategoriesWithImageRecipesAndPicture() {
        return imageCategoriesRepository.findCategoriesWithImageRecipesAndPicture();
                
    }

    public List<ImageCategoriesEntity> getCategoriesByExcludingName(String excludeKeyword) {
        return imageCategoriesRepository.findByExcludingName(excludeKeyword);
                
    }

    public List<ImageCategoriesEntity> getCategoriesByNameContainingOrderByImageRecipeCountDesc(String keyword) {
        return imageCategoriesRepository.findByNameContainingOrderByImageRecipeCountDesc(keyword);
                
    }

}
