package com.example.mychef.convert;


import com.example.mychef.dto.requestDTO.VideoUserRatingsRequestDTO;
import com.example.mychef.dto.responseDTO.VideoUserRatingsResponseDTO;
import com.example.mychef.model.VideoUserRatingsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<VideoUserRatingsRequestDTO> convertVideoUserRatingsEntityToDTO(List<VideoUserRatingsEntity> list){
        return list.stream()
                .map(entity -> modelMapper.map(entity, VideoUserRatingsRequestDTO.class))
                .collect(Collectors.toList());
    }

    public List<VideoUserRatingsEntity> convertVideoUserRatingsDTOToEntity(List<VideoUserRatingsResponseDTO> list) {
        return list.stream()
                .map(dto -> modelMapper.map(dto, VideoUserRatingsEntity.class))
                .collect(Collectors.toList());
    }

}
