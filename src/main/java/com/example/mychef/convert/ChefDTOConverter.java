package com.example.mychef.convert;

import com.example.mychef.dto.requestDTO.ChefRequestDTO;
import com.example.mychef.dto.responseDTO.ChefResponseDTO;
import com.example.mychef.model.ChefEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ChefRequestDTO> convertChefEntityToDTO(List<ChefEntity> list) {
        return list.stream()
                .map(entity -> modelMapper.map(entity, ChefRequestDTO.class))
                .collect(Collectors.toList());
    }


    public List<ChefEntity> convertChefDTOToEntity(List<ChefResponseDTO> list) {
        return list.stream()
                .map(dto -> modelMapper.map(dto, ChefEntity.class))
                .collect(Collectors.toList());
    }
}
