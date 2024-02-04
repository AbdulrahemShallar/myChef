package com.example.mychef.service;


import com.example.mychef.model.ChefEntity;
import com.example.mychef.repository.ChefRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChefService {


    private final ChefRepository chefRepository;

    public ChefService(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }

    public ChefEntity newChef(ChefEntity chefEntity){
        return chefRepository.save(chefEntity);
    }

    public ChefEntity updateChef(ChefEntity chefEntity,Integer id){

        ChefEntity foundEntity = chefRepository.findChefEntityById(id);
        if(foundEntity != null){
            foundEntity.setName(chefEntity.getName());
            foundEntity.setAbout(chefEntity.getAbout());
            foundEntity.setPicture(chefEntity.getPicture());
            foundEntity.setChannelLink(chefEntity.getChannelLink());
            return  chefRepository.save(foundEntity);
        }
        return null;
    }

    public ChefEntity getChefById(int id){
       return chefRepository.findChefEntityById(id);
    }
    public List<ChefEntity> getChefsByName(String name) {
        return chefRepository.findByName(name.toUpperCase());
    }

    public List<ChefEntity> getChefWithChannelLink(String link) {
        return chefRepository.findChefsWithChannelLink(link);
    }

    public List<ChefEntity> getChefRateGreaterThan(int rate) {
        return chefRepository.findByChefRateGreaterThan(rate);
    }

    public List<ChefEntity> getChefRateLessThan(int rate) {
        return chefRepository.findByChefRateLessThan(rate);
    }
    public List<ChefEntity> getChefRateBetween(int minRate,int maxRate) {
        return chefRepository.findByChefRateBetween(minRate,maxRate);
    }
    public List<ChefEntity> getAboutContaining(String keyword) {
        return chefRepository.findByAboutContainingIgnoreCase(keyword);
    }

    public List<ChefEntity> getChefsByVideoRecipeTitle(String recipeTitle) {
        return chefRepository.findChefsByVideoRecipeTitle(recipeTitle);
    }

    public List<ChefEntity> getOrderByChefRateDesc() {
        return chefRepository.findByOrderByChefRateDesc();
    }

    public List<ChefEntity> getOrderByChefRateAsc() {
        return chefRepository.findByOrderByChefRateAsc();
    }

    public List<ChefEntity> getPicture(String pictureUrl) {
        return chefRepository.findByPicture(pictureUrl);
    }

    public List<ChefEntity> getAllChef(){
        return chefRepository.findAll();
    }

}