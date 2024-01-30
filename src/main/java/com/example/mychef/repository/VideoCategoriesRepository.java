package com.example.mychef.repository;

import com.example.mychef.model.VideoCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoCategoriesRepository extends JpaRepository<VideoCategoriesEntity,Integer> {

     VideoCategoriesEntity findVideoCategoriesEntityById(int id);

     @Query("SELECT c FROM video_categories c WHERE SIZE(c.videoRecipeEntitySet) > 0")
     List<VideoCategoriesEntity> findCategoriesWithVideoRecipes();

     @Query("SELECT c FROM video_categories c WHERE c.name LIKE %:keyword%")
     List<VideoCategoriesEntity> findByNameContaining(@Param("keyword") String keyword);

     List<VideoCategoriesEntity> findByPicture(String pictureUrl);

     List<VideoCategoriesEntity> findAllByOrderByNameAsc();

     List<VideoCategoriesEntity> findAllByOrderByNameDesc();

     @Query("SELECT c FROM video_categories c ORDER BY SIZE(c.videoRecipeEntitySet) DESC")
     List<VideoCategoriesEntity> findCategoriesWithMostVideoRecipes();

     @Query("SELECT c FROM video_categories c WHERE SIZE(c.videoRecipeEntitySet) = 0")
     List<VideoCategoriesEntity> findCategoriesWithNoVideoRecipes();

     @Query("SELECT c FROM video_categories c WHERE SIZE(c.videoRecipeEntitySet) > 0 AND c.picture IS NOT NULL")
     List<VideoCategoriesEntity> findCategoriesWithVideoRecipesAndPicture();

     @Query("SELECT c FROM video_categories c WHERE c.name NOT LIKE %:excludeKeyword%")
     List<VideoCategoriesEntity> findByExcludingName(@Param("excludeKeyword") String excludeKeyword);

     @Query("SELECT c FROM video_categories c WHERE c.name LIKE %:keyword% ORDER BY SIZE(c.videoRecipeEntitySet) DESC")
     List<VideoCategoriesEntity> findByNameContainingOrderByVideoRecipeCountDesc(@Param("keyword") String keyword);

}
