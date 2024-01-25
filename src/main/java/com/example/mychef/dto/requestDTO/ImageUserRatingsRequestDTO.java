package com.example.mychef.dto.requestDTO;

import com.example.mychef.model.ImageRecipeEntity;
import com.example.mychef.model.UserEntity;
import lombok.Data;

import java.time.Instant;

@Data
public class ImageUserRatingsRequestDTO {
    private UserEntity user;
    private ImageRecipeEntity recipe;
    private String comment;
    private int rate;
    private Instant dataTime;
}
