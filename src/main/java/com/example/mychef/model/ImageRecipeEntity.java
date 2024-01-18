package com.example.mychef.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity(name = "image_recipe")
@Data
public class ImageRecipeEntity {

    @Id
    private int id;
    private String title;
    private String picture;
    private String component;
    @Column(name = "preparation_method")
    private String preparationMethod;
    @Column(name = "total_rate")
    private int totalRate;
    private Date date;
    private int likes;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id")
    private ImageCategoriesEntity category;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<ImageUserHistoryEntity> imageUserHistoryEntitySet;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<ImageUserRatingsEntity> imageUserRatingsEntitySet;
}
