package com.example.mychef.service;

import com.example.mychef.convert.VideoUserHistoryDTOConverter;
import com.example.mychef.dto.requestDTO.VideoUserHistoryRequestDTO;
import com.example.mychef.dto.responseDTO.VideoUserHistoryResponseDTO;
import com.example.mychef.model.VideoUserHistoryEntity;
import com.example.mychef.repository.VideoUserHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoUserHistoryService {

    final
    VideoUserHistoryDTOConverter videoUserHistoryDTOConverter;
    final
    VideoUserHistoryRepository videoUserHistoryRepository;

    public VideoUserHistoryService(VideoUserHistoryDTOConverter videoUserHistoryDTOConverter, VideoUserHistoryRepository videoUserHistoryRepository) {
        this.videoUserHistoryDTOConverter = videoUserHistoryDTOConverter;
        this.videoUserHistoryRepository = videoUserHistoryRepository;
    }

    public VideoUserHistoryEntity newUserHistory(VideoUserHistoryResponseDTO videoUserHistory){
        return videoUserHistoryRepository.save(videoUserHistoryDTOConverter.convertVideoUserHistoryDTOToEntity(videoUserHistory));
    }

    // I Should work here by found one element by to Integer Id ???????
//    public VideoUserHistoryEntity updateUserHistory(VideoUserHistoryResponseDTO videoUserHistory,Integer id){
//        VideoUserHistoryEntity foundEntity = videoUserHistoryRepository.
//    }


    public List<VideoUserHistoryRequestDTO> getUserHistoryByUserId(Integer userId){

        List<VideoUserHistoryEntity> entityList = videoUserHistoryRepository.findByUser(userId);
        if(entityList != null){
            return entityList.stream()
                    .map(videoUserHistoryDTOConverter::convertVideoUserHistoryEntityToDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }
    public List<VideoUserHistoryRequestDTO> getUserHistoryByRecipeId(Integer recipeId){
        List<VideoUserHistoryEntity> entityList = videoUserHistoryRepository.findByRecipe(recipeId);
        if(entityList != null){

            return entityList.stream()
                    .map(videoUserHistoryDTOConverter::convertVideoUserHistoryEntityToDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public VideoUserHistoryRequestDTO getUserHistoryById(Integer userId,Integer recipeId){

        VideoUserHistoryEntity entity = videoUserHistoryRepository.findByUserAndRecipe(userId,recipeId);
        if(entity != null){
            return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(entity);
        }
        return null;
    }

    public List<VideoUserHistoryRequestDTO> getAllUserHistory(){
        return videoUserHistoryRepository.findAll()
                .stream()
                .map(videoUserHistoryDTOConverter::convertVideoUserHistoryEntityToDTO)
                .collect(Collectors.toList());
    }
}
