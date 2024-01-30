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

    @Query(value = "SELECT * FROM video_user_ratings WHERE rate = :rate", nativeQuery = true)
    List<VideoUserRatingsEntity> findByRate(@Param("rate") int rate);

    @Query(value = "SELECT * FROM video_user_ratings WHERE rate BETWEEN :minRate AND :maxRate", nativeQuery = true)
    List<VideoUserRatingsEntity> findByRateBetween(@Param("minRate") int minRate, @Param("maxRate") int maxRate);

    @Query(value = "SELECT * FROM video_user_ratings WHERE data_time >= :startDate AND data_time <= :endDate", nativeQuery = true)
    List<VideoUserRatingsEntity> findByDateRange(@Param("startDate") Instant startDate, @Param("endDate") Instant endDate);

    @Query(value = "SELECT * FROM video_user_ratings WHERE comment IS NOT NULL", nativeQuery = true)
    List<VideoUserRatingsEntity> findRatingsWithComments();

    @Query(value = "SELECT * FROM video_user_ratings WHERE comment IS NULL", nativeQuery = true)
    List<VideoUserRatingsEntity> findRatingsWithoutComments();

    @Query(value = "SELECT * FROM video_user_ratings WHERE user_id = :userId AND rate = :rate", nativeQuery = true)
    List<VideoUserRatingsEntity> findByUserAndRate(@Param("userId") int userId, @Param("rate") int rate);

    @Query(value = "SELECT * FROM video_user_ratings WHERE recipe_id = :recipeId AND rate = :rate", nativeQuery = true)
    List<VideoUserRatingsEntity> findByRecipeAndRate(@Param("recipeId") int recipeId, @Param("rate") int rate);

    @Query(value = "SELECT * FROM video_user_ratings WHERE rate = (SELECT MAX(rate) FROM video_user_ratings)", nativeQuery = true)
    List<VideoUserRatingsEntity> findMaxRatedRatings();

    @Query(value = "SELECT * FROM video_user_ratings WHERE rate = (SELECT MIN(rate) FROM video_user_ratings)", nativeQuery = true)
    List<VideoUserRatingsEntity> findMinRatedRatings();
}
