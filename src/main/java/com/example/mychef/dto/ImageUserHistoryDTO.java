package com.example.mychef.dto;


import jakarta.persistence.Column;
import lombok.Data;

import java.time.Instant;

@Data
public class ImageUserHistoryDTO {
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private UserEntity user;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "recipe_id", nullable = false)
//    private ImageRecipeEntity recipe;


    @Column(name = "date_time")
    private Instant dataTime;
}
