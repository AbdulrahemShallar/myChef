package com.example.mychef.repository;


import com.example.mychef.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository
        extends JpaRepository<UserEntity, Integer> {

     UserEntity findUserEntityById(int id);
}
