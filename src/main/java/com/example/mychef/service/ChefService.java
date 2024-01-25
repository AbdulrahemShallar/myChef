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
            foundEntity.setChannel_link(chefResponseDTO.getChannel_link());
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

    public List<ChefRequestDTO> getAllChef(){
        return chefRepository.findAll()
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }

}