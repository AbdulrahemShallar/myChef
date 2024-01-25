package com.example.mychef.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity(name = "chef")
@Data
public class ChefEntity {

    @Id
    private int id;
    private String name;
    private String picture;
    @Column(name = "chef_rate")
    private int chefRate;
    private String about;
    private String channel_link;

    @JsonBackReference
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "chef", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<VideoRecipeEntity> videoRecipeEntitySet;
}
