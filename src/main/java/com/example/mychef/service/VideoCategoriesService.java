package com.example.mychef.service;

import com.example.mychef.convert.VideoCategoriesDTOConverter;
import com.example.mychef.dto.VideoCategoriesDTO;
import com.example.mychef.repository.VideoCategoriesRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoCategoriesService {

    final
    VideoCategoriesDTOConverter videoCategoriesDTOConverter;
    final
    VideoCategoriesRepository videoCategoriesRepository;

    public VideoCategoriesService(VideoCategoriesDTOConverter videoCategoriesDTOConverter, VideoCategoriesRepository videoCategoriesRepository) {
        this.videoCategoriesDTOConverter = videoCategoriesDTOConverter;
        this.videoCategoriesRepository = videoCategoriesRepository;
    }

    public VideoCategoriesDTO getVideoCategoriesById(int id){
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesRepository.findVideoCategoriesEntityById(id));
    }
}
