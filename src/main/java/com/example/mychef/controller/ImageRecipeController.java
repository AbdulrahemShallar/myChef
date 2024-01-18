package com.example.mychef.controller;


import com.example.mychef.dto.ImageRecipeDTO;
import com.example.mychef.service.ImageRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/imagerecipe")
public class ImageRecipeController {

    @Autowired
    ImageRecipeService imageRecipeService;

    @GetMapping(path = "/{id}")
    public ImageRecipeDTO getImageRecipe(@PathVariable(value = "id") int id){
        return imageRecipeService.getImageRecipe(id);
    }
}
