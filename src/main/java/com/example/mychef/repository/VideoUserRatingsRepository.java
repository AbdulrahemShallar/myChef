package com.example.mychef.repository;

import com.example.mychef.model.VideoUserRatingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface VideoUserRatingsRepository extends JpaRepository<VideoUserRatingsEntity, VideoUserRatingsEntity> {
    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.user.id = (" +
            "SELECT u.id from app_user u WHERE u.id = :userId) AND v.recipe.id = (" +
            "SELECT r.id from video_recipe r WHERE r.id = :recipeId)")
    VideoUserRatingsEntity findByUserAndRecipe(@Param("userId") int userId, @Param("recipeId") int recipeId);

    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.user.id = (" +
            "SELECT u.id from app_user u WHERE u.id = :userId)")
    List<VideoUserRatingsEntity> findByUser(@Param("userId") int userId);

    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.recipe.id = (" +
            "SELECT u.id from video_recipe u WHERE u.id = :recipeId)")
    List<VideoUserRatingsEntity> findByRecipe(@Param("recipeId") int recipeId);

    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.rate = :rate")
    List<VideoUserRatingsEntity> findByRate(@Param("rate") int rate);

    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.rate BETWEEN :minRate AND :maxRate")
    List<VideoUserRatingsEntity> findByRateBetween(@Param("minRate") int minRate, @Param("maxRate") int maxRate);

    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.dateTime >= :startDate AND v.dateTime <= :endDate")
    List<VideoUserRatingsEntity> findByDateRange(@Param("startDate") Instant startDate, @Param("endDate") Instant endDate);

    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.comment IS NOT NULL")
    List<VideoUserRatingsEntity> findRatingsWithComments();

    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.comment IS NULL")
    List<VideoUserRatingsEntity> findRatingsWithoutComments();

    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.user.id = :userId AND v.rate = :rate")
    List<VideoUserRatingsEntity> findByUserAndRate(@Param("userId") int userId, @Param("rate") int rate);

    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.recipe.id = :recipeId AND v.rate = :rate")
    List<VideoUserRatingsEntity> findByRecipeAndRate(@Param("recipeId") int recipeId, @Param("rate") int rate);

    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.rate = (SELECT MAX(r.rate) FROM video_user_ratings r)")
    List<VideoUserRatingsEntity> findMaxRatedRatings();

    @Query(value = "SELECT v FROM video_user_ratings v WHERE v.rate = (SELECT MIN(r.rate) FROM video_user_ratings r)")
    List<VideoUserRatingsEntity> findMinRatedRatings();
}
