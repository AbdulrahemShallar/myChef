package com.example.mychef.controller;


import com.example.mychef.convert.UserDTOConverter;
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

    final
    UserDTOConverter userDTOConverter;

    public UserController(UserService userService, UserDTOConverter userDTOConverter) {
        this.userService = userService;
        this.userDTOConverter = userDTOConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity addUser(@RequestBody UserResponseDTO user){
        return userService.newUser(userDTOConverter.convertUserDTOToEntity(user));
     }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity updateUserInfo(@RequestBody UserResponseDTO userUpdate,@RequestParam("id") Integer id){
        return userService.updateUser(userDTOConverter.convertUserDTOToEntity(userUpdate),id);
    }

    @GetMapping(path = "/id")
    public UserRequestDTO getUserById(@RequestParam("id") Integer id) {
        return userDTOConverter.convertUserEntityToDTO(userService.getUserById(id));
    }
    @GetMapping(path = "/all")
    public List<UserRequestDTO> getAllUsers(){
        return userDTOConverter.convertUserEntityToDTO(userService.getAllUser());
    }

    @GetMapping("/byEmail")
    public UserRequestDTO getUserByEmail(@RequestParam("email") String email) {
        return userDTOConverter.convertUserEntityToDTO(userService.getUserByEmail(email));
    }

    @GetMapping("/byNameContaining")
    public List<UserRequestDTO> getUsersByNameContaining(@RequestParam("keyword") String keyword) {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersByNameContaining(keyword));
    }

    @GetMapping("/byEmailContaining")
    public List<UserRequestDTO> getUsersByEmailContaining(@RequestParam("keyword") String keyword) {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersByEmailContaining(keyword));
    }

    @GetMapping("/byPicture")
    public List<UserRequestDTO> getUsersByPicture(@RequestParam("pictureUrl") String pictureUrl) {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersByPicture(pictureUrl));
    }

    @GetMapping("/byEmailAndPassword")
    public List<UserRequestDTO> getUsersByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersByEmailAndPassword(email, password));
    }

    @GetMapping("/withImageHistory")
    public List<UserRequestDTO> getUsersWithImageHistory() {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersWithImageHistory());
    }

    @GetMapping("/withImageRatings")
    public List<UserRequestDTO> getUsersWithImageRatings() {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersWithImageRatings());
    }

    @GetMapping("/withVideoHistory")
    public List<UserRequestDTO> getUsersWithVideoHistory() {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersWithVideoHistory());
    }

    @GetMapping("/withVideoRatings")
    public List<UserRequestDTO> getUsersWithVideoRatings() {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersWithVideoRatings());
    }

    @GetMapping("/withImageHistoryGreaterThan")
    public List<UserRequestDTO> getUsersWithImageHistoryGreaterThan(@RequestParam("minHistorySize") int minHistorySize) {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersWithImageHistoryGreaterThan(minHistorySize));
    }

    @GetMapping("/withImageRatingsGreaterThan")
    public List<UserRequestDTO> getUsersWithImageRatingsGreaterThan(@RequestParam("minRatingsSize") int minRatingsSize) {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersWithImageRatingsGreaterThan(minRatingsSize));
    }

    @GetMapping("/withVideoHistoryGreaterThan")
    public List<UserRequestDTO> getUsersWithVideoHistoryGreaterThan(@RequestParam("minHistorySize") int minHistorySize) {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersWithVideoHistoryGreaterThan(minHistorySize));
    }

    @GetMapping("/withVideoRatingsGreaterThan")
    public List<UserRequestDTO> getUsersWithVideoRatingsGreaterThan(@RequestParam("minRatingsSize") int minRatingsSize) {
        return userDTOConverter.convertUserEntityToDTO(userService.getUsersWithVideoRatingsGreaterThan(minRatingsSize));
    }
}
