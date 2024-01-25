package com.example.mychef.convert;


import com.example.mychef.dto.responseDTO.VideoRecipeResponseDTO;
import com.example.mychef.dto.requestDTO.VideoRecipeRequestDTO;
import com.example.mychef.model.VideoRecipeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoRecipeDTOConverter {

    private final ModelMapper modelMapper;

    public VideoRecipeDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VideoRecipeRequestDTO convertVideoRecipeEntityToDTO(VideoRecipeEntity videoRecipeEntity){
        return  modelMapper.map(videoRecipeEntity, VideoRecipeRequestDTO.class);
    }

    public VideoRecipeEntity convertVideoRecipeDTOToEntity(VideoRecipeResponseDTO videoRecipeResponseDTO){
        return  modelMapper.map(videoRecipeResponseDTO,VideoRecipeEntity.class);
    }

}
