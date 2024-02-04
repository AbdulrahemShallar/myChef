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

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.user.id = (" +
            "SELECT u.id from app_user u WHERE u.id = :userId) AND i.recipe.id = (" +
            "SELECT r.id from image_recipe r WHERE r.id = :recipeId)")
    ImageUserRatingsEntity findByUserAndRecipe(@Param("userId") int userId, @Param("recipeId") int recipeId);

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.user.id = (" +
            "SELECT u.id from app_user u WHERE u.id = :userId)")
    List<ImageUserRatingsEntity> findByUser(@Param("userId") int userId);

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.recipe.id = (" +
            "SELECT r.id from image_recipe r WHERE r.id = :recipeId)")
    List<ImageUserRatingsEntity> findByRecipe(@Param("recipeId") int recipeId);

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.rate = :rate")
    List<ImageUserRatingsEntity> findByRate(@Param("rate") int rate);

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.rate BETWEEN :minRate AND :maxRate")
    List<ImageUserRatingsEntity> findByRateBetween(@Param("minRate") int minRate, @Param("maxRate") int maxRate);

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.dataTime >= :startDate AND i.dataTime <= :endDate")
    List<ImageUserRatingsEntity> findByDateRange(@Param("startDate") Instant startDate, @Param("endDate") Instant endDate);

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.comment IS NOT NULL")
    List<ImageUserRatingsEntity> findRatingsWithComments();

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.comment IS NULL")
    List<ImageUserRatingsEntity> findRatingsWithoutComments();

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.user.id = :userId AND i.rate = :rate")
    List<ImageUserRatingsEntity> findByUserAndRate(@Param("userId") int userId, @Param("rate") int rate);

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.recipe.id = :recipeId AND i.rate = :rate")
    List<ImageUserRatingsEntity> findByRecipeAndRate(@Param("recipeId") int recipeId, @Param("rate") int rate);

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.rate = (SELECT MAX(r.rate) FROM image_user_ratings r)")
    List<ImageUserRatingsEntity> findMaxRatedRatings();

    @Query(value = "SELECT i FROM image_user_ratings i WHERE i.rate = (SELECT MIN(r.rate) FROM image_user_ratings r)")
    List<ImageUserRatingsEntity> findMinRatedRatings();
}
