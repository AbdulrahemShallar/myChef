package com.example.mychef.service;

import com.example.mychef.model.VideoUserHistoryEntity;
import com.example.mychef.repository.VideoUserHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VideoUserHistoryService {


    final
    VideoUserHistoryRepository videoUserHistoryRepository;

    public VideoUserHistoryService(VideoUserHistoryRepository videoUserHistoryRepository) {
        this.videoUserHistoryRepository = videoUserHistoryRepository;
    }

    public VideoUserHistoryEntity newUserHistory(VideoUserHistoryEntity videoUserHistory){
        return videoUserHistoryRepository.save(videoUserHistory);
    }

    // I Should work here by found one element by to Integer Id ???????
//    public VideoUserHistoryEntity updateUserHistory(VideoUserHistoryEntity videoUserHistory,Integer id){
//        VideoUserHistoryEntity foundEntity = videoUserHistoryRepository.
//    }


    public List<VideoUserHistoryEntity> getUserHistoryByUserId(Integer userId){
        return videoUserHistoryRepository.findByUser(userId);
    }
    public List<VideoUserHistoryEntity> getUserHistoryByRecipeId(Integer recipeId){
        return videoUserHistoryRepository.findByRecipe(recipeId);
    }

    public VideoUserHistoryEntity getUserHistoryById(Integer userId,Integer recipeId){
        return videoUserHistoryRepository.findByUserAndRecipe(userId,recipeId);
    }

    public List<VideoUserHistoryEntity> getAllUserHistory(){
        return videoUserHistoryRepository.findAll();
    }

    public List<VideoUserHistoryEntity> getUserHistoryByUserAndDateRange(Integer userId, Date startDate, Date endDate) {
        return videoUserHistoryRepository.findByUserAndDateRange(userId, startDate, endDate);
    }

    public List<VideoUserHistoryEntity> getHistoryByRecipeAndDateRange(Integer recipeId, Date startDate, Date endDate) {
        return videoUserHistoryRepository.findByRecipeAndDateRange(recipeId, startDate, endDate);
    }

    public List<VideoUserHistoryEntity> getHistoryByDateRange(Date startDate, Date endDate) {
        return videoUserHistoryRepository.findByDateRange(startDate, endDate);
    }

    public List<VideoUserHistoryEntity> getLatestRecords(int limit) {
        List<VideoUserHistoryEntity> entities = videoUserHistoryRepository.findLatestRecords();
        int minLimit = Math.min(entities.size(),limit);
        return entities.subList(0,minLimit);
    }

    public VideoUserHistoryEntity getLatestHistoryForUserAndRecipe(Integer userId, Integer recipeId) {
        return videoUserHistoryRepository.findLatestHistoryForUserAndRecipe(userId, recipeId);
    }

    public List<VideoUserHistoryEntity> getLatestHistoryRecords(int limit){
        List<VideoUserHistoryEntity> entities = videoUserHistoryRepository.findLatestHistoryRecords();
        int minLimit = Math.min(entities.size(),limit);
        return entities.subList(0,minLimit);
    }

    public List<VideoUserHistoryEntity> getLatestHistoryForUser(Integer userId, int limit) {
        List<VideoUserHistoryEntity> entities = videoUserHistoryRepository.findLatestHistoryForUser(userId);
        int minLimit = Math.min(entities.size(),limit);
        return entities.subList(0,minLimit);
    }
}
