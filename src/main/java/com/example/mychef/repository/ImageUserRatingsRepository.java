package com.example.mychef.repository;

import com.example.mychef.model.ImageUserRatingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageUserRatingsRepository extends JpaRepository<ImageUserRatingsEntity,ImageUserRatingsEntity> {

    @Query(value = "SELECT * FROM image_user_ratings WHERE user_id = (" +
            "SELECT id from app_user WHERE id = :userId) AND recipe_id = (" +
            "SELECT id from image_recipe WHERE id = :recipeId)", nativeQuery = true)
    ImageUserRatingsEntity findByUserAndRecipe(@Param("userId") int userId, @Param("recipeId") int recipeId);

    @Query(value = "SELECT * FROM image_user_ratings WHERE user_id = (" +
            "SELECT id from app_user WHERE id = :userId)", nativeQuery = true)
    List<ImageUserRatingsEntity> findByUser(@Param("userId") int userId);

    @Query(value = "SELECT * FROM image_user_ratings WHERE recipe_id = (" +
            "SELECT id from image_recipe WHERE id = :recipeId)", nativeQuery = true)
    List<ImageUserRatingsEntity> findByRecipe(@Param("recipeId") int recipeId);

}
