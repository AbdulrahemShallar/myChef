package com.example.mychef.dto;


import jakarta.persistence.Column;
import lombok.Data;


@Data
public class ChefDTO {

    private int id;
    private String name;
    private String picture;
    @Column(name = "chef_rate")
    private int chefRate;
    private String about;
    private String channel_link;
}
