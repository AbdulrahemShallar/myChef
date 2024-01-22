package com.example.mychef.repository;


import com.example.mychef.model.ImageCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageCategoriesRepository extends JpaRepository<ImageCategoriesEntity, Integer> {

     ImageCategoriesEntity findImageCategoriesEntityById(int id);

}
