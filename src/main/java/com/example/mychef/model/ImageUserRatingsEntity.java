package com.example.mychef.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.time.Instant;

@Entity(name = "image_user_ratings")
@Data
@IdClass(ImageUserRatingsEntity.class)
public class ImageUserRatingsEntity implements Serializable {

    @Id
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Id
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private ImageRecipeEntity recipe;

    private String comment;
    private int rate;
    private Instant dataTime;
}
