package com.example.mychef.repository;

import com.example.mychef.model.ChefEntity;
import com.example.mychef.model.VideoCategoriesEntity;
import com.example.mychef.model.VideoRecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VideoRecipeRepository extends JpaRepository<VideoRecipeEntity,Integer> {

     VideoRecipeEntity findVideoRecipeEntityById(int id);

     @Query("SELECT i FROM video_recipe i WHERE i.title LIKE %:keyword%")
     List<VideoRecipeEntity> findByTitleContaining(@Param("keyword") String keyword);

     @Query("SELECT i FROM video_recipe i WHERE i.category = :category")
     List<VideoRecipeEntity> findByCategory(@Param("category") VideoCategoriesEntity category);

     @Query("SELECT i FROM video_recipe i WHERE i.totalRate > :rate")
     List<VideoRecipeEntity> findByTotalRateGreaterThan(@Param("rate") int rate);

     @Query("SELECT i FROM video_recipe i WHERE i.likes > :likes")
     List<VideoRecipeEntity> findByLikesGreaterThan(@Param("likes") int likes);

     @Query("SELECT i FROM video_recipe i WHERE i.date > :date")
     List<VideoRecipeEntity> findByDateAfter(@Param("date") LocalDate date);

     @Query("SELECT i FROM video_recipe i ORDER BY i.totalRate DESC")
     List<VideoRecipeEntity> findByOrderByTotalRateDesc();

     @Query("SELECT i FROM video_recipe i WHERE i.likes = (SELECT MAX(i2.likes) FROM video_recipe i2)")
     List<VideoRecipeEntity> findMostLikedRecipe();

     @Query("SELECT i FROM video_recipe i WHERE SIZE(i.videoUserRatingsEntitySet) > :minRatings")
     List<VideoRecipeEntity> findByMinRatings(@Param("minRatings") int minRatings);

     @Query("SELECT i FROM video_recipe i WHERE i.totalRate >= :minRate AND i.totalRate <= :maxRate")
     List<VideoRecipeEntity> findByTotalRateBetween(@Param("minRate") int minRate, @Param("maxRate") int maxRate);

     @Query("SELECT i FROM video_recipe i WHERE i.date BETWEEN :startDate AND :endDate")
     List<VideoRecipeEntity> findByDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

     @Query("SELECT i FROM video_recipe i WHERE i.likes = (SELECT MIN(i2.likes) FROM video_recipe i2)")
     List<VideoRecipeEntity> findLeastLikedRecipe();

     @Query("SELECT i FROM video_recipe i WHERE LOWER(i.title) LIKE %:keyword%")
     List<VideoRecipeEntity> findByTitleContainingIgnoreCase(@Param("keyword") String keyword);

     @Query("SELECT i FROM video_recipe i WHERE i.totalRate = (SELECT MAX(i2.totalRate) FROM video_recipe i2)")
     List<VideoRecipeEntity> findTopRatedRecipe();

     @Query("SELECT i FROM video_recipe i WHERE i.date = CURRENT_DATE")
     List<VideoRecipeEntity> findRecipesCreatedToday();

     @Query("SELECT i FROM video_recipe i WHERE i.likes = 0")
     List<VideoRecipeEntity> findRecipesWithNoLikes();

     @Query("SELECT i FROM video_recipe i WHERE i.date = (SELECT MAX(i2.date) FROM video_recipe i2)")
     List<VideoRecipeEntity> findLatestRecipe();

     @Query("SELECT i FROM video_recipe i WHERE i.chef = :chef")
     List<VideoRecipeEntity> findByChef(@Param("chef") ChefEntity chef);

     @Query("SELECT i FROM video_recipe i WHERE i.link = :link")
     List<VideoRecipeEntity> findByLink(@Param("link") String link);

     @Query("SELECT i FROM video_recipe i WHERE i.category = :category AND i.totalRate >= :minRate AND i.totalRate <= :maxRate")
     List<VideoRecipeEntity> findByCategoryAndTotalRateBetween(
             @Param("category") VideoCategoriesEntity category,
             @Param("minRate") int minRate,
             @Param("maxRate") int maxRate
     );

     @Query("SELECT i FROM video_recipe i WHERE i.date = (SELECT MAX(i2.date) FROM video_recipe i2 WHERE i2.chef = i.chef)")
     List<VideoRecipeEntity> findLatestRecipeByChef();

     @Query("SELECT i FROM video_recipe i WHERE i.date = (SELECT MIN(i2.date) FROM video_recipe i2 WHERE i2.chef = i.chef)")
     List<VideoRecipeEntity> findOldestRecipeByChef();

     @Query("SELECT i FROM video_recipe i WHERE i.totalRate = (SELECT MIN(i2.totalRate) FROM video_recipe i2)")
     List<VideoRecipeEntity> findLowestRatedRecipe();

     @Query("SELECT i FROM video_recipe i WHERE i.totalRate = (SELECT MAX(i2.totalRate) FROM video_recipe i2)")
     List<VideoRecipeEntity> findHighestRatedRecipe();

     @Query("SELECT i FROM video_recipe i WHERE i.totalRate = 0")
     List<VideoRecipeEntity> findUnratedRecipes();

}
