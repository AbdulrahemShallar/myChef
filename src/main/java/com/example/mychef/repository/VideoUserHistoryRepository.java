package com.example.mychef.repository;

import com.example.mychef.model.UserEntity;
import com.example.mychef.model.VideoUserHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoUserHistoryRepository extends JpaRepository<VideoUserHistoryEntity, VideoUserHistoryEntity> {
}
