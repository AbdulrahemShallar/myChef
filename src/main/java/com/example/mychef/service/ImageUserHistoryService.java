package com.example.mychef.service;

import com.example.mychef.convert.ImageUserHistoryDTOConverter;
import com.example.mychef.dto.ImageUserHistoryDTO;
import com.example.mychef.model.ImageUserHistoryEntity;
import com.example.mychef.repository.ImageUserHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageUserHistoryService {

    private final ImageUserHistoryDTOConverter imageUserHistoryDTOConverter;
    private final ImageUserHistoryRepository imageUserHistoryRepository;

    public ImageUserHistoryService(ImageUserHistoryDTOConverter imageUserHistoryDTOConverter, ImageUserHistoryRepository imageUserHistoryRepository) {
        this.imageUserHistoryDTOConverter = imageUserHistoryDTOConverter;
        this.imageUserHistoryRepository = imageUserHistoryRepository;
    }
    public ImageUserHistoryEntity newUserHistory(ImageUserHistoryEntity imageUserHistory){
        return imageUserHistoryRepository.save(imageUserHistory);
    }

    // I Should work here by found one element by to Integer Id ???????
//    public ImageUserHistoryEntity updateUserHistory(ImageUserHistoryEntity imageUserHistory,Integer id){
//        ImageUserHistoryEntity foundEntity = imageUserHistoryRepository.
//    }


    // I Should work here by found one element by to Integer Id ???????
//    public ImageUserHistoryDTO getUserHistoryById(Integer id){
//        return imageUserHistoryRepository.find
//    }

    public List<ImageUserHistoryDTO> getAllUserHistory(){
        return imageUserHistoryRepository.findAll()
                .stream()
                .map(imageUserHistoryDTOConverter::convertImageUserHistoryEntityToDTO)
                .collect(Collectors.toList());
    }

}
