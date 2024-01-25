package com.example.mychef.repository;

import com.example.mychef.model.VideoUserRatingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoUserRatingsRepository extends JpaRepository<VideoUserRatingsEntity, VideoUserRatingsEntity> {
    @Query(value = "SELECT * FROM video_user_ratings WHERE user_id = (" +
            "SELECT id from app_user WHERE id = :userId) AND recipe_id = (" +
            "SELECT id from video_recipe WHERE id = :recipeId)", nativeQuery = true)
    VideoUserRatingsEntity findByUserAndRecipe(@Param("userId") int userId, @Param("recipeId") int recipeId);

    @Query(value = "SELECT * FROM video_user_ratings WHERE user_id = (" +
            "SELECT id from app_user WHERE id = :userId)", nativeQuery = true)
    List<VideoUserRatingsEntity> findByUser(@Param("userId") int userId);

    @Query(value = "SELECT * FROM video_user_ratings WHERE recipe_id = (" +
            "SELECT id from video_recipe WHERE id = :recipeId)", nativeQuery = true)
    List<VideoUserRatingsEntity> findByRecipe(@Param("recipeId") int recipeId);
}
