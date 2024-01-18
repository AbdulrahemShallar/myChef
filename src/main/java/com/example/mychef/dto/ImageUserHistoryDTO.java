package com.example.mychef.dto;


import com.example.mychef.model.ImageRecipeEntity;
import com.example.mychef.model.UserEntity;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.Instant;

@Data
public class ImageUserHistoryDTO {
    private UserEntity user;
    private ImageRecipeEntity recipe;
    @Column(name = "date_time")
    private Instant dataTime;
}
