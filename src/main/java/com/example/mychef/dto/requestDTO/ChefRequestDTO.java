package com.example.mychef.dto.requestDTO;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ChefRequestDTO {

    private int id;
    private String name;
    private String picture;
    private String about;
    @Column(name = "chef_rate")
    private int chefRate;
    @Column(name = "channel_link")
    private String channelLink;
}
