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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoCategoriesEntity addCategories(@RequestBody VideoCategoriesResponseDTO videoCategories){
        return videoCategoriesService.newCategory(videoCategories);
    }

    @PutMapping(path = "/id",consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoCategoriesEntity updateCategoriesInfo(@RequestBody VideoCategoriesResponseDTO videoCategoriesUpdate,@RequestParam("id") Integer id){
        return videoCategoriesService.updateCategory(videoCategoriesUpdate,id);
    }

    @GetMapping(path = "/id")
    public VideoCategoriesRequestDTO getVideoCategoryById(@RequestParam("id") int id){
        return videoCategoriesService.getVideoCategoriesById(id);
    }

    @GetMapping(path = "/all")
    public List<VideoCategoriesRequestDTO> getAllCategories(){
        return videoCategoriesService.getAllCategories();
    }

    @GetMapping("/withVideoRecipes")
    public List<VideoCategoriesRequestDTO> getCategoriesWithVideoRecipes() {
        return videoCategoriesService.getCategoriesWithVideoRecipes();
    }

    @GetMapping("/byNameContaining")
    public List<VideoCategoriesRequestDTO> getCategoriesByNameContaining(@RequestParam("keyword") String keyword) {
        return videoCategoriesService.getCategoriesByNameContaining(keyword);
    }

    @GetMapping("/byPicture")
    public List<VideoCategoriesRequestDTO> getCategoriesByPicture(@RequestParam("pictureUrl") String pictureUrl) {
        return videoCategoriesService.getCategoriesByPicture(pictureUrl);
    }

    @GetMapping("/allOrderByNameAsc")
    public List<VideoCategoriesRequestDTO> getAllCategoriesOrderByNameAsc() {
        return videoCategoriesService.getAllCategoriesOrderByNameAsc();
    }

    @GetMapping("/allOrderByNameDesc")
    public List<VideoCategoriesRequestDTO> getAllCategoriesOrderByNameDesc() {
        return videoCategoriesService.getAllCategoriesOrderByNameDesc();
    }

    @GetMapping("/withMostVideoRecipes")
    public List<VideoCategoriesRequestDTO> getCategoriesWithMostVideoRecipes() {
        return videoCategoriesService.getCategoriesWithMostVideoRecipes();
    }

    @GetMapping("/withNoVideoRecipes")
    public List<VideoCategoriesRequestDTO> getCategoriesWithNoVideoRecipes() {
        return videoCategoriesService.getCategoriesWithNoVideoRecipes();
    }

    @GetMapping("/withVideoRecipesAndPicture")
    public List<VideoCategoriesRequestDTO> getCategoriesWithVideoRecipesAndPicture() {
        return videoCategoriesService.getCategoriesWithVideoRecipesAndPicture();
    }

    @GetMapping("/excludingName")
    public List<VideoCategoriesRequestDTO> getCategoriesByExcludingName(@RequestParam("excludeKeyword") String excludeKeyword) {
        return videoCategoriesService.getCategoriesByExcludingName(excludeKeyword);
    }

    @GetMapping("/by-name-containing-order-by-video-recipe-countDesc")
    public List<VideoCategoriesRequestDTO> getCategoriesByNameContainingOrderByVideoRecipeCountDesc(@RequestParam("keyword") String keyword) {
        return videoCategoriesService.getCategoriesByNameContainingOrderByVideoRecipeCountDesc(keyword);
    }

}
