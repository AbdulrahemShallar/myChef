package com.example.mychef.service;

import com.example.mychef.convert.VideoCategoriesDTOConverter;
import com.example.mychef.dto.requestDTO.VideoCategoriesRequestDTO;
import com.example.mychef.dto.responseDTO.VideoCategoriesResponseDTO;
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

    public VideoCategoriesEntity newCategory(VideoCategoriesResponseDTO categoriesResponseDTO){
        return videoCategoriesRepository.save(videoCategoriesDTOConverter.convertVideoCategoriesDTOToEntity(categoriesResponseDTO));
    }

    public VideoCategoriesEntity updateCategory(VideoCategoriesResponseDTO videoCategories,Integer id){
        VideoCategoriesEntity foundCategory = videoCategoriesRepository.findVideoCategoriesEntityById(id);
        if(foundCategory != null){
            foundCategory.setName(videoCategories.getName());
            foundCategory.setPicture(videoCategories.getPicture());
            return  videoCategoriesRepository.save(foundCategory);
        }
        return null;
    }

    public VideoCategoriesRequestDTO getVideoCategoriesById(int id){
        return videoCategoriesDTOConverter.convertVideoCategoriesEntityToDTO(videoCategoriesRepository.findVideoCategoriesEntityById(id));
    }

    public List<VideoCategoriesRequestDTO> getAllCategories(){
        return  videoCategoriesRepository.findAll()
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoCategoriesRequestDTO> getCategoriesWithVideoRecipes() {
        return videoCategoriesRepository.findCategoriesWithVideoRecipes()
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoCategoriesRequestDTO> getCategoriesByNameContaining(String keyword) {
        return videoCategoriesRepository.findByNameContaining(keyword)
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoCategoriesRequestDTO> getCategoriesByPicture(String pictureUrl) {
        return videoCategoriesRepository.findByPicture(pictureUrl)
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoCategoriesRequestDTO> getAllCategoriesOrderByNameAsc() {
        return videoCategoriesRepository.findAllByOrderByNameAsc()
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoCategoriesRequestDTO> getAllCategoriesOrderByNameDesc() {
        return videoCategoriesRepository.findAllByOrderByNameDesc()
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoCategoriesRequestDTO> getCategoriesWithMostVideoRecipes() {
        return videoCategoriesRepository.findCategoriesWithMostVideoRecipes()
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoCategoriesRequestDTO> getCategoriesWithNoVideoRecipes() {
        return videoCategoriesRepository.findCategoriesWithNoVideoRecipes()
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoCategoriesRequestDTO> getCategoriesWithVideoRecipesAndPicture() {
        return videoCategoriesRepository.findCategoriesWithVideoRecipesAndPicture()
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoCategoriesRequestDTO> getCategoriesByExcludingName(String excludeKeyword) {
        return videoCategoriesRepository.findByExcludingName(excludeKeyword)
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<VideoCategoriesRequestDTO> getCategoriesByNameContainingOrderByVideoRecipeCountDesc(String keyword) {
        return videoCategoriesRepository.findByNameContainingOrderByVideoRecipeCountDesc(keyword)
                .stream()
                .map(videoCategoriesDTOConverter::convertVideoCategoriesEntityToDTO)
                .collect(Collectors.toList());
    }

}
