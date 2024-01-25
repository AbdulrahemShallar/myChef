package com.example.mychef.convert;


import com.example.mychef.dto.requestDTO.VideoUserRatingsRequestDTO;
import com.example.mychef.dto.responseDTO.VideoUserRatingsResponseDTO;
import com.example.mychef.model.VideoUserRatingsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoUserRatingsDTOConverter {
    private final ModelMapper modelMapper;

    public VideoUserRatingsDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VideoUserRatingsRequestDTO convertVideoUserRatingsEntityToDTO(VideoUserRatingsEntity videoUserRatingsEntity){
        return  modelMapper.map(videoUserRatingsEntity, VideoUserRatingsRequestDTO.class);
    }

    public VideoUserRatingsEntity convertVideoUserRatingsDTOToEntity(VideoUserRatingsResponseDTO videoUserRatingsResponseDTO){
        return  modelMapper.map(videoUserRatingsResponseDTO,VideoUserRatingsEntity.class);
    }

}
