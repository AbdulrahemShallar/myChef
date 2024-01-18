package com.example.mychef.service;

import com.example.mychef.convert.ChefDTOConverter;
import com.example.mychef.dto.ChefDTO;
import com.example.mychef.repository.ChefRepository;
import org.springframework.stereotype.Service;


@Service
public class ChefService {

    final ChefDTOConverter chefDTOConverter;
    private final ChefRepository chefRepository;

    public ChefService(ChefDTOConverter chefDTOConverter, ChefRepository chefRepository) {
        this.chefDTOConverter = chefDTOConverter;
        this.chefRepository = chefRepository;
    }

    public ChefDTO getChefById(int id){
        return chefDTOConverter.convertChefEntityToDTO(chefRepository.findChefEntityById(id));
    }

}