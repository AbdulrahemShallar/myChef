package com.example.mychef.controller;

import com.example.mychef.dto.VideoCategoriesDTO;
import com.example.mychef.service.VideoCategoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/videoCategories")
public class VideoCategoriesController {

    final
    VideoCategoriesService videoCategoriesService;

    public VideoCategoriesController(VideoCategoriesService videoCategoriesService) {
        this.videoCategoriesService = videoCategoriesService;
    }

    @GetMapping(path = "/{id}")
    public VideoCategoriesDTO getVideoCategoryById(@PathVariable(value = "id") int id){
        return videoCategoriesService.getVideoCategoriesById(id);
    }

}
