package com.example.mychef.repository;


import com.example.mychef.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

     UserEntity findUserEntityById(int id);

     @Query("SELECT u FROM app_user u WHERE u.email = :email")
     UserEntity findUserEntityByEmail(@Param("email") String email);

     List<UserEntity> findUsersByNameContaining(String keyword);

     List<UserEntity> findUsersByEmailContaining(String keyword);

     List<UserEntity> findUsersByPicture(String pictureUrl);

     List<UserEntity> findUsersByEmailAndPassword(String email, String password);

     @Query("SELECT u FROM app_user u WHERE SIZE(u.imageUserHistorySet) > 0")
     List<UserEntity> findUsersWithImageHistory();

     @Query("SELECT u FROM app_user u WHERE SIZE(u.imageUserRatingsEntitySet) > 0")
     List<UserEntity> findUsersWithImageRatings();

     @Query("SELECT u FROM app_user u WHERE SIZE(u.videoUserHistoryEntitySet) > 0")
     List<UserEntity> findUsersWithVideoHistory();

     @Query("SELECT u FROM app_user u WHERE SIZE(u.videoUserRatingsEntitySet) > 0")
     List<UserEntity> findUsersWithVideoRatings();

     @Query("SELECT u FROM app_user u WHERE SIZE(u.imageUserHistorySet) > :minHistorySize")
     List<UserEntity> findUsersWithImageHistoryGreaterThan(@Param("minHistorySize") int minHistorySize);

     @Query("SELECT u FROM app_user u WHERE SIZE(u.imageUserRatingsEntitySet) > :minRatingsSize")
     List<UserEntity> findUsersWithImageRatingsGreaterThan(@Param("minRatingsSize") int minRatingsSize);

     @Query("SELECT u FROM app_user u WHERE SIZE(u.videoUserHistoryEntitySet) > :minHistorySize")
     List<UserEntity> findUsersWithVideoHistoryGreaterThan(@Param("minHistorySize") int minHistorySize);

     @Query("SELECT u FROM app_user u WHERE SIZE(u.videoUserRatingsEntitySet) > :minRatingsSize")
     List<UserEntity> findUsersWithVideoRatingsGreaterThan(@Param("minRatingsSize") int minRatingsSize);


}
