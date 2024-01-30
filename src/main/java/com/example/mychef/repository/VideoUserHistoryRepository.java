package com.example.mychef.repository;


import com.example.mychef.model.VideoUserHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Query(value = "SELECT * FROM video_user_history WHERE user_id = :userId AND date_time >= :startDate AND date_time <= :endDate", nativeQuery = true)
    List<VideoUserHistoryEntity> findByUserAndDateRange(@Param("userId") int userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT * FROM video_user_history WHERE recipe_id = :recipeId AND date_time >= :startDate AND date_time <= :endDate", nativeQuery = true)
    List<VideoUserHistoryEntity> findByRecipeAndDateRange(@Param("recipeId") int recipeId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT * FROM video_user_history WHERE date_time >= :startDate AND date_time <= :endDate", nativeQuery = true)
    List<VideoUserHistoryEntity> findByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT * FROM video_user_history ORDER BY date_time DESC LIMIT :limit", nativeQuery = true)
    List<VideoUserHistoryEntity> findLatestRecords(@Param("limit") int limit);

    @Query(value = "SELECT * FROM video_user_history WHERE user_id = :userId AND recipe_id = :recipeId AND date_time <= CURRENT_DATE ORDER BY date_time DESC LIMIT 1", nativeQuery = true)
    VideoUserHistoryEntity findLatestHistoryForUserAndRecipe(@Param("userId") int userId, @Param("recipeId") int recipeId);

    @Query(value = "SELECT * FROM video_user_history WHERE date_time <= CURRENT_DATE ORDER BY date_time DESC LIMIT :limit", nativeQuery = true)
    List<VideoUserHistoryEntity> findLatestHistoryRecords(@Param("limit") int limit);

    @Query(value = "SELECT * FROM video_user_history WHERE user_id = :userId AND date_time <= CURRENT_DATE ORDER BY date_time DESC LIMIT :limit", nativeQuery = true)
    List<VideoUserHistoryEntity> findLatestHistoryForUser(@Param("userId") int userId, @Param("limit") int limit);
}