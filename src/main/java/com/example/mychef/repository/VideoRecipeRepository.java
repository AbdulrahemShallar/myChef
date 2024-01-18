package com.example.mychef.repository;

import com.example.mychef.model.VideoRecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRecipeRepository extends JpaRepository<VideoRecipeEntity,Integer> {

    public VideoRecipeEntity findVideoRecipeEntityById(int id);
}
