package com.example.mychef.model;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.time.Instant;

@Entity(name = "video_user_ratings")
@Data
@IdClass(VideoUserRatingsEntity.class)
public class VideoUserRatingsEntity implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private VideoRecipeEntity recipe;

    private String comment;
    private int rate;
    @Column(name = "data_time")
    private Instant dataTime;
}
