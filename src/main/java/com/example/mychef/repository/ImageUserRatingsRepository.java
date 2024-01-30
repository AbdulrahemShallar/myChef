package com.example.mychef.repository;

import com.example.mychef.model.ImageUserRatingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
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

    @Query(value = "SELECT * FROM image_user_ratings WHERE rate = :rate", nativeQuery = true)
    List<ImageUserRatingsEntity> findByRate(@Param("rate") int rate);

    @Query(value = "SELECT * FROM image_user_ratings WHERE rate BETWEEN :minRate AND :maxRate", nativeQuery = true)
    List<ImageUserRatingsEntity> findByRateBetween(@Param("minRate") int minRate, @Param("maxRate") int maxRate);

    @Query(value = "SELECT * FROM image_user_ratings WHERE data_time >= :startDate AND data_time <= :endDate", nativeQuery = true)
    List<ImageUserRatingsEntity> findByDateRange(@Param("startDate") Instant startDate, @Param("endDate") Instant endDate);

    @Query(value = "SELECT * FROM image_user_ratings WHERE comment IS NOT NULL", nativeQuery = true)
    List<ImageUserRatingsEntity> findRatingsWithComments();

    @Query(value = "SELECT * FROM image_user_ratings WHERE comment IS NULL", nativeQuery = true)
    List<ImageUserRatingsEntity> findRatingsWithoutComments();

    @Query(value = "SELECT * FROM image_user_ratings WHERE user_id = :userId AND rate = :rate", nativeQuery = true)
    List<ImageUserRatingsEntity> findByUserAndRate(@Param("userId") int userId, @Param("rate") int rate);

    @Query(value = "SELECT * FROM image_user_ratings WHERE recipe_id = :recipeId AND rate = :rate", nativeQuery = true)
    List<ImageUserRatingsEntity> findByRecipeAndRate(@Param("recipeId") int recipeId, @Param("rate") int rate);

    @Query(value = "SELECT * FROM image_user_ratings WHERE rate = (SELECT MAX(rate) FROM image_user_ratings)", nativeQuery = true)
    List<ImageUserRatingsEntity> findMaxRatedRatings();

    @Query(value = "SELECT * FROM image_user_ratings WHERE rate = (SELECT MIN(rate) FROM image_user_ratings)", nativeQuery = true)
    List<ImageUserRatingsEntity> findMinRatedRatings();
}
