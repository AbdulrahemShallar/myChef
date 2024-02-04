package com.example.mychef.controller;


import com.example.mychef.convert.ImageCategoriesDTOConverter;
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

    final ImageCategoriesService imageCategoriesService;

    final ImageCategoriesDTOConverter imageCategoriesDTOConverter;

    public ImageCategoriesController(ImageCategoriesService imageCategoriesService,ImageCategoriesDTOConverter imageCategoriesDTOConverter) {
        this.imageCategoriesService = imageCategoriesService;
        this.imageCategoriesDTOConverter = imageCategoriesDTOConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageCategoriesEntity addCategories(@RequestBody ImageCategoriesResponseDTO imageCategories){
        return imageCategoriesService.newCategory(imageCategoriesDTOConverter.convertImageCategoriesDTOToDEntity(imageCategories));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageCategoriesEntity updateCategoriesInfo(@RequestBody ImageCategoriesResponseDTO imageCategoriesUpdate,@RequestParam("id") Integer id){
        return imageCategoriesService.updateCategory(imageCategoriesDTOConverter.convertImageCategoriesDTOToDEntity(imageCategoriesUpdate),id);
    }


    @GetMapping(path = "/id")
    public ImageCategoriesRequestDTO getImageCategoryById(@RequestParam("id") int id){
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getImageCategoryById(id));
    }

    @GetMapping(path = "/all")
    public List<ImageCategoriesRequestDTO> getAllCategories(){
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getAllCategories());
    }

    @GetMapping("/withImageRecipes")
    public List<ImageCategoriesRequestDTO> getCategoriesWithImageRecipes() {
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getCategoriesWithImageRecipes());
    }

    @GetMapping("/byNameContaining")
    public List<ImageCategoriesRequestDTO> getCategoriesByNameContaining(@RequestParam("keyword") String keyword) {
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getCategoriesByNameContaining(keyword));
    }

    @GetMapping("/byPicture")
    public List<ImageCategoriesRequestDTO> getCategoriesByPicture(@RequestParam("pictureUrl") String pictureUrl) {
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getCategoriesByPicture(pictureUrl));
    }

    @GetMapping("/allOrderByNameAsc")
    public List<ImageCategoriesRequestDTO> getAllCategoriesOrderByNameAsc() {
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getAllCategoriesOrderByNameAsc());
    }

    @GetMapping("/allOrderByNameDesc")
    public List<ImageCategoriesRequestDTO> getAllCategoriesOrderByNameDesc() {
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getAllCategoriesOrderByNameDesc());
    }

    @GetMapping("/withMostImageRecipes")
    public List<ImageCategoriesRequestDTO> getCategoriesWithMostImageRecipes() {
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getCategoriesWithMostImageRecipes());
    }

    @GetMapping("/withNoImageRecipes")
    public List<ImageCategoriesRequestDTO> getCategoriesWithNoImageRecipes() {
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getCategoriesWithNoImageRecipes());
    }

    @GetMapping("/withImageRecipesAndPicture")
    public List<ImageCategoriesRequestDTO> getCategoriesWithImageRecipesAndPicture() {
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getCategoriesWithImageRecipesAndPicture());
    }

    @GetMapping("/excludingName")
    public List<ImageCategoriesRequestDTO> getCategoriesByExcludingName(@RequestParam("excludeKeyword") String excludeKeyword) {
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getCategoriesByExcludingName(excludeKeyword));
    }

    @GetMapping("/by-name-containing-order-by-image-recipe-countDesc")
    public List<ImageCategoriesRequestDTO> getCategoriesByNameContainingOrderByImageRecipeCountDesc(@RequestParam("keyword") String keyword) {
        return imageCategoriesDTOConverter.convertImageCategoriesEntityToDTO(imageCategoriesService.getCategoriesByNameContainingOrderByImageRecipeCountDesc(keyword));
    }

}
