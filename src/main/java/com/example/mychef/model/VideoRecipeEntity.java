package com.example.mychef.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.Instant;
import java.util.Set;

@Entity(name = "video_recipe")
public class VideoRecipeEntity {

    @Getter
    @Setter
    @Id
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
    private int total_rate;

    @Getter
    @Setter
    private Instant data;

    @Getter
    @Setter
    private int likes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    private VideoCategoriesEntity category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chef_id")
    private ChefEntity chef;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<VideoUserHistoryEntity> videoUserHistoryEntitySet;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<VideoUserRatingsEntity> videoUserRatingsEntitySet;
}
