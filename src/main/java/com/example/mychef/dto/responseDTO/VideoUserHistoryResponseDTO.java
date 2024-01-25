package com.example.mychef.dto.responseDTO;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
public class VideoUserHistoryResponseDTO {

    @Column(name = "user_id")
    private int userID;
    @Column(name = "recipe_id")
    private int recipeID;
    @Column(name = "date_time")
    private Instant dateTime;
}
