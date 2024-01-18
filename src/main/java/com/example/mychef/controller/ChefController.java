package com.example.mychef.controller;

import com.example.mychef.dto.ChefDTO;
import com.example.mychef.service.ChefService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chef")
public class ChefController {

    final
    ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    @GetMapping(path = "/{id}")
    public ChefDTO getChefById(@PathVariable(value = "id") int id){
        return chefService.getChefById(id);
    }
}
