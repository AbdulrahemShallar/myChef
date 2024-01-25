package com.example.mychef.dto.requestDTO;

import com.example.mychef.model.ChefEntity;
import com.example.mychef.model.VideoCategoriesEntity;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VideoRecipeRequestDTO {

    private int id;
    private String title;
    private String picture;
    private String component;
    @Column(name = "preparation_method")
    private String preparationMethod;
    @Column(name = "total_rate")
    private int total_rate;
    private LocalDate date;
    private int likes;
    private String link;
    private VideoCategoriesEntity category;
    private ChefEntity chef;
}
