package com.example.mychef.repository;

import com.example.mychef.model.VideoCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCategoriesRepository extends JpaRepository<VideoCategoriesEntity,Integer> {

     VideoCategoriesEntity findVideoCategoriesEntityById(int id);
}
