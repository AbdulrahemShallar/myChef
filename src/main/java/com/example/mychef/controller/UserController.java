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

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity addUser(@RequestBody UserResponseDTO user){
        return userService.newUser(user);
     }

    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity updateUserInfo(@RequestBody UserResponseDTO userUpdate,@PathVariable(name = "id") Integer id){
        return userService.updateUser(userUpdate,id);
    }

    @GetMapping(path = "/{id}")
    public UserRequestDTO getUserById(@PathVariable(name = "id") Integer id) {
        return userService.getUserById(id);
    }
    @GetMapping(path = "/all")
    public List<UserRequestDTO> getAllUsers(){
        return userService.getAllUser();
    }

}
