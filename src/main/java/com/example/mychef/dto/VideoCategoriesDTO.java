package com.example.mychef.dto;


import lombok.Data;

import java.util.Set;

@Data
public class VideoCategoriesDTO {
    private int id;
    private String name;
    private String picture;

//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<VideoRecipeEntity> videoRecipeEntitySet;
}
