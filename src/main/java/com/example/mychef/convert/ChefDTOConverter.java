package com.example.mychef.convert;

import com.example.mychef.dto.ChefDTO;
import com.example.mychef.model.ChefEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ChefDTOConverter {
    private final ModelMapper modelMapper;

    public ChefDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ChefDTO convertChefEntityToDTO(ChefEntity chefEntity){
        return  modelMapper.map(chefEntity, ChefDTO.class);
    }

    public ChefEntity convertChefDTOToEntity(ChefDTO chefDTO){
        return  modelMapper.map(chefDTO,ChefEntity.class);
    }
}
