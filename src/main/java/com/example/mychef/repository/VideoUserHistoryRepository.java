package com.example.mychef.repository;


import com.example.mychef.model.VideoUserHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoUserHistoryRepository extends JpaRepository<VideoUserHistoryEntity, VideoUserHistoryEntity> {

    @Query(value = "SELECT * FROM video_user_history WHERE user_id = (" +
            "SELECT id from app_user WHERE id = :userId) AND recipe_id = (" +
            "SELECT id from video_recipe WHERE id = :recipeId)", nativeQuery = true)
    VideoUserHistoryEntity findByUserAndRecipe(@Param("userId") int userId, @Param("recipeId") int recipeId);

    @Query(value = "SELECT * FROM video_user_history WHERE user_id = (" +
            "SELECT id from app_user WHERE id = :userId)", nativeQuery = true)
    List<VideoUserHistoryEntity> findByUser(@Param("userId") int userId);

    @Query(value = "SELECT * FROM video_user_history WHERE recipe_id = (" +
            "SELECT id from video_recipe WHERE id = :recipeId)", nativeQuery = true)
    List<VideoUserHistoryEntity> findByRecipe(@Param("recipeId") int recipeId);
}
