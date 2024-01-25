package com.example.mychef.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;

@Entity(name = "image_user_history")
@Data
@IdClass(ImageUserHistoryEntity.class)
public class ImageUserHistoryEntity implements Serializable {

    @Id
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Id
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private ImageRecipeEntity recipe;

    @Column(name = "date_time")
    private Date dateTime;

    @PrePersist
    public void prePersist() {
        // Set the default value for date to the current date
        if (dateTime == null) {
            dateTime =new Date();
        }
    }
}
