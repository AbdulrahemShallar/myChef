package com.example.mychef.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "image_categories")
@Data
public class ImageCategoriesEntity {

    @Id
    private int id;
    private String name;
    private String picture;

    @JsonBackReference
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<ImageRecipeEntity> imageRecipeEntitySet;
}
