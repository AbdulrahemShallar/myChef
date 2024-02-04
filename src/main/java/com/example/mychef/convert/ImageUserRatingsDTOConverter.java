package com.example.mychef.convert;

import com.example.mychef.dto.requestDTO.ImageUserRatingsRequestDTO;
import com.example.mychef.dto.responseDTO.ImageUserRatingsResponseDTO;
import com.example.mychef.model.ImageUserRatingsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ImageUserRatingsRequestDTO> convertImageUserRatingsEntityToDTO(List<ImageUserRatingsEntity> list){
        return  list.stream()
                .map(entity -> modelMapper.map(entity, ImageUserRatingsRequestDTO.class))
                .collect(Collectors.toList());
    }

    public List<ImageUserRatingsEntity> convertImageUserRatingsDTOToEntity(List<ImageUserRatingsResponseDTO> list) {
        return list.stream()
                .map(dto -> modelMapper.map(dto, ImageUserRatingsEntity.class))
                .collect(Collectors.toList());
    }

}
