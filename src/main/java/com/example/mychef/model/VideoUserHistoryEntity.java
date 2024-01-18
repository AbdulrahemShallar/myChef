package com.example.mychef.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.time.Instant;


@Entity(name = "video_user_history")
@Data
@IdClass(VideoUserHistoryEntity.class)
public class VideoUserHistoryEntity implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private VideoRecipeEntity recipe;


    @Column(name = "date_time")
    private Instant dateTime;
}
