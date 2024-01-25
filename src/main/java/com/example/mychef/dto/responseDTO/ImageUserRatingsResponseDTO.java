package com.example.mychef.dto.responseDTO;

import jakarta.persistence.Column;
import lombok.Data;


import java.time.Instant;

@Data
public class ImageUserRatingsResponseDTO {
    @Column(name = "user_id")
    private int userID;
    @Column(name = "recipe_id")
    private int recipeID;
    private String comment;
    private int rate;
    private Instant dataTime;
}
