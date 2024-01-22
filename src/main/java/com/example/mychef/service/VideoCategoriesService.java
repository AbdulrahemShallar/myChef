package com.example.mychef.service;

import com.example.mychef.convert.VideoCategoriesDTOConverter;
import com.example.mychef.dto.VideoCategoriesDTO;
import com.example.mychef.model.VideoCategoriesEntity;
import com.example.mychef.repository.VideoCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public VideoCategoriesEntity newCategory(VideoCategoriesEntity videoCategoriesEntity){
        return videoCategoriesRepository.save(videoCategoriesEntity);
    }

    public VideoCategoriesEntity updateCategory(VideoCategoriesEntity videoCategories,Integer id){
        VideoCategoriesEntity foundCategory = videoCategoriesRepository.findVideoCategoriesEntityById(id);
        if(foundCategory != null){
            foundCategory.setName(videoCategories.getName());
            foundCategory.setPicture(videoCategories.getPicture());
            return  videoCategoriesRepository.save(foundCategory);
        }
        return null;
    }

    public VideoCategoriesDTO getVideoCategoriesById(int id){
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesRepository.findVideoCategoriesEntityById(id));
    }

    public List<VideoCategoriesDTO> getAllCategories(){
        return  videoCategoriesRepository.findAll()
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

}
