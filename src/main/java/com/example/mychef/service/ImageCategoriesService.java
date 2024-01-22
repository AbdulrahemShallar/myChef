package com.example.mychef.service;

import com.example.mychef.convert.ImageCategoriesDTOConverter;
import com.example.mychef.dto.ImageCategoriesDTO;
import com.example.mychef.model.ImageCategoriesEntity;
import com.example.mychef.repository.ImageCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageCategoriesService {
    final ImageCategoriesDTOConverter imageCategoriesDTOConverter;
    private final ImageCategoriesRepository imageCategoriesRepository;

    public ImageCategoriesService(ImageCategoriesDTOConverter imageCategoriesDTOConverter, ImageCategoriesRepository imageCategoriesRepository) {
        this.imageCategoriesDTOConverter = imageCategoriesDTOConverter;
        this.imageCategoriesRepository = imageCategoriesRepository;
    }

    public ImageCategoriesEntity newCategory(ImageCategoriesEntity imageCategoriesEntity){
        return imageCategoriesRepository.save(imageCategoriesEntity);
    }

    public ImageCategoriesEntity updateCategory(ImageCategoriesEntity imageCategories,Integer id){
        ImageCategoriesEntity foundCategory = imageCategoriesRepository.findImageCategoriesEntityById(id);
        if(foundCategory != null){
            foundCategory.setName(imageCategories.getName());
            foundCategory.setPicture(imageCategories.getPicture());
            return  imageCategoriesRepository.save(foundCategory);
        }
        return null;
    }

    public ImageCategoriesDTO getImageCategoryById(int id){
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesRepository.findImageCategoriesEntityById(id));
    }

    public List<ImageCategoriesDTO> getAllCategories(){
        return  imageCategoriesRepository.findAll()
                .stream()
                .map(imageCategoriesDTOConverter::convertImageCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }
}
