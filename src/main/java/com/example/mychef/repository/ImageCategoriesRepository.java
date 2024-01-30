package com.example.mychef.repository;


import com.example.mychef.model.ImageCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageCategoriesRepository extends JpaRepository<ImageCategoriesEntity, Integer> {

     ImageCategoriesEntity findImageCategoriesEntityById(int id);

     @Query("SELECT c FROM image_categories c WHERE SIZE(c.imageRecipeEntitySet) > 0")
     List<ImageCategoriesEntity> findCategoriesWithImageRecipes();

     @Query("SELECT c FROM image_categories c WHERE c.name LIKE %:keyword%")
     List<ImageCategoriesEntity> findByNameContaining(@Param("keyword") String keyword);

     List<ImageCategoriesEntity> findByPicture(String pictureUrl);

     List<ImageCategoriesEntity> findAllByOrderByNameAsc();

     List<ImageCategoriesEntity> findAllByOrderByNameDesc();

     @Query("SELECT c FROM image_categories c ORDER BY SIZE(c.imageRecipeEntitySet) DESC")
     List<ImageCategoriesEntity> findCategoriesWithMostImageRecipes();

     @Query("SELECT c FROM image_categories c WHERE SIZE(c.imageRecipeEntitySet) = 0")
     List<ImageCategoriesEntity> findCategoriesWithNoImageRecipes();

     @Query("SELECT c FROM image_categories c WHERE SIZE(c.imageRecipeEntitySet) > 0 AND c.picture IS NOT NULL")
     List<ImageCategoriesEntity> findCategoriesWithImageRecipesAndPicture();

     @Query("SELECT c FROM image_categories c WHERE c.name NOT LIKE %:excludeKeyword%")
     List<ImageCategoriesEntity> findByExcludingName(@Param("excludeKeyword") String excludeKeyword);

     @Query("SELECT c FROM image_categories c WHERE c.name LIKE %:keyword% ORDER BY SIZE(c.imageRecipeEntitySet) DESC")
     List<ImageCategoriesEntity> findByNameContainingOrderByImageRecipeCountDesc(@Param("keyword") String keyword);


}
