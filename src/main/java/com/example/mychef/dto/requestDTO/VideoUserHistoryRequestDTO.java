package com.example.mychef.dto.requestDTO;

import com.example.mychef.model.UserEntity;
import com.example.mychef.model.VideoRecipeEntity;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.Instant;

@Data
public class VideoUserHistoryRequestDTO {

    private UserEntity user;
    private VideoRecipeEntity recipe;
    @Column(name = "date_time")
    private Instant dateTime;
}
