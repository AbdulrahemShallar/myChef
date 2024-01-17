package com.example.mychef.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "image_categories")

public class ImageCategoriesEntity {
    @Getter
    @Setter
    @Id
    private int id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String picture;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<ImageRecipeEntity> imageRecipeEntitySet;
}
