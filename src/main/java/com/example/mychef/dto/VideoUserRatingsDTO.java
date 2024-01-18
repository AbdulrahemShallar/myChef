package com.example.mychef.dto;


import com.example.mychef.model.UserEntity;
import com.example.mychef.model.VideoRecipeEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
public class VideoUserRatingsDTO {

    private UserEntity user;
    private VideoRecipeEntity recipe;
    private String comment;
    private int rate;
    @Column(name = "data_time")
    private Instant dataTime;
}
