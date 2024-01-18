package com.example.mychef.repository;

import com.example.mychef.model.ImageUserRatingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageUserRatingsRepository extends JpaRepository<ImageUserRatingsEntity,ImageUserRatingsEntity> {
}
