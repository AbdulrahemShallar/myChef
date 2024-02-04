package com.example.mychef.dto.responseDTO;



import jakarta.persistence.*;
import lombok.Data;

@Data
public class VideoRecipeResponseDTO {

    private int id;
    private String title;
    private String picture;
    private String component;
    @Column(name = "preparation_method")
    private String preparationMethod;
    private String link;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "chef_id")
    private int chefId;

}
