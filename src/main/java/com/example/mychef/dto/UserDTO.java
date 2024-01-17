package com.example.mychef.dto;


import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private String picture;

    // I think this one are not mandatory ??????
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<ImageUserHistoryEntity> imageUserHistorySet;
}
