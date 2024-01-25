package com.example.mychef.controller;

import com.example.mychef.dto.requestDTO.VideoCategoriesRequestDTO;
import com.example.mychef.dto.responseDTO.VideoCategoriesResponseDTO;
import com.example.mychef.model.VideoCategoriesEntity;
import com.example.mychef.service.VideoCategoriesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videoCategories")
public class VideoCategoriesController {

    final
    VideoCategoriesService videoCategoriesService;

    public VideoCategoriesController(VideoCategoriesService videoCategoriesService) {
        this.videoCategoriesService = videoCategoriesService;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoCategoriesEntity addCategories(@RequestBody VideoCategoriesResponseDTO videoCategories){
        return videoCategoriesService.newCategory(videoCategories);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoCategoriesEntity updateCategoriesInfo(@RequestBody VideoCategoriesResponseDTO videoCategoriesUpdate,@PathVariable(name = "id") Integer id){
        return videoCategoriesService.updateCategory(videoCategoriesUpdate,id);
    }

    @GetMapping(path = "/{id}")
    public VideoCategoriesRequestDTO getVideoCategoryById(@PathVariable(value = "id") int id){
        return videoCategoriesService.getVideoCategoriesById(id);
    }

    @GetMapping(path = "/all")
    public List<VideoCategoriesRequestDTO> getAllCategories(){
        return videoCategoriesService.getAllCategories();
    }


}
