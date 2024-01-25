package com.example.mychef.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.time.Instant;


@Entity(name = "video_user_history")
@Data
@IdClass(VideoUserHistoryEntity.class)
public class VideoUserHistoryEntity implements Serializable {

    @Id
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Id
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private VideoRecipeEntity recipe;


    @Column(name = "date_time")
    private Instant dateTime;
}
