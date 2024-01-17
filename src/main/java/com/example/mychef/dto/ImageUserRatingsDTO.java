package com.example.mychef.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ImageUserRatingsDTO {
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private UserEntity user;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "recipe_id", nullable = false)
//    private ImageRecipeEntity recipe;

    private String comment;
    private int rate;
    private Instant dataTime;
}
