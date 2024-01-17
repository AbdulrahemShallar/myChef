package com.example.mychef.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;


@Entity(name = "app_user")
public class UserEntity {

    @Id
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String picture;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<ImageUserHistoryEntity> imageUserHistorySet;
}
