package com.example.mychef.repository;

import com.example.mychef.model.ImageRecipeEntity;
import com.example.mychef.model.ImageUserHistoryEntity;
import com.example.mychef.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface ImageUserHistoryRepository extends JpaRepository<ImageUserHistoryEntity, ImageUserHistoryEntity> {

      @Query(value = "SELECT * FROM image_user_history WHERE user_id = (" +
              "SELECT id from app_user WHERE id = :userId) AND recipe_id = (" +
              "SELECT id from image_recipe WHERE id = :recipeId)", nativeQuery = true)
      ImageUserHistoryEntity findByUserAndRecipe(@Param("userId") int userId,@Param("recipeId") int recipeId);

      @Query(value = "SELECT * FROM image_user_history WHERE user_id = (" +
              "SELECT id from app_user WHERE id = :userId)", nativeQuery = true)
      List<ImageUserHistoryEntity> findByUser(@Param("userId") int userId);

      @Query(value = "SELECT * FROM image_user_history WHERE recipe_id = (" +
              "SELECT id from image_recipe WHERE id = :recipeId)", nativeQuery = true)
      List<ImageUserHistoryEntity> findByRecipe(@Param("recipeId") int recipeId);
}
