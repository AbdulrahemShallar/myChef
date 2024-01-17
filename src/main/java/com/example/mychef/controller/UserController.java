package com.example.mychef.controller;


import com.example.mychef.dto.UserDTO;
import com.example.mychef.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/getuser/{id}")
    public UserDTO getUser(@PathVariable(value = "id") int id){
        log.info("we are here !!!");
        return userService.getUser(id);
    }

}
