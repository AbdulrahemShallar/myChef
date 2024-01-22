package com.example.mychef.controller;


import com.example.mychef.dto.ImageCategoriesDTO;
import com.example.mychef.model.ImageCategoriesEntity;
import com.example.mychef.service.ImageCategoriesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imageCategories")
public class ImageCategoriesController {

    final
    ImageCategoriesService imageCategoriesService;

    public ImageCategoriesController(ImageCategoriesService imageCategoriesService) {
        this.imageCategoriesService = imageCategoriesService;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageCategoriesEntity addCategories(@RequestBody ImageCategoriesEntity imageCategories){
        return imageCategoriesService.newCategory(imageCategories);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageCategoriesEntity updateCategoriesInfo(@RequestBody ImageCategoriesEntity imageCategoriesUpdate,@PathVariable(name = "id") Integer id){
        return imageCategoriesService.updateCategory(imageCategoriesUpdate,id);
    }


    @GetMapping(path = "/{id}")
    public ImageCategoriesDTO getImageCategoryById(@PathVariable(value = "id") int id){
        return imageCategoriesService.getImageCategoryById(id);
    }

    @GetMapping(path = "/all")
    public List<ImageCategoriesDTO> getAllCategories(){
        return imageCategoriesService.getAllCategories();
    }
}
