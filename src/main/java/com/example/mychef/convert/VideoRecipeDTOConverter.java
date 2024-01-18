package com.example.mychef.convert;


import com.example.mychef.dto.VideoRecipeDTO;
import com.example.mychef.model.VideoRecipeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoRecipeDTOConverter {

    private final ModelMapper modelMapper;

    public VideoRecipeDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VideoRecipeDTO convertVideoRecipeEntityToDTO(VideoRecipeEntity videoRecipeEntity){
        return  modelMapper.map(videoRecipeEntity, VideoRecipeDTO.class);
    }

    public VideoRecipeEntity convertVideoRecipeDTOToEntity(VideoRecipeDTO videoRecipeDTO){
        return  modelMapper.map(videoRecipeDTO,VideoRecipeEntity.class);
    }

}
