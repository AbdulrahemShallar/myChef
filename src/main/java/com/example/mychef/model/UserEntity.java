package com.example.mychef.model;

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

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<ImageUserHistoryEntity> imageUserHistorySet;
}
