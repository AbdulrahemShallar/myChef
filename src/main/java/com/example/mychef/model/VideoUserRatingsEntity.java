package com.example.mychef.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.Instant;

@Entity(name = "video_user_ratings")
public class VideoUserRatingsEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private VideoRecipeEntity recipe;

    @Getter
    @Setter
    private String comment;

    @Getter
    @Setter
    private int rate;

    @Getter
    @Setter
    @Column(name = "data_time")
    private Instant dataTime;
}
