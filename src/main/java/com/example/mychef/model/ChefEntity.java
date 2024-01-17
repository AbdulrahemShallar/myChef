package com.example.mychef.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity(name = "chef")
public class ChefEntity {

    @Id
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String picture;

    @Getter
    @Setter
    @Column(name = "chef_rate")
    private int chefRate;
    @Getter
    @Setter
    private String about;
    @Getter
    @Setter
    private String channel_link;

    @OneToMany(mappedBy = "chef", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<VideoRecipeEntity> videoRecipeEntitySet;
}
