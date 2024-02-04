package com.example.mychef.convert;

import com.example.mychef.dto.requestDTO.ImageUserHistoryRequestDTO;
import com.example.mychef.dto.responseDTO.ImageUserHistoryResponseDTO;
import com.example.mychef.model.ImageUserHistoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImageUserHistoryDTOConverter {
    private final ModelMapper modelMapper;

    public ImageUserHistoryDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageUserHistoryRequestDTO convertImageUserHistoryEntityToDTO(ImageUserHistoryEntity imageUserHistoryEntity){
        return  modelMapper.map(imageUserHistoryEntity, ImageUserHistoryRequestDTO.class);
    }

    public ImageUserHistoryEntity convertImageUserHistoryDTOToEntity(ImageUserHistoryResponseDTO imageUserHistoryResponseDTO){
        return  modelMapper.map(imageUserHistoryResponseDTO,ImageUserHistoryEntity.class);
    }

    public List<ImageUserHistoryRequestDTO> convertImageUserHistoryEntityToDTO(List<ImageUserHistoryEntity> list){
        return  list.stream()
                .map(entity -> modelMapper.map(entity, ImageUserHistoryRequestDTO.class))
                .collect(Collectors.toList());
    }

    public List<ImageUserHistoryEntity> convertImageUserHistoryDTOToEntity(List<ImageUserHistoryResponseDTO> list) {
        return list.stream()
                .map(dto -> modelMapper.map(dto, ImageUserHistoryEntity.class))
                .collect(Collectors.toList());
    }

}
