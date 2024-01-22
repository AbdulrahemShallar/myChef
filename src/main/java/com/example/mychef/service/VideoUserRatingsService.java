package com.example.mychef.service;


import com.example.mychef.convert.VideoUserRatingsDTOConverter;
import com.example.mychef.dto.VideoUserRatingsDTO;
import com.example.mychef.model.VideoUserRatingsEntity;
import com.example.mychef.repository.VideoUserRatingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoUserRatingsService {
    final
    VideoUserRatingsDTOConverter videoUserRatingsDTOConverter;
    final
    VideoUserRatingsRepository videoUserRatingsRepository;

    public VideoUserRatingsService(VideoUserRatingsDTOConverter videoUserRatingsDTOConverter, VideoUserRatingsRepository videoUserRatingsRepository) {
        this.videoUserRatingsDTOConverter = videoUserRatingsDTOConverter;
        this.videoUserRatingsRepository = videoUserRatingsRepository;
    }


    public VideoUserRatingsEntity newUserRatings(VideoUserRatingsEntity videoUserRatings){
        return videoUserRatingsRepository.save(videoUserRatings);
    }

    // I Should work here by found one element by to Integer Id ???????
//    public VideoUserRatingsEntity updateUserRatings(VideoUserRatingsEntity videoUserRatings,Integer id){
//        VideoUserRatingsEntity foundEntity = videoUserRatingsRepository.
//    }


    // I Should work here by found one element by to Integer Id ???????
//    public VideoUserRatingsDTO getUserRatingsById(Integer id){
//        return videoUserRatingsRepository.find
//    }

    public List<VideoUserRatingsDTO> getAllUserUserRatings(){
        return videoUserRatingsRepository.findAll()
                .stream()
                .map(videoUserRatingsDTOConverter::convertVideoUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }
}
