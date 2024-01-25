package com.example.mychef.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;


@Entity(name = "app_user")
@Data
public class UserEntity {

    @Id
    private int id;
    private String name;
    private String email;
    private String picture;
    private String password;

    @JsonBackReference
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<ImageUserHistoryEntity> imageUserHistorySet;

    @JsonBackReference
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<ImageUserRatingsEntity> imageUserRatingsEntitySet;

    @JsonBackReference
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<VideoUserHistoryEntity> videoUserHistoryEntitySet;

    @JsonBackReference
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<VideoUserRatingsEntity> videoUserRatingsEntitySet;
}
