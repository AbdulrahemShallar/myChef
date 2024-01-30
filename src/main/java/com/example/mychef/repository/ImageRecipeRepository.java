package com.example.mychef.repository;


import com.example.mychef.model.ImageCategoriesEntity;
import com.example.mychef.model.ImageRecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ImageRecipeRepository extends JpaRepository<ImageRecipeEntity, Integer> {
     ImageRecipeEntity findImageRecipeEntityById(int id);


     @Query("SELECT i FROM image_recipe i WHERE i.title LIKE %:keyword%")
     List<ImageRecipeEntity> findByTitleContaining(@Param("keyword") String keyword);

     @Query("SELECT i FROM image_recipe i WHERE i.category = :category")
     List<ImageRecipeEntity> findByCategory(@Param("category") ImageCategoriesEntity category);

     @Query("SELECT i FROM image_recipe i WHERE i.totalRate > :rate")
     List<ImageRecipeEntity> findByTotalRateGreaterThan(@Param("rate") int rate);

     @Query("SELECT i FROM image_recipe i WHERE i.likes > :likes")
     List<ImageRecipeEntity> findByLikesGreaterThan(@Param("likes") int likes);

     @Query("SELECT i FROM image_recipe i WHERE i.date > :date")
     List<ImageRecipeEntity> findByDateAfter(@Param("date") LocalDate date);

     @Query("SELECT i FROM image_recipe i ORDER BY i.totalRate DESC")
     List<ImageRecipeEntity> findByOrderByTotalRateDesc();

     @Query("SELECT i FROM image_recipe i WHERE i.likes = (SELECT MAX(i2.likes) FROM image_recipe i2)")
     List<ImageRecipeEntity> findMostLikedRecipe();

     @Query("SELECT i FROM image_recipe i WHERE SIZE(i.imageUserRatingsEntitySet) > :minRatings")
     List<ImageRecipeEntity> findByMinRatings(@Param("minRatings") int minRatings);

     @Query("SELECT i FROM image_recipe i WHERE i.totalRate >= :minRate AND i.totalRate <= :maxRate")
     List<ImageRecipeEntity> findByTotalRateBetween(@Param("minRate") int minRate, @Param("maxRate") int maxRate);

     @Query("SELECT i FROM image_recipe i WHERE i.date BETWEEN :startDate AND :endDate")
     List<ImageRecipeEntity> findByDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

     @Query("SELECT i FROM image_recipe i WHERE i.likes = (SELECT MIN(i2.likes) FROM image_recipe i2)")
     List<ImageRecipeEntity> findLeastLikedRecipe();

     @Query("SELECT i FROM image_recipe i WHERE LOWER(i.title) LIKE %:keyword%")
     List<ImageRecipeEntity> findByTitleContainingIgnoreCase(@Param("keyword") String keyword);

     @Query("SELECT i FROM image_recipe i WHERE i.totalRate = (SELECT MAX(i2.totalRate) FROM image_recipe i2)")
     List<ImageRecipeEntity> findTopRatedRecipe();

     @Query("SELECT i FROM image_recipe i WHERE i.date = CURRENT_DATE")
     List<ImageRecipeEntity> findRecipesCreatedToday();

     @Query("SELECT i FROM image_recipe i WHERE i.likes = 0")
     List<ImageRecipeEntity> findRecipesWithNoLikes();

     @Query("SELECT i FROM image_recipe i WHERE i.date = (SELECT MAX(i2.date) FROM image_recipe i2)")
     List<ImageRecipeEntity> findLatestRecipe();

}
