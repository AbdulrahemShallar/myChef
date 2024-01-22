package com.example.mychef.controller;

import com.example.mychef.dto.ImageRecipeDTO;
import com.example.mychef.model.ImageRecipeEntity;
import com.example.mychef.service.ImageRecipeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/imagerecipe")
public class ImageRecipeController {

    final
    ImageRecipeService imageRecipeService;

    public ImageRecipeController(ImageRecipeService imageRecipeService) {
        this.imageRecipeService = imageRecipeService;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageRecipeEntity addRecipe(@RequestBody ImageRecipeEntity imageRecipe){
        return imageRecipeService.newRecipe(imageRecipe);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageRecipeEntity updateRecipeInfo(@RequestBody ImageRecipeEntity imageRecipeUpdate,@PathVariable(name = "id") Integer id){
        return imageRecipeService.updateRecipe(imageRecipeUpdate,id);
    }

    @RequestMapping(path = "/like")
    public ImageRecipeEntity addLikes(Integer id){
        return  imageRecipeService.updateRecipeLikes(id);
    }

    @GetMapping(path = "/{id}")
    public ImageRecipeDTO getImageRecipeById(@PathVariable(value = "id") int id){
        return imageRecipeService.getImageRecipe(id);
    }

    @GetMapping(path = "/all")
    public List<ImageRecipeDTO> getAllRecipe(){
        return imageRecipeService.getAllRecipe();
    }
}
