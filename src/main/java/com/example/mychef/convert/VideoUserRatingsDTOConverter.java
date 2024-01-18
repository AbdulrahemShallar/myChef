package com.example.mychef.convert;


import com.example.mychef.dto.VideoUserRatingsDTO;
import com.example.mychef.model.VideoUserRatingsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoUserRatingsDTOConverter {
    private final ModelMapper modelMapper;

    public VideoUserRatingsDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VideoUserRatingsDTO convertVideoUserRatingsEntityToDTO(VideoUserRatingsEntity videoUserRatingsEntity){
        return  modelMapper.map(videoUserRatingsEntity, VideoUserRatingsDTO.class);
    }

    public VideoUserRatingsEntity convertVideoUserRatingsDTOToEntity(VideoUserRatingsDTO videoUserRatingsDTO){
        return  modelMapper.map(videoUserRatingsDTO,VideoUserRatingsEntity.class);
    }

}
