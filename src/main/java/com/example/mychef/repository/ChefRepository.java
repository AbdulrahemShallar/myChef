package com.example.mychef.repository;

import com.example.mychef.model.ChefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefRepository extends JpaRepository<ChefEntity,Integer> {
     ChefEntity findChefEntityById(int id);
}
