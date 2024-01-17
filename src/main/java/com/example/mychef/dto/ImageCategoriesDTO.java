package com.example.mychef.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ImageCategoriesDTO {
    private int id;
    private String name;
    private String picture;

//    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    private Set<ImageRecipeEntity> imageRecipeEntitySet;
}
