package com.example.mychef.convert;


import com.example.mychef.dto.VideoUserHistoryDTO;
import com.example.mychef.model.VideoUserHistoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoUserHistoryDTOConverter {

    private final ModelMapper modelMapper;

    public VideoUserHistoryDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VideoUserHistoryDTO convertVideoUserHistoryEntityToDTO(VideoUserHistoryEntity videoUserHistoryEntity){
        return  modelMapper.map(videoUserHistoryEntity, VideoUserHistoryDTO.class);
    }

    public VideoUserHistoryEntity convertVideoUserHistoryDTOToEntity(VideoUserHistoryDTO videoUserHistoryDTO){
        return  modelMapper.map(videoUserHistoryDTO,VideoUserHistoryEntity.class);
    }

}
