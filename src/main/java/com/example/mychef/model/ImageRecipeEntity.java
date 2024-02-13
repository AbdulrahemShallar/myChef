package com.example.mychef.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity(name = "image_recipe")
@Data
public class ImageRecipeEntity {

    @Id
    private int id;
    private String title;
    private String picture;
    private String component;
    @Column(name = "preparation_method")
    private String preparationMethod;
    @Column(name = "total_rate")
    private int totalRate;
    private LocalDate date;
    private int likes;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    private ImageCategoriesEntity category;

    @JsonBackReference
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<ImageUserHistoryEntity> imageUserHistoryEntitySet;

    @JsonBackReference
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<ImageUserRatingsEntity> imageUserRatingsEntitySet;

    @PrePersist
    public void prePersist() {
        // Set the default value for date to the current date
        if (date == null) {
            date =  LocalDate.now();
        }
    }
}
