package com.example.mychef.dto;

import com.example.mychef.model.ImageCategoriesEntity;
import lombok.Data;

import java.util.Date;

@Data
public class ImageRecipeDTO {
    private int id;
    private String title;
    private String picture;
    private String component;
    private String preparationMethod;
    private int totalRate;
    private Date date;
    private int likes;
    private ImageCategoriesEntity category;
}
