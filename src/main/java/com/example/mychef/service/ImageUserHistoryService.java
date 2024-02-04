package com.example.mychef.service;


import com.example.mychef.model.ImageUserHistoryEntity;
import com.example.mychef.repository.ImageUserHistoryRepository;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class ImageUserHistoryService {


    final ImageUserHistoryRepository imageUserHistoryRepository;



    public ImageUserHistoryService(ImageUserHistoryRepository imageUserHistoryRepository) {
        this.imageUserHistoryRepository = imageUserHistoryRepository;
    }
//    public ImageUserHistoryEntity newUserHistory(ImageUserHistoryEntity entity){
//
//        ImageRecipeEntity recipeDTO = imageRecipeRepository.findImageRecipeEntityById(imageUserHistory.getRecipeID());
//
//        UserEntity userDTO = userRepository.findUserEntityById(imageUserHistory.getUserID());
//
//
//        return imageUserHistoryRepository.save(entity);
//    }

//     I Should work here by found one element by to Integer ID ???????
//    public ImageUserHistoryEntity updateUserHistory(ImageUserHistoryEntity imageUserHistory,Integer id){
//        ImageUserHistoryEntity foundEntity = imageUserHistoryRepository.
//    }

    public List<ImageUserHistoryEntity> getUserHistoryByUserId(Integer userId){
        return imageUserHistoryRepository.findByUser(userId);
    }
    public List<ImageUserHistoryEntity> getUserHistoryByRecipeId(Integer recipeId){
        return imageUserHistoryRepository.findByRecipe(recipeId);
    }

    public ImageUserHistoryEntity getUserHistoryById(Integer userId,Integer recipeId){
        return imageUserHistoryRepository.findByUserAndRecipe(userId,recipeId);
    }

    public List<ImageUserHistoryEntity> getAllUserHistory(){
        return imageUserHistoryRepository.findAll();
    }


    public List<ImageUserHistoryEntity> getUserHistoryByUserAndDateRange(Integer userId, Date startDate, Date endDate) {
        return imageUserHistoryRepository.findByUserAndDateRange(userId, startDate, endDate);
    }

    public List<ImageUserHistoryEntity> getHistoryByRecipeAndDateRange(Integer recipeId, Date startDate, Date endDate) {
        return imageUserHistoryRepository.findByRecipeAndDateRange(recipeId, startDate, endDate);
    }

    public List<ImageUserHistoryEntity> getHistoryByDateRange(Date startDate, Date endDate) {
        return imageUserHistoryRepository.findByDateRange(startDate, endDate);
    }

    public List<ImageUserHistoryEntity> getLatestRecords(int limit) {
        List<ImageUserHistoryEntity> entities = imageUserHistoryRepository.findLatestRecords();
        int minLimit = Math.min(entities.size(),limit);
        return entities.subList(0,minLimit);
    }

    public ImageUserHistoryEntity getLatestHistoryForUserAndRecipe(Integer userId, Integer recipeId) {
        return imageUserHistoryRepository.findLatestHistoryForUserAndRecipe(userId, recipeId);
    }

    public List<ImageUserHistoryEntity> getLatestHistoryRecords(int limit){
        List<ImageUserHistoryEntity> entities = imageUserHistoryRepository.findLatestHistoryRecords();
        int minLimit = Math.min(entities.size(), limit);
        return entities.subList(0,minLimit);
    }

    public List<ImageUserHistoryEntity> getLatestHistoryForUser(Integer userId, int limit) {
       List<ImageUserHistoryEntity> entities =  imageUserHistoryRepository.findLatestHistoryForUser(userId);
        int minLimit = Math.min(entities.size(), limit);
        return entities.subList(0, minLimit);
        }

}
