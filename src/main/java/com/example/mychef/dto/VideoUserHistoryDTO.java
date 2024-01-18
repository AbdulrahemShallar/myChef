package com.example.mychef.dto;

import com.example.mychef.model.UserEntity;
import com.example.mychef.model.VideoRecipeEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
public class VideoUserHistoryDTO {

    private UserEntity user;
    private VideoRecipeEntity recipe;
    @Column(name = "date_time")
    private Instant dateTime;
}
