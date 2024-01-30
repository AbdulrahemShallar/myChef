package com.example.mychef.controller;

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

    final
    ImageRecipeService imageRecipeService;

    public ImageRecipeController(ImageRecipeService imageRecipeService) {
        this.imageRecipeService = imageRecipeService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageRecipeEntity addRecipe(@RequestBody ImageRecipeResponseDTO recipeDTO){
        return imageRecipeService.newRecipe(recipeDTO);
    }

    @PutMapping(path = "/id",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageRecipeEntity updateRecipeInfo(@RequestBody ImageRecipeResponseDTO imageRecipeUpdate, @RequestParam("id") Integer id){
        return imageRecipeService.updateRecipe(imageRecipeUpdate,id);
    }

    @RequestMapping(path = "/like")
    public ImageRecipeEntity addLikes(Integer id){
        return  imageRecipeService.updateRecipeLikes(id);
    }

    @GetMapping(path = "/byId")
    public ImageRecipeRequestDTO getImageRecipeById(@RequestParam("id") int id){
        return imageRecipeService.getImageRecipe(id);
    }

    @GetMapping(path = "/all")
    public List<ImageRecipeRequestDTO> getAllRecipe(){
        return imageRecipeService.getAllRecipe();
    }

    @GetMapping("/titleContain")
    public List<ImageRecipeRequestDTO> getRecipesWithTitleContaining(@RequestParam("keyword") String keyword) {
        return imageRecipeService.getRecipesWithTitleContaining(keyword);
    }

    @GetMapping("/byCategory")
    public List<ImageRecipeRequestDTO> getRecipesByCategory(@RequestParam("categoryId") int categoryId) {
        // I Have To Check This Part
        ImageCategoriesEntity category = new ImageCategoriesEntity();
        category.setId(categoryId);
        return imageRecipeService.getRecipesByCategory(category);
    }

    @GetMapping("/totalRateGreaterThan")
    public List<ImageRecipeRequestDTO> getRecipesByTotalRateGreaterThan(@RequestParam("rate") int rate) {
        return imageRecipeService.getRecipesByTotalRateGreaterThan(rate);
    }

    @GetMapping("/likesGreaterThan")
    public List<ImageRecipeRequestDTO> getRecipesByLikesGreaterThan(@RequestParam("likes") int likes) {
        return imageRecipeService.getRecipesByLikesGreaterThan(likes);
    }

    @GetMapping("/dateAfter")
    public List<ImageRecipeRequestDTO> getRecipesByDateAfter(@RequestParam("date") String date) {
        // Parse the date string to LocalDate if needed
        return imageRecipeService.getRecipesByDateAfter(LocalDate.parse(date));
    }

    @GetMapping("/orderByTotalRateDesc")
    public List<ImageRecipeRequestDTO> getRecipesOrderByTotalRateDesc() {
        return imageRecipeService.getRecipesOrderByTotalRateDesc();
    }

    @GetMapping("/mostLikedRecipe")
    public List<ImageRecipeRequestDTO> getMostLikedRecipe() {
        return imageRecipeService.getMostLikedRecipe();
    }

    @GetMapping("/minRatings")
    public List<ImageRecipeRequestDTO> getRecipesByMinRatings(@RequestParam("minRatings") int minRatings) {
        return imageRecipeService.getRecipesByMinRatings(minRatings);
    }

    @GetMapping("/totalRateBetween")
    public List<ImageRecipeRequestDTO> getRecipesByTotalRateBetween(
            @RequestParam("minRate") int minRate, @RequestParam("maxRate") int maxRate) {
        return imageRecipeService.getRecipesByTotalRateBetween(minRate, maxRate);
    }

    @GetMapping("/dateBetween")
    public List<ImageRecipeRequestDTO> getRecipesByDateBetween(
            @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        // Parse the date strings to LocalDate if needed
        return imageRecipeService.getRecipesByDateBetween(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    @GetMapping("/leastLikedRecipe")
    public List<ImageRecipeRequestDTO> getLeastLikedRecipe() {
        return imageRecipeService.getLeastLikedRecipe();
    }

    @GetMapping("/titleContainingIgnoreCase")
    public List<ImageRecipeRequestDTO> getRecipesWithTitleContainingIgnoreCase(@RequestParam("keyword") String keyword) {
        return imageRecipeService.getRecipesWithTitleContainingIgnoreCase(keyword);
    }

    @GetMapping("/topRatedRecipe")
    public List<ImageRecipeRequestDTO> getTopRatedRecipe() {
        return imageRecipeService.getTopRatedRecipe();
    }

    @GetMapping("/recipesCreatedToday")
    public List<ImageRecipeRequestDTO> getRecipesCreatedToday() {
        return imageRecipeService.getRecipesCreatedToday();
    }

    @GetMapping("/recipesWithNoLikes")
    public List<ImageRecipeRequestDTO> getRecipesWithNoLikes() {
        return imageRecipeService.getRecipesWithNoLikes();
    }

    @GetMapping("/latestRecipe")
    public List<ImageRecipeRequestDTO> getLatestRecipe() {
        return imageRecipeService.getLatestRecipe();
    }
}
