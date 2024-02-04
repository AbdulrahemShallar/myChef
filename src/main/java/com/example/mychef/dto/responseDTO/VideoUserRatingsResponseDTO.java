package com.example.mychef.dto.responseDTO;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
public class VideoUserRatingsResponseDTO {

    @Column(name = "user_id")
    private int userID;
    @Column(name = "recipe_id")
    private int recipeID;
    private String comment;
    private int rate;
    @Column(name = "date_time")
    private Instant dateTime;
}
