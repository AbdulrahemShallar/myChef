package com.example.mychef.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.Instant;

@Entity(name = "image_user_history")
public class ImageUserHistoryEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private ImageRecipeEntity recipe;


    @Getter
    @Setter
    @Column(name = "date_time")
    private Instant dataTime;
}
