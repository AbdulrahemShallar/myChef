package com.example.mychef.dto.responseDTO;


import lombok.Data;


@Data
public class UserResponseDTO {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private String picture;
}
