package com.example.mychef.convert;

import com.example.mychef.dto.requestDTO.ChefRequestDTO;
import com.example.mychef.dto.responseDTO.ChefResponseDTO;
import com.example.mychef.model.ChefEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ChefDTOConverter {
    private final ModelMapper modelMapper;

    public ChefDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ChefRequestDTO convertChefEntityToDTO(ChefEntity chefEntity){
        return  modelMapper.map(chefEntity, ChefRequestDTO.class);
    }

    public ChefEntity convertChefDTOToEntity(ChefResponseDTO chefResponseDTO){
        return  modelMapper.map(chefResponseDTO,ChefEntity.class);
    }
}
