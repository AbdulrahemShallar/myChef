package com.example.mychef.service;

import com.example.mychef.model.UserEntity;
import com.example.mychef.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

 
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity newUser(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity userUpdate,Integer id){
        UserEntity foundUser = userRepository.findUserEntityById(id);
        if (foundUser != null){
            foundUser.setName(userUpdate.getName());
            foundUser.setEmail(userUpdate.getEmail());
            foundUser.setPicture(userUpdate.getPicture());
            foundUser.setPassword(userUpdate.getPassword());
            return userRepository.save(foundUser);
        }
        return null;
    }

    public UserEntity getUserById(int id){
        return userRepository.findUserEntityById(id);
    }

    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findUserEntityByEmail(email);
    }

    public List<UserEntity> getUsersByNameContaining(String keyword) {
        return userRepository.findUsersByNameContaining(keyword);
    }

    public List<UserEntity> getUsersByEmailContaining(String keyword) {
        return userRepository.findUsersByEmailContaining(keyword);
    }

    public List<UserEntity> getUsersByPicture(String pictureUrl) {
        return userRepository.findUsersByPicture(pictureUrl);
    }

    public List<UserEntity> getUsersByEmailAndPassword(String email, String password) {
        return userRepository.findUsersByEmailAndPassword(email, password);
    }

    public List<UserEntity> getUsersWithImageHistory() {
        return userRepository.findUsersWithImageHistory();
    }

    public List<UserEntity> getUsersWithImageRatings() {
        return userRepository.findUsersWithImageRatings();
    }

    public List<UserEntity> getUsersWithVideoHistory() {
        return userRepository.findUsersWithVideoHistory();
    }

    public List<UserEntity> getUsersWithVideoRatings() {
        return userRepository.findUsersWithVideoRatings();
    }

    public List<UserEntity> getUsersWithImageHistoryGreaterThan(int minHistorySize) {
        return userRepository.findUsersWithImageHistoryGreaterThan(minHistorySize);
    }

    public List<UserEntity> getUsersWithImageRatingsGreaterThan(int minRatingsSize) {
        return userRepository.findUsersWithImageRatingsGreaterThan(minRatingsSize);
    }

    public List<UserEntity> getUsersWithVideoHistoryGreaterThan(int minHistorySize) {
        return userRepository.findUsersWithVideoHistoryGreaterThan(minHistorySize);
    }

    public List<UserEntity> getUsersWithVideoRatingsGreaterThan(int minRatingsSize) {
        return userRepository.findUsersWithVideoRatingsGreaterThan(minRatingsSize);
    }

}
