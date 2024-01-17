package com.example.mychef.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity(name = "image_recipe")
public class ImageRecipeEntity {

    @Id
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String picture;

    @Getter
    @Setter
    private String component;

    @Getter
    @Setter
    @Column(name = "preparation_method")
    private String preparationMethod;

    @Getter
    @Setter
    @Column(name = "total_rate")
    private int totalRate;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private int likes;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id")
    private ImageCategoriesEntity category;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<ImageUserHistoryEntity> imageUserHistoryEntitySet;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<ImageUserRatingsEntity> imageUserRatingsEntitySet;
}
