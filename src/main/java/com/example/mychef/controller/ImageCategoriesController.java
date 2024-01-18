package com.example.mychef.controller;


import com.example.mychef.dto.ImageCategoriesDTO;
import com.example.mychef.service.ImageCategoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/imageCategories")
public class ImageCategoriesController {

    final
    ImageCategoriesService imageCategoriesService;

    public ImageCategoriesController(ImageCategoriesService imageCategoriesService) {
        this.imageCategoriesService = imageCategoriesService;
    }

    @GetMapping(path = "/{id}")
    public ImageCategoriesDTO getImageCategoryById(@PathVariable(value = "id") int id){
        return imageCategoriesService.getImageCategoryById(id);
    }
}
