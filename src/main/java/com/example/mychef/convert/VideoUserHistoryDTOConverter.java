package com.example.mychef.convert;


import com.example.mychef.dto.responseDTO.VideoUserHistoryResponseDTO;
import com.example.mychef.dto.requestDTO.VideoUserHistoryRequestDTO;
import com.example.mychef.model.VideoUserHistoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoUserHistoryDTOConverter {

    private final ModelMapper modelMapper;

    public VideoUserHistoryDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VideoUserHistoryRequestDTO convertVideoUserHistoryEntityToDTO(VideoUserHistoryEntity videoUserHistoryEntity){
        return  modelMapper.map(videoUserHistoryEntity, VideoUserHistoryRequestDTO.class);
    }

    public VideoUserHistoryEntity convertVideoUserHistoryDTOToEntity(VideoUserHistoryResponseDTO videoUserHistoryResponseDTO){
        return  modelMapper.map(videoUserHistoryResponseDTO,VideoUserHistoryEntity.class);
    }

}
