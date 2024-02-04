package com.example.mychef.repository;


import com.example.mychef.model.ImageUserHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface ImageUserHistoryRepository extends JpaRepository<ImageUserHistoryEntity, ImageUserHistoryEntity> {

      @Query(value = "SELECT i FROM image_user_history i WHERE i.user.id = (" +
              "SELECT u.id from app_user u WHERE u.id = :userId) AND i.recipe.id = (" +
              "SELECT r.id from image_recipe r WHERE r.id = :recipeId)")
      ImageUserHistoryEntity findByUserAndRecipe(@Param("userId") int userId,@Param("recipeId") int recipeId);

      @Query(value = "SELECT i FROM image_user_history i WHERE i.user.id = (" +
              "SELECT u.id from app_user u WHERE u.id = :userId)")
      List<ImageUserHistoryEntity> findByUser(@Param("userId") int userId);

      @Query(value = "SELECT i FROM image_user_history i WHERE i.recipe.id = (" +
              "SELECT r.id from image_recipe r WHERE r.id = :recipeId)")
      List<ImageUserHistoryEntity> findByRecipe(@Param("recipeId") int recipeId);

      @Query(value = "SELECT i FROM image_user_history i WHERE i.user.id = :userId AND" +
              " i.dateTime >= :startDate AND i.dateTime <= :endDate")
      List<ImageUserHistoryEntity> findByUserAndDateRange(@Param("userId") int userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

      @Query(value = "SELECT i FROM image_user_history i WHERE i.recipe.id = :recipeId AND " +
              "i.dateTime >= :startDate AND i.dateTime <= :endDate")
      List<ImageUserHistoryEntity> findByRecipeAndDateRange(@Param("recipeId") int recipeId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

      @Query(value = "SELECT i FROM image_user_history i WHERE i.dateTime >= :startDate AND i.dateTime <= :endDate")
      List<ImageUserHistoryEntity> findByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

//      @Query(value = "SELECT i FROM image_user_history i ORDER BY i.dateTime DESC")
//      List<ImageUserHistoryEntity> findLatestRecords(@Param("limit") int limit);

      @Query("SELECT i FROM image_user_history i ORDER BY i.dateTime DESC")
      List<ImageUserHistoryEntity> findLatestRecords();


      @Query(value = "SELECT i FROM image_user_history i WHERE i.user.id = :userId AND " +
              "i.recipe.id = :recipeId AND i.dateTime <= CURRENT_DATE ORDER BY i.dateTime DESC LIMIT 1")
      ImageUserHistoryEntity findLatestHistoryForUserAndRecipe(@Param("userId") int userId, @Param("recipeId") int recipeId);

      @Query(value = "SELECT i FROM image_user_history i WHERE i.dateTime <= CURRENT_DATE ORDER BY i.dateTime DESC")
      List<ImageUserHistoryEntity> findLatestHistoryRecords();

      @Query(value = "SELECT i FROM image_user_history i WHERE i.user.id = :userId AND " +
              "i.dateTime <= CURRENT_DATE ORDER BY i.dateTime DESC")
      List<ImageUserHistoryEntity> findLatestHistoryForUser(@Param("userId") int userId);
}
