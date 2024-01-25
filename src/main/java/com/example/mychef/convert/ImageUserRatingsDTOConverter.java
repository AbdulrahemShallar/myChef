package com.example.mychef.convert;

import com.example.mychef.dto.requestDTO.ImageUserRatingsRequestDTO;
import com.example.mychef.dto.responseDTO.ImageUserRatingsResponseDTO;
import com.example.mychef.model.ImageUserRatingsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageUserRatingsDTOConverter {

    private final ModelMapper modelMapper;

    public ImageUserRatingsDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageUserRatingsRequestDTO convertImageUserRatingsEntityToDTO(ImageUserRatingsEntity imageUserRatingsEntity){
        return  modelMapper.map(imageUserRatingsEntity, ImageUserRatingsRequestDTO.class);
    }

    public ImageUserRatingsEntity convertImageUserRatingsDTOToEntity(ImageUserRatingsResponseDTO imageUserRatingsResponseDTO)
    {
        return  modelMapper.map(imageUserRatingsResponseDTO,ImageUserRatingsEntity.class);
    }

}
