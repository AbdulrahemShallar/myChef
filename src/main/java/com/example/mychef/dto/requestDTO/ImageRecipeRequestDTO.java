package com.example.mychef.dto.requestDTO;

import com.example.mychef.model.ImageCategoriesEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ImageRecipeRequestDTO {
    private int id;
    private String title;
    private String picture;
    private String component;
    private String preparationMethod;
    private int totalRate;
    private LocalDate date;
    private int likes;
    private ImageCategoriesEntity category;
}
