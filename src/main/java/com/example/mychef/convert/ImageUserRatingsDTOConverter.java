package com.example.mychef.convert;

import com.example.mychef.dto.ImageUserRatingsDTO;
import com.example.mychef.model.ImageUserRatingsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageUserRatingsDTOConverter {

    private final ModelMapper modelMapper;

    public ImageUserRatingsDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageUserRatingsDTO convertImageUserRatingsEntityToDTO(ImageUserRatingsEntity imageUserRatingsEntity){
        return  modelMapper.map(imageUserRatingsEntity, ImageUserRatingsDTO.class);
    }

    public ImageUserRatingsEntity convertImageUserRatingsDTOToEntity(ImageUserRatingsDTO imageUserRatingsDTO)
    {
        return  modelMapper.map(imageUserRatingsDTO,ImageUserRatingsEntity.class);
    }

}
