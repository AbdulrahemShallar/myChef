package com.example.mychef.controller;


import com.example.mychef.dto.UserDTO;
import com.example.mychef.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}")
    public UserDTO getUserById(@PathVariable(value = "id") int id){
        return userService.getUserById(id);
    }

}
