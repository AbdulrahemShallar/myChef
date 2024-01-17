package com.example.mychef.repository;


import com.example.mychef.model.ImageRecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRecipeRepository extends JpaRepository<ImageRecipeEntity, Integer> {
    public ImageRecipeEntity findImageRecipeEntityById(int id);
}
