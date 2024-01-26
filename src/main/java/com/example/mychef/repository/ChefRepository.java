package com.example.mychef.repository;

import com.example.mychef.model.ChefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChefRepository extends JpaRepository<ChefEntity,Integer> {
     ChefEntity findChefEntityById(int id);

     @Query(value = "SELECT c FROM chef c WHERE UPPER(c.name) Like %upper(?1)%")
     List<ChefEntity> findByName(String name);

     @Query(value = "SELECT c FROM chef c WHERE c.channelLink IS NOT NULL And c.channelLink like %?1%")
     List<ChefEntity> findChefsWithChannelLink(String link);

     List<ChefEntity> findByChefRateGreaterThan(int rate);

     List<ChefEntity> findByChefRateLessThan(int rate);


     List<ChefEntity> findByChefRateBetween(int minRate, int maxRate);


     List<ChefEntity> findByAboutContainingIgnoreCase(String keyword);


     // Custom query to find chefs with a specific video recipe
     @Query(value = "SELECT c FROM chef c JOIN c.videoRecipeEntitySet v WHERE v.title = :recipeTitle")
     List<ChefEntity> findChefsByVideoRecipeTitle(@Param("recipeTitle") String recipeTitle);

     List<ChefEntity> findByOrderByChefRateDesc();

     List<ChefEntity> findByOrderByChefRateAsc();

     // Custom query to find chefs with a specific picture URL
     List<ChefEntity> findByPicture(String pictureUrl);

}
