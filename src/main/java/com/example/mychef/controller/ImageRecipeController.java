package com.example.mychef.controller;


import com.example.mychef.dto.ImageRecipeDTO;
import com.example.mychef.service.ImageRecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/imagerecipe")
public class ImageRecipeController {

    final
    ImageRecipeService imageRecipeService;

    public ImageRecipeController(ImageRecipeService imageRecipeService) {
        this.imageRecipeService = imageRecipeService;
    }

    @GetMapping(path = "/{id}")
    public ImageRecipeDTO getImageRecipeById(@PathVariable(value = "id") int id){
        return imageRecipeService.getImageRecipe(id);
    }
}
