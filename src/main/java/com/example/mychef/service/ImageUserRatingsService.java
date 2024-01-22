package com.example.mychef.service;


import com.example.mychef.convert.ImageUserRatingsDTOConverter;
import com.example.mychef.dto.ImageUserRatingsDTO;
import com.example.mychef.model.ImageUserRatingsEntity;
import com.example.mychef.repository.ImageUserRatingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageUserRatingsService {
    final ImageUserRatingsDTOConverter imageUserRatingsDTOConverter;
    final
    ImageUserRatingsRepository imageUserRatingsRepository;

    public ImageUserRatingsService(ImageUserRatingsDTOConverter imageUserRatingsDTOConverter, ImageUserRatingsRepository imageUserRatingsRepository) {
        this.imageUserRatingsDTOConverter = imageUserRatingsDTOConverter;
        this.imageUserRatingsRepository = imageUserRatingsRepository;
    }

    public ImageUserRatingsEntity newUserRatings(ImageUserRatingsEntity imageUserRatings){
        return imageUserRatingsRepository.save(imageUserRatings);
    }

    // I Should work here by found one element by to Integer Id ???????
//    public ImageUserRatingsEntity updateUserRatings(ImageUserRatingsEntity imageUserRatings,Integer id){
//        ImageUserRatingsEntity foundEntity = imageUserRatingsRepository.
//    }


    // I Should work here by found one element by to Integer Id ???????
//    public ImageUserRatingsDTO getUserRatingsById(Integer id){
//        return imageUserRatingsRepository.find
//    }

    public List<ImageUserRatingsDTO> getAllUserUserRatings(){
        return imageUserRatingsRepository.findAll()
                .stream()
                .map(imageUserRatingsDTOConverter::convertImageUserRatingsEntityToDTO)
                .collect(Collectors.toList());
    }
}
