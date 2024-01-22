package com.example.mychef.controller;

import com.example.mychef.dto.VideoRecipeDTO;
import com.example.mychef.model.VideoRecipeEntity;
import com.example.mychef.service.VideoRecipeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videoRecipe")
public class VideoRecipeController {

    final
    VideoRecipeService videoRecipeService;

    public VideoRecipeController(VideoRecipeService videoRecipeService) {
        this.videoRecipeService = videoRecipeService;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoRecipeEntity addRecipe(@RequestBody VideoRecipeEntity videoRecipe){
        return videoRecipeService.newRecipe(videoRecipe);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoRecipeEntity updateRecipeInfo(@RequestBody VideoRecipeEntity videoRecipeUpdate,@PathVariable(name = "id") Integer id){
        return videoRecipeService.updateRecipe(videoRecipeUpdate,id);
    }
    @RequestMapping(path = "/like")
    public VideoRecipeEntity addLikes(Integer id){
        return  videoRecipeService.updateRecipeLikes(id);
    }


    @GetMapping(path = "/{id}")
    public VideoRecipeDTO getVideoRecipeById(@PathVariable(value = "id") int id){
        return videoRecipeService.getVideoRecipeById(id);
    }
    @GetMapping(path = "/all")
    public List<VideoRecipeDTO> getAllRecipe(){
        return videoRecipeService.getAllRecipe();
    }

}
