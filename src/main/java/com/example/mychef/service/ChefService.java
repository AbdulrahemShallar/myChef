package com.example.mychef.service;

import com.example.mychef.convert.ChefDTOConverter;
import com.example.mychef.dto.requestDTO.ChefRequestDTO;
import com.example.mychef.dto.responseDTO.ChefResponseDTO;
import com.example.mychef.model.ChefEntity;
import com.example.mychef.repository.ChefRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ChefService {

    final ChefDTOConverter chefDTOConverter;
    private final ChefRepository chefRepository;

    public ChefService(ChefDTOConverter chefDTOConverter, ChefRepository chefRepository) {
        this.chefDTOConverter = chefDTOConverter;
        this.chefRepository = chefRepository;
    }

    public ChefEntity newChef(ChefResponseDTO chefResponseDTO){
        return chefRepository.save(chefDTOConverter.convertChefDTOToEntity(chefResponseDTO));
    }

    public ChefEntity updateChef(ChefResponseDTO chefResponseDTO,Integer id){

        ChefEntity foundEntity = chefRepository.findChefEntityById(id);
        if(foundEntity != null){
            foundEntity.setName(chefResponseDTO.getName());
            foundEntity.setAbout(chefResponseDTO.getAbout());
            foundEntity.setPicture(chefResponseDTO.getPicture());
            foundEntity.setChannelLink(chefResponseDTO.getChannelLink());
            return  chefRepository.save(foundEntity);
        }
        return null;
    }

    public ChefRequestDTO getChefById(int id){
        ChefEntity chefEntity = chefRepository.findChefEntityById(id);

        // Check if the entity exists
        if (chefEntity == null) {
            // Handle the case where the entity with the provided id is not found
            // You might throw an exception or return null based on your requirements
            return null;
        }
        return chefDTOConverter.convertChefEntityToDTO(chefEntity);
    }
    public List<ChefRequestDTO> getChefsByName(String name) {
        return chefRepository.findByName(name.toUpperCase())
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ChefRequestDTO> getChefWithChannelLink(String link) {
        return chefRepository.findChefsWithChannelLink(link)
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ChefRequestDTO> getChefRateGreaterThan(int rate) {
        return chefRepository.findByChefRateGreaterThan(rate)
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ChefRequestDTO> getChefRateLessThan(int rate) {
        return chefRepository.findByChefRateLessThan(rate)
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }
    public List<ChefRequestDTO> getChefRateBetween(int minRate,int maxRate) {
        return chefRepository.findByChefRateBetween(minRate,maxRate)
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }
    public List<ChefRequestDTO> getAboutContaining(String keyword) {
        return chefRepository.findByAboutContainingIgnoreCase(keyword)
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ChefRequestDTO> getChefsByVideoRecipeTitle(String recipeTitle) {
        return chefRepository.findChefsByVideoRecipeTitle(recipeTitle)
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ChefRequestDTO> getOrderByChefRateDesc() {
        return chefRepository.findByOrderByChefRateDesc()
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ChefRequestDTO> getOrderByChefRateAsc() {
        return chefRepository.findByOrderByChefRateAsc()
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ChefRequestDTO> getPicture(String pictureUrl) {
        return chefRepository.findByPicture(pictureUrl)
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ChefRequestDTO> getAllChef(){
        return chefRepository.findAll()
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }

}