package com.example.mychef.dto;

import com.example.mychef.model.ImageCategoriesEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

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

//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "category_id")
//    private ImageCategoriesEntity category;
//
//    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    private Set<ImageUserHistoryEntity> imageUserHistoryEntitySet;
//
//    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    private Set<ImageUserRatingsEntity> imageUserRatingsEntitySet;
}
