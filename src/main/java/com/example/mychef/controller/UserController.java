package com.example.mychef.controller;


import com.example.mychef.dto.requestDTO.UserRequestDTO;
import com.example.mychef.dto.responseDTO.UserResponseDTO;
import com.example.mychef.model.UserEntity;
import com.example.mychef.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity addUser(@RequestBody UserResponseDTO user){
        return userService.newUser(user);
     }

    @PutMapping(path = "/id",consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity updateUserInfo(@RequestBody UserResponseDTO userUpdate,@RequestParam("id") Integer id){
        return userService.updateUser(userUpdate,id);
    }

    @GetMapping(path = "/id")
    public UserRequestDTO getUserById(@RequestParam("id") Integer id) {
        return userService.getUserById(id);
    }
    @GetMapping(path = "/all")
    public List<UserRequestDTO> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/byEmail")
    public UserRequestDTO getUserByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/byNameContaining")
    public List<UserRequestDTO> getUsersByNameContaining(@RequestParam("keyword") String keyword) {
        return userService.getUsersByNameContaining(keyword);
    }

    @GetMapping("/byEmailContaining")
    public List<UserRequestDTO> getUsersByEmailContaining(@RequestParam("keyword") String keyword) {
        return userService.getUsersByEmailContaining(keyword);
    }

    @GetMapping("/byPicture")
    public List<UserRequestDTO> getUsersByPicture(@RequestParam("pictureUrl") String pictureUrl) {
        return userService.getUsersByPicture(pictureUrl);
    }

    @GetMapping("/byEmailAndPassword")
    public List<UserRequestDTO> getUsersByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userService.getUsersByEmailAndPassword(email, password);
    }

    @GetMapping("/withImageHistory")
    public List<UserRequestDTO> getUsersWithImageHistory() {
        return userService.getUsersWithImageHistory();
    }

    @GetMapping("/withImageRatings")
    public List<UserRequestDTO> getUsersWithImageRatings() {
        return userService.getUsersWithImageRatings();
    }

    @GetMapping("/withVideoHistory")
    public List<UserRequestDTO> getUsersWithVideoHistory() {
        return userService.getUsersWithVideoHistory();
    }

    @GetMapping("/withVideoRatings")
    public List<UserRequestDTO> getUsersWithVideoRatings() {
        return userService.getUsersWithVideoRatings();
    }

    @GetMapping("/withImageHistoryGreaterThan")
    public List<UserRequestDTO> getUsersWithImageHistoryGreaterThan(@RequestParam("minHistorySize") int minHistorySize) {
        return userService.getUsersWithImageHistoryGreaterThan(minHistorySize);
    }

    @GetMapping("/withImageRatingsGreaterThan")
    public List<UserRequestDTO> getUsersWithImageRatingsGreaterThan(@RequestParam("minRatingsSize") int minRatingsSize) {
        return userService.getUsersWithImageRatingsGreaterThan(minRatingsSize);
    }

    @GetMapping("/withVideoHistoryGreaterThan")
    public List<UserRequestDTO> getUsersWithVideoHistoryGreaterThan(@RequestParam("minHistorySize") int minHistorySize) {
        return userService.getUsersWithVideoHistoryGreaterThan(minHistorySize);
    }

    @GetMapping("/withVideoRatingsGreaterThan")
    public List<UserRequestDTO> getUsersWithVideoRatingsGreaterThan(@RequestParam("minRatingsSize") int minRatingsSize) {
        return userService.getUsersWithVideoRatingsGreaterThan(minRatingsSize);
    }
}
