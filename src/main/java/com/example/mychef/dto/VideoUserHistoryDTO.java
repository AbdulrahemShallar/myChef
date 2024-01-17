package com.example.mychef.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
public class VideoUserHistoryDTO {
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private UserEntity user;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "recipe_id", nullable = false)
//    private VideoRecipeEntity recipe;

    @Column(name = "date_time")
    private Instant dateTime;
}
