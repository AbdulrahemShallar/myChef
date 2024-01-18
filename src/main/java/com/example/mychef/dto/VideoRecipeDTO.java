package com.example.mychef.dto;


import com.example.mychef.model.ChefEntity;
import com.example.mychef.model.VideoCategoriesEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
public class VideoRecipeDTO {

    private int id;
    private String title;
    private String picture;
    private String component;
    @Column(name = "preparation_method")
    private String preparationMethod;
    @Column(name = "total_rate")
    private int total_rate;
    private Instant data;
    private int likes;
    private VideoCategoriesEntity category;
    private ChefEntity chef;

}
