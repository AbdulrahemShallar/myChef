package com.example.mychef.service;

import com.example.mychef.convert.ChefDTOConverter;
import com.example.mychef.dto.ChefDTO;
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

    public ChefEntity newChef(ChefEntity chefEntity){
        return chefRepository.save(chefEntity);
    }

    public ChefEntity updateChef(ChefEntity chefEntity,Integer id){
        ChefEntity foundEntity = chefRepository.findChefEntityById(id);
        if(foundEntity != null){
            foundEntity.setName(chefEntity.getName());
            foundEntity.setAbout(chefEntity.getAbout());
            foundEntity.setPicture(chefEntity.getPicture());
            foundEntity.setChefRate(chefEntity.getChefRate());
            foundEntity.setChannel_link(chefEntity.getChannel_link());
            return  chefRepository.save(foundEntity);
        }
        return null;
    }

    public ChefDTO getChefById(int id){
        return chefDTOConverter.convertChefEntityToDTO(chefRepository.findChefEntityById(id));
    }

    public List<ChefDTO> getAllChef(){
        return chefRepository.findAll()
                .stream()
                .map(chefDTOConverter::convertChefEntityToDTO)
                .collect(Collectors.toList());
    }

}