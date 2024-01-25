package com.example.mychef.dto.requestDTO;

import com.example.mychef.model.ImageRecipeEntity;
import com.example.mychef.model.UserEntity;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class ImageUserHistoryRequestDTO {

    private UserEntity user;
    private ImageRecipeEntity recipe;
    @Column(name = "date_time")
    private Date dateTime;
}
