package com.example.mychef.controller;


import com.example.mychef.dto.ImageRecipeDTO;
import com.example.mychef.model.ImageRecipeEntity;
import com.example.mychef.repository.ImageRecipeRepository;
import com.example.mychef.service.ImageRecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/imagerecipe")
public class ImageRecipeController {

    @Autowired
    ImageRecipeService imageRecipeService;

    @Autowired
    ImageRecipeRepository imageRecipeRepository;

    @GetMapping(path = "/{id}")
    public ImageRecipeDTO getImageRecipe(@PathVariable(value = "id") int id){
        log.info("we are here again !!!");
        ImageRecipeDTO  magerRecipe = imageRecipeService.getImageRecipe(id);
        return magerRecipe;
    }
}
