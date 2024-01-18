package com.example.mychef.service;

import com.example.mychef.convert.ImageCategoriesDTOConverter;
import com.example.mychef.dto.ImageCategoriesDTO;
import com.example.mychef.model.ImageCategoriesEntity;
import com.example.mychef.repository.ImageCategoriesRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageCategoriesService {
    final ImageCategoriesDTOConverter imageCategoriesDTOConverter;
    private final ImageCategoriesRepository imageCategoriesRepository;

    public ImageCategoriesService(ImageCategoriesDTOConverter imageCategoriesDTOConverter, ImageCategoriesRepository imageCategoriesRepository) {
        this.imageCategoriesDTOConverter = imageCategoriesDTOConverter;
        this.imageCategoriesRepository = imageCategoriesRepository;
    }

    public ImageCategoriesDTO getImageCategoryById(int id){
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesRepository.findById(id));
    }
}
