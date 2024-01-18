package com.example.mychef.controller;


import com.example.mychef.dto.UserDTO;
import com.example.mychef.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/getuser/{id}")
    public UserDTO getUser(@PathVariable(value = "id") int id){
        return userService.getUser(id);
    }

}
