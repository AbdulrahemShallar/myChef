package com.example.mychef.controller;

import com.example.mychef.convert.ImageRecipeDTOConverter;
import com.example.mychef.dto.requestDTO.ImageRecipeRequestDTO;
import com.example.mychef.dto.responseDTO.ImageRecipeResponseDTO;
import com.example.mychef.model.ImageCategoriesEntity;
import com.example.mychef.model.ImageRecipeEntity;
import com.example.mychef.service.ImageRecipeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/imagerecipe")
public class ImageRecipeController {

    final  ImageRecipeService imageRecipeService;

    final  ImageRecipeDTOConverter imageRecipeDTOConverter;


    public ImageRecipeController(ImageRecipeService imageRecipeService,ImageRecipeDTOConverter imageRecipeDTOConverter) {
        this.imageRecipeService = imageRecipeService;
        this.imageRecipeDTOConverter = imageRecipeDTOConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageRecipeEntity addRecipe(@RequestBody ImageRecipeResponseDTO recipeDTO){
     ImageRecipeEntity imageRecipeEntity = imageRecipeDTOConverter.convertImageRecipeDTOtoEntity(recipeDTO);
        return imageRecipeService.newRecipe(imageRecipeEntity);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageRecipeEntity updateRecipeInfo(@RequestBody ImageRecipeResponseDTO imageRecipeUpdate, @RequestParam("id") int id){
        return imageRecipeService.updateRecipe(imageRecipeDTOConverter.convertImageRecipeDTOtoEntity(imageRecipeUpdate),id);
    }

    @RequestMapping(path = "/like")
    public ImageRecipeEntity addLikes(Integer id){
        return  imageRecipeService.updateRecipeLikes(id);
    }

    @GetMapping(path = "/byId")
    public ImageRecipeRequestDTO getImageRecipeById(@RequestParam("id") int id){
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getImageRecipe(id));
    }

    @GetMapping(path = "/all")
    public List<ImageRecipeRequestDTO> getAllRecipe(){
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getAllRecipe());
    }

    @GetMapping("/titleContain")
    public List<ImageRecipeRequestDTO> getRecipesWithTitleContaining(@RequestParam("keyword") String keyword) {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesWithTitleContaining(keyword));
    }

    @GetMapping("/byCategory")
    public List<ImageRecipeRequestDTO> getRecipesByCategory(@RequestParam("categoryId") int categoryId) {
        // I Have To Check This Part
        ImageCategoriesEntity category = new ImageCategoriesEntity();
        category.setId(categoryId);
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesByCategory(category));
    }

    @GetMapping("/totalRateGreaterThan")
    public List<ImageRecipeRequestDTO> getRecipesByTotalRateGreaterThan(@RequestParam("rate") int rate) {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesByTotalRateGreaterThan(rate));
    }

    @GetMapping("/likesGreaterThan")
    public List<ImageRecipeRequestDTO> getRecipesByLikesGreaterThan(@RequestParam("likes") int likes) {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesByLikesGreaterThan(likes));
    }

    @GetMapping("/dateAfter")
    public List<ImageRecipeRequestDTO> getRecipesByDateAfter(@RequestParam("date") String date) {
        // Parse the date string to LocalDate if needed
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesByDateAfter(LocalDate.parse(date)));
    }

    @GetMapping("/orderByTotalRateDesc")
    public List<ImageRecipeRequestDTO> getRecipesOrderByTotalRateDesc() {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesOrderByTotalRateDesc());
    }

    @GetMapping("/mostLikedRecipe")
    public List<ImageRecipeRequestDTO> getMostLikedRecipe() {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getMostLikedRecipe());
    }

    @GetMapping("/minRatings")
    public List<ImageRecipeRequestDTO> getRecipesByMinRatings(@RequestParam("minRatings") int minRatings) {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesByMinRatings(minRatings));
    }

    @GetMapping("/totalRateBetween")
    public List<ImageRecipeRequestDTO> getRecipesByTotalRateBetween(
            @RequestParam("minRate") int minRate, @RequestParam("maxRate") int maxRate) {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesByTotalRateBetween(minRate, maxRate));
    }

    @GetMapping("/dateBetween")
    public List<ImageRecipeRequestDTO> getRecipesByDateBetween(
            @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        // Parse the date strings to LocalDate if needed
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesByDateBetween(LocalDate.parse(startDate), LocalDate.parse(endDate)));
    }

    @GetMapping("/leastLikedRecipe")
    public List<ImageRecipeRequestDTO> getLeastLikedRecipe() {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getLeastLikedRecipe());
    }

    @GetMapping("/titleContainingIgnoreCase")
    public List<ImageRecipeRequestDTO> getRecipesWithTitleContainingIgnoreCase(@RequestParam("keyword") String keyword) {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesWithTitleContainingIgnoreCase(keyword));
    }

    @GetMapping("/topRatedRecipe")
    public List<ImageRecipeRequestDTO> getTopRatedRecipe() {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getTopRatedRecipe());
    }

    @GetMapping("/recipesCreatedToday")
    public List<ImageRecipeRequestDTO> getRecipesCreatedToday() {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesCreatedToday());
    }

    @GetMapping("/recipesWithNoLikes")
    public List<ImageRecipeRequestDTO> getRecipesWithNoLikes() {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getRecipesWithNoLikes());
    }

    @GetMapping("/latestRecipe")
    public List<ImageRecipeRequestDTO> getLatestRecipe() {
        return imageRecipeDTOConverter.convertImageRecipeEntityToDTO(imageRecipeService.getLatestRecipe());
    }
}
