package com.example.mychef.dto.responseDTO;



import jakarta.persistence.Column;
import lombok.Data;



@Data
public class ImageUserHistoryResponseDTO {

    @Column(name = "user_id")
    private int userID;
    @Column(name = "recipe_id")
    private int recipeID;
}
