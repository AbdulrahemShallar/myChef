package com.example.mychef.repository;

import com.example.mychef.model.VideoUserRatingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoUserRatingsRepository extends JpaRepository<VideoUserRatingsEntity, VideoUserRatingsEntity> {
}
