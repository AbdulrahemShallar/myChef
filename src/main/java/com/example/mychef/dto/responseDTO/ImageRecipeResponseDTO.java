package com.example.mychef.dto.responseDTO;


import jakarta.persistence.Column;
import lombok.Data;



@Data
public class ImageRecipeResponseDTO {

    private int id;
    private String title;
    private String picture;
    private String component;
    @Column(name = "preparation_method")
    private String preparationMethod;
    @Column(name = "category_id")
    private int categoryId;
}
