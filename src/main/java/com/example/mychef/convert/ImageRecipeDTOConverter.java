package com.example.mychef.convert;


import com.example.mychef.dto.requestDTO.ImageRecipeRequestDTO;
import com.example.mychef.dto.responseDTO.ImageRecipeResponseDTO;
import com.example.mychef.model.ImageRecipeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImageRecipeDTOConverter {

    private final ModelMapper modelMapper;

    public ImageRecipeDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageRecipeRequestDTO convertImageRecipeEntityToDTO(ImageRecipeEntity imageRecipe){
        return  modelMapper.map(imageRecipe, ImageRecipeRequestDTO.class);
    }

    public ImageRecipeEntity convertImageRecipeDTOtoEntity(ImageRecipeResponseDTO imageRecipeResponseDTO){
        return  modelMapper.map(imageRecipeResponseDTO,ImageRecipeEntity.class);
    }

    public List<ImageRecipeRequestDTO> convertImageRecipeEntityToDTO(List<ImageRecipeEntity> list){
        return  list.stream()
                .map(entity -> modelMapper.map(entity,ImageRecipeRequestDTO.class))
                .collect(Collectors.toList());
    }

    public List<ImageRecipeEntity> convertImageRecipeDTOtoEntity(List<ImageRecipeResponseDTO> list){
        return list.stream()
                .map(dto -> modelMapper.map(dto,ImageRecipeEntity.class))
                .collect(Collectors.toList());
    }
}
