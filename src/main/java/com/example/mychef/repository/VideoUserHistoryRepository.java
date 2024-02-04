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

    @Query(value = "SELECT v FROM video_user_history v WHERE v.user.id = (" +
            "SELECT u.id from app_user u WHERE u.id = :userId) AND v.recipe.id = (" +
            "SELECT r.id from video_recipe r WHERE r.id = :recipeId)")
    VideoUserHistoryEntity findByUserAndRecipe(@Param("userId") int userId, @Param("recipeId") int recipeId);

    @Query(value = "SELECT v FROM video_user_history v WHERE v.user.id = (" +
            "SELECT u.id from app_user u WHERE u.id = :userId)")
    List<VideoUserHistoryEntity> findByUser(@Param("userId") int userId);

    @Query(value = "SELECT v FROM video_user_history v WHERE v.recipe.id = (" +
            "SELECT r.id from video_recipe r WHERE r.id = :recipeId)")
    List<VideoUserHistoryEntity> findByRecipe(@Param("recipeId") int recipeId);

    @Query(value = "SELECT v FROM video_user_history v WHERE v.user.id = :userId " +
            "AND v.dateTime >= :startDate AND v.dateTime <= :endDate")
    List<VideoUserHistoryEntity> findByUserAndDateRange(@Param("userId") int userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT v FROM video_user_history v WHERE v.recipe.id = :recipeId " +
            "AND v.dateTime >= :startDate AND v.dateTime <= :endDate")
    List<VideoUserHistoryEntity> findByRecipeAndDateRange(@Param("recipeId") int recipeId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT v FROM video_user_history v WHERE v.dateTime >= :startDate AND v.dateTime <= :endDate")
    List<VideoUserHistoryEntity> findByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT v FROM video_user_history v ORDER BY v.dateTime DESC")
    List<VideoUserHistoryEntity> findLatestRecords();

    @Query(value = "SELECT v FROM video_user_history v WHERE v.user.id = :userId " +
            "AND v.recipe.id = :recipeId AND v.dateTime <= CURRENT_DATE ORDER BY v.dateTime DESC LIMIT 1")
    VideoUserHistoryEntity findLatestHistoryForUserAndRecipe(@Param("userId") int userId, @Param("recipeId") int recipeId);

    @Query(value = "SELECT v FROM video_user_history v WHERE v.dateTime <= CURRENT_DATE ORDER BY v.dateTime DESC")
    List<VideoUserHistoryEntity> findLatestHistoryRecords();

    @Query(value = "SELECT v FROM video_user_history v WHERE v.user.id = :userId AND v.dateTime <= CURRENT_DATE " +
            "ORDER BY v.dateTime DESC")
    List<VideoUserHistoryEntity> findLatestHistoryForUser(@Param("userId") int userId);
}