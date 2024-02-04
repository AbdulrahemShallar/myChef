package com.example.mychef.service;

import com.example.mychef.model.VideoCategoriesEntity;
import com.example.mychef.repository.VideoCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoCategoriesService {
    
    final
    VideoCategoriesRepository videoCategoriesRepository;

    public VideoCategoriesService(VideoCategoriesRepository videoCategoriesRepository) {
        this.videoCategoriesRepository = videoCategoriesRepository;
    }

    public VideoCategoriesEntity newCategory(VideoCategoriesEntity entity){
        return videoCategoriesRepository.save(entity);
    }

    public VideoCategoriesEntity updateCategory(VideoCategoriesEntity entity,Integer id){
        VideoCategoriesEntity foundCategory = videoCategoriesRepository.findVideoCategoriesEntityById(id);
        if(foundCategory != null){
            foundCategory.setName(entity.getName());
            foundCategory.setPicture(entity.getPicture());
            return  videoCategoriesRepository.save(foundCategory);
        }
        return null;
    }

    public VideoCategoriesEntity getVideoCategoriesById(int id){
        return videoCategoriesRepository.findVideoCategoriesEntityById(id);
    }

    public List<VideoCategoriesEntity> getAllCategories(){
        return  videoCategoriesRepository.findAll();
    }

    public List<VideoCategoriesEntity> getCategoriesWithVideoRecipes() {
        return videoCategoriesRepository.findCategoriesWithVideoRecipes();
    }

    public List<VideoCategoriesEntity> getCategoriesByNameContaining(String keyword) {
        return videoCategoriesRepository.findByNameContaining(keyword);
    }

    public List<VideoCategoriesEntity> getCategoriesByPicture(String pictureUrl) {
        return videoCategoriesRepository.findByPicture(pictureUrl);
    }

    public List<VideoCategoriesEntity> getAllCategoriesOrderByNameAsc() {
        return videoCategoriesRepository.findAllByOrderByNameAsc();
    }

    public List<VideoCategoriesEntity> getAllCategoriesOrderByNameDesc() {
        return videoCategoriesRepository.findAllByOrderByNameDesc();
    }

    public List<VideoCategoriesEntity> getCategoriesWithMostVideoRecipes() {
        return videoCategoriesRepository.findCategoriesWithMostVideoRecipes();
    }

    public List<VideoCategoriesEntity> getCategoriesWithNoVideoRecipes() {
        return videoCategoriesRepository.findCategoriesWithNoVideoRecipes();
    }

    public List<VideoCategoriesEntity> getCategoriesWithVideoRecipesAndPicture() {
        return videoCategoriesRepository.findCategoriesWithVideoRecipesAndPicture();
    }

    public List<VideoCategoriesEntity> getCategoriesByExcludingName(String excludeKeyword) {
        return videoCategoriesRepository.findByExcludingName(excludeKeyword);
    }

    public List<VideoCategoriesEntity> getCategoriesByNameContainingOrderByVideoRecipeCountDesc(String keyword) {
        return videoCategoriesRepository.findByNameContainingOrderByVideoRecipeCountDesc(keyword);
    }

}
