package com.example.mychef.model;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.time.Instant;

@Entity(name = "image_user_ratings")
@Data
@IdClass(ImageUserRatingsEntity.class)
public class ImageUserRatingsEntity implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private ImageRecipeEntity recipe;

    private String comment;
    private int rate;
    private Instant dataTime;
}
