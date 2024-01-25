package com.example.mychef.convert;

import com.example.mychef.dto.requestDTO.ImageUserHistoryRequestDTO;
import com.example.mychef.dto.responseDTO.ImageUserHistoryResponseDTO;
import com.example.mychef.model.ImageUserHistoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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

}
