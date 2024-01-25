package com.example.mychef.dto.responseDTO;


import lombok.Data;



@Data
public class ImageRecipeResponseDTO {

    private int id;
    private String title;
    private String picture;
    private String component;
    private String preparationMethod;
    private int category_id;
}
