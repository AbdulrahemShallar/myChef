package com.example.mychef.service;

import com.example.mychef.convert.ImageUserHistoryDTOConverter;
import com.example.mychef.dto.requestDTO.ImageUserHistoryRequestDTO;
import com.example.mychef.model.ImageUserHistoryEntity;
import com.example.mychef.repository.ImageUserHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageUserHistoryService {

    private final ImageUserHistoryDTOConverter imageUserHistoryDTOConverter;
    private final ImageUserHistoryRepository imageUserHistoryRepository;



    public ImageUserHistoryService(ImageUserHistoryDTOConverter imageUserHistoryDTOConverter,
                                   ImageUserHistoryRepository imageUserHistoryRepository) {
        this.imageUserHistoryDTOConverter = imageUserHistoryDTOConverter;
        this.imageUserHistoryRepository = imageUserHistoryRepository;
    }
//    public ImageUserHistoryEntity newUserHistory(ImageUserHistoryResponseDTO imageUserHistory){
//
//        ImageUserHistoryEntity entity = imageUserHistoryDTOConverter.convertImageUserHistoryDTOToEntity(imageUserHistory);
//
//        ImageRecipeEntity recipeDTO = imageRecipeRepository.findImageRecipeEntityById(imageUserHistory.getRecipeID());
//
//        UserEntity userDTO = userRepository.findUserEntityById(imageUserHistory.getUserID());
//
//
//        return imageUserHistoryRepository.save(entity);
//    }

    // I Should work here by found one element by to Integer ID ???????
//    public ImageUserHistoryEntity updateUserHistory(ImageUserHistoryResponseDTO imageUserHistory,Integer id){
//        ImageUserHistoryEntity foundEntity = imageUserHistoryRepository.
//    }

    public List<ImageUserHistoryRequestDTO> getUserHistoryByUserId(Integer userId){

        List<ImageUserHistoryEntity> entityList = imageUserHistoryRepository.findByUser(userId);
        if(entityList != null){
            return entityList.stream()
                    .map(imageUserHistoryDTOConverter::convertImageUserHistoryEntityToDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }
    public List<ImageUserHistoryRequestDTO> getUserHistoryByRecipeId(Integer recipeId){
        List<ImageUserHistoryEntity> entityList = imageUserHistoryRepository.findByRecipe(recipeId);
        if(entityList != null){

            return entityList.stream()
                    .map(imageUserHistoryDTOConverter::convertImageUserHistoryEntityToDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public ImageUserHistoryRequestDTO getUserHistoryById(Integer userId,Integer recipeId){

            ImageUserHistoryEntity entity = imageUserHistoryRepository.findByUserAndRecipe(userId,recipeId);
        if(entity != null){
            return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(entity);
        }
        return null;
    }

    public List<ImageUserHistoryRequestDTO> getAllUserHistory(){
        return imageUserHistoryRepository.findAll()
                .stream()
                .map(imageUserHistoryDTOConverter::convertImageUserHistoryEntityToDTO)
                .collect(Collectors.toList());
    }


    public List<ImageUserHistoryRequestDTO> getUserHistoryByUserAndDateRange(Integer userId, Date startDate, Date endDate) {
        return imageUserHistoryRepository.findByUserAndDateRange(userId, startDate, endDate)
                .stream()
                .map(imageUserHistoryDTOConverter::convertImageUserHistoryEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageUserHistoryRequestDTO> getHistoryByRecipeAndDateRange(Integer recipeId, Date startDate, Date endDate) {
        return imageUserHistoryRepository.findByRecipeAndDateRange(recipeId, startDate, endDate)
                .stream()
                .map(imageUserHistoryDTOConverter::convertImageUserHistoryEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageUserHistoryRequestDTO> getHistoryByDateRange(Date startDate, Date endDate) {
        return imageUserHistoryRepository.findByDateRange(startDate, endDate)
                .stream()
                .map(imageUserHistoryDTOConverter::convertImageUserHistoryEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageUserHistoryRequestDTO> getLatestRecords(int limit) {
        return imageUserHistoryRepository.findLatestRecords(limit)
                .stream()
                .map(imageUserHistoryDTOConverter::convertImageUserHistoryEntityToDTO)
                .collect(Collectors.toList());
    }

    public ImageUserHistoryRequestDTO getLatestHistoryForUserAndRecipe(Integer userId, Integer recipeId) {
        ImageUserHistoryEntity entity = imageUserHistoryRepository.findLatestHistoryForUserAndRecipe(userId, recipeId);
        if (entity != null) {
            return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(entity);
        }
        return null;
    }

    public List<ImageUserHistoryRequestDTO> getLatestHistoryRecords(int limit){
        return imageUserHistoryRepository.findLatestHistoryRecords(limit)
                .stream()
                .map(imageUserHistoryDTOConverter::convertImageUserHistoryEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ImageUserHistoryRequestDTO> getLatestHistoryForUser(Integer userId, int limit) {
        return imageUserHistoryRepository.findLatestHistoryForUser(userId, limit)
                .stream()
                .map(imageUserHistoryDTOConverter::convertImageUserHistoryEntityToDTO)
                .collect(Collectors.toList());
    }

}
