package com.example.mychef.convert;

import com.example.mychef.dto.ImageUserHistoryDTO;
import com.example.mychef.model.ImageUserHistoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageUserHistoryDTOConverter {
    private final ModelMapper modelMapper;

    public ImageUserHistoryDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageUserHistoryDTO convertImageUserHistoryEntityToDTO(ImageUserHistoryEntity imageUserHistoryEntity){
        return  modelMapper.map(imageUserHistoryEntity, ImageUserHistoryDTO.class);
    }

    public ImageUserHistoryEntity convertImageUserHistoryDTOToEntity(ImageUserHistoryDTO imageUserHistoryDTO){
        return  modelMapper.map(imageUserHistoryDTO,ImageUserHistoryEntity.class);
    }

}
