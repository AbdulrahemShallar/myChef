package com.example.mychef.dto.responseDTO;


import jakarta.persistence.Column;
import lombok.Data;


@Data
public class ChefResponseDTO {

    private int id;
    private String name;
    private String picture;
    private String about;
    @Column(name = "channel_link")
    private String channelLink;
}
