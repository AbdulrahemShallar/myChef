package com.example.mychef.controller;


import com.example.mychef.dto.responseDTO.ImageCategoriesResponseDTO;
import com.example.mychef.dto.requestDTO.ImageCategoriesRequestDTO;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageCategoriesEntity addCategories(@RequestBody ImageCategoriesResponseDTO imageCategories){
        return imageCategoriesService.newCategory(imageCategories);
    }

    @PutMapping(path = "/id",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageCategoriesEntity updateCategoriesInfo(@RequestBody ImageCategoriesResponseDTO imageCategoriesUpdate,@RequestParam("id") Integer id){
        return imageCategoriesService.updateCategory(imageCategoriesUpdate,id);
    }


    @GetMapping(path = "/id")
    public ImageCategoriesRequestDTO getImageCategoryById(@RequestParam("id") int id){
        return imageCategoriesService.getImageCategoryById(id);
    }

    @GetMapping(path = "/all")
    public List<ImageCategoriesRequestDTO> getAllCategories(){
        return imageCategoriesService.getAllCategories();
    }

    @GetMapping("/withImageRecipes")
    public List<ImageCategoriesRequestDTO> getCategoriesWithImageRecipes() {
        return imageCategoriesService.getCategoriesWithImageRecipes();
    }

    @GetMapping("/byNameContaining")
    public List<ImageCategoriesRequestDTO> getCategoriesByNameContaining(@RequestParam("keyword") String keyword) {
        return imageCategoriesService.getCategoriesByNameContaining(keyword);
    }

    @GetMapping("/byPicture")
    public List<ImageCategoriesRequestDTO> getCategoriesByPicture(@RequestParam("pictureUrl") String pictureUrl) {
        return imageCategoriesService.getCategoriesByPicture(pictureUrl);
    }

    @GetMapping("/allOrderByNameAsc")
    public List<ImageCategoriesRequestDTO> getAllCategoriesOrderByNameAsc() {
        return imageCategoriesService.getAllCategoriesOrderByNameAsc();
    }

    @GetMapping("/allOrderByNameDesc")
    public List<ImageCategoriesRequestDTO> getAllCategoriesOrderByNameDesc() {
        return imageCategoriesService.getAllCategoriesOrderByNameDesc();
    }

    @GetMapping("/withMostImageRecipes")
    public List<ImageCategoriesRequestDTO> getCategoriesWithMostImageRecipes() {
        return imageCategoriesService.getCategoriesWithMostImageRecipes();
    }

    @GetMapping("/withNoImageRecipes")
    public List<ImageCategoriesRequestDTO> getCategoriesWithNoImageRecipes() {
        return imageCategoriesService.getCategoriesWithNoImageRecipes();
    }

    @GetMapping("/withImageRecipesAndPicture")
    public List<ImageCategoriesRequestDTO> getCategoriesWithImageRecipesAndPicture() {
        return imageCategoriesService.getCategoriesWithImageRecipesAndPicture();
    }

    @GetMapping("/excludingName")
    public List<ImageCategoriesRequestDTO> getCategoriesByExcludingName(@RequestParam("excludeKeyword") String excludeKeyword) {
        return imageCategoriesService.getCategoriesByExcludingName(excludeKeyword);
    }

    @GetMapping("/by-name-containing-order-by-image-recipe-countDesc")
    public List<ImageCategoriesRequestDTO> getCategoriesByNameContainingOrderByImageRecipeCountDesc(@RequestParam("keyword") String keyword) {
        return imageCategoriesService.getCategoriesByNameContainingOrderByImageRecipeCountDesc(keyword);
    }

}
