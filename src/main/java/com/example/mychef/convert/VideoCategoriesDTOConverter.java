package com.example.mychef.convert;

import com.example.mychef.dto.requestDTO.VideoCategoriesRequestDTO;
import com.example.mychef.dto.responseDTO.VideoCategoriesResponseDTO;
import com.example.mychef.model.VideoCategoriesEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VideoCategoriesDTOConverter {

    private final ModelMapper modelMapper;

    public VideoCategoriesDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VideoCategoriesRequestDTO convertVideoCategoriesEntityToDTO(VideoCategoriesEntity videoCategoriesEntity)
    {return  modelMapper.map(videoCategoriesEntity, VideoCategoriesRequestDTO.class);
    }

    public VideoCategoriesEntity convertVideoCategoriesDTOToEntity(VideoCategoriesResponseDTO videoCategoriesResponseDTO){
        return  modelMapper.map(videoCategoriesResponseDTO,VideoCategoriesEntity.class);
    }

    public List<VideoCategoriesRequestDTO> convertVideoCategoriesEntityToDTO(List<VideoCategoriesEntity> list){
       return  list.stream()
               .map(entity -> modelMapper.map(entity, VideoCategoriesRequestDTO.class))
               .collect(Collectors.toList());
    }

    public List<VideoCategoriesEntity> convertVideoCategoriesDTOToEntity(List<VideoCategoriesResponseDTO> list) {
        return list.stream()
                .map(dto -> modelMapper.map(dto, VideoCategoriesEntity.class))
                .collect(Collectors.toList());
    }

}
