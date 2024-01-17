package com.example.mychef.dto;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

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

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "category_id")
//    private VideoCategoriesEntity category;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "chef_id")
//    private ChefEntity chef;
//
//    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<VideoUserHistoryEntity> videoUserHistoryEntitySet;
//
//    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<VideoUserRatingsEntity> videoUserRatingsEntitySet;
}
