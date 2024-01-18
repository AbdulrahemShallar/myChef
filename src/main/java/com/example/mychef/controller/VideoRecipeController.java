package com.example.mychef.controller;

import com.example.mychef.dto.VideoRecipeDTO;
import com.example.mychef.service.VideoRecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/videoRecipe")
public class VideoRecipeController {

    final
    VideoRecipeService videoRecipeService;

    public VideoRecipeController(VideoRecipeService videoRecipeService) {
        this.videoRecipeService = videoRecipeService;
    }

    @GetMapping(path = "/{id}")
    public VideoRecipeDTO getVideoRecipeById(@PathVariable(value = "id") int id){
        return videoRecipeService.getVideoRecipeById(id);
    }

}
