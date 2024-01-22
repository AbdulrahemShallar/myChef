package com.example.mychef.service;

import com.example.mychef.convert.VideoUserHistoryDTOConverter;
import com.example.mychef.dto.VideoUserHistoryDTO;
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

    public VideoUserHistoryEntity newUserHistory(VideoUserHistoryEntity videoUserHistory){
        return videoUserHistoryRepository.save(videoUserHistory);
    }

    // I Should work here by found one element by to Integer Id ???????
//    public VideoUserHistoryEntity updateUserHistory(VideoUserHistoryEntity videoUserHistory,Integer id){
//        VideoUserHistoryEntity foundEntity = videoUserHistoryRepository.
//    }


    // I Should work here by found one element by to Integer Id ???????
//    public VideoUserHistoryDTO getUserHistoryById(Integer id){
//        return videoUserHistoryRepository.find
//    }

    public List<VideoUserHistoryDTO> getAlluserUserHistory(){
        return videoUserHistoryRepository.findAll()
                .stream()
                .map(videoUserHistoryDTOConverter::convertVideoUserHistoryEntityToDTO)
                .collect(Collectors.toList());
    }
}
