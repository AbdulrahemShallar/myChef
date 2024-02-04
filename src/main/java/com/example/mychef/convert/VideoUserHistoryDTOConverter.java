package com.example.mychef.convert;


import com.example.mychef.dto.responseDTO.VideoUserHistoryResponseDTO;
import com.example.mychef.dto.requestDTO.VideoUserHistoryRequestDTO;
import com.example.mychef.model.VideoUserHistoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

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

    public List<VideoUserHistoryRequestDTO> convertVideoUserHistoryEntityToDTO(List<VideoUserHistoryEntity> list){
        return list.stream()
                .map(entity -> modelMapper.map(entity, VideoUserHistoryRequestDTO.class))
                .collect(Collectors.toList());
    }

    public List<VideoUserHistoryEntity> convertVideoUserHistoryDTOToEntity(List<VideoUserHistoryResponseDTO> list) {
        return list.stream()
                .map(dto -> modelMapper.map(dto, VideoUserHistoryEntity.class))
                .collect(Collectors.toList());
    }

}
