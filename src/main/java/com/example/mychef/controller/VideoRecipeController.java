package com.example.mychef.controller;

import com.example.mychef.dto.requestDTO.VideoRecipeRequestDTO;
import com.example.mychef.dto.responseDTO.VideoRecipeResponseDTO;
import com.example.mychef.model.ChefEntity;
import com.example.mychef.model.VideoCategoriesEntity;
import com.example.mychef.model.VideoRecipeEntity;
import com.example.mychef.service.VideoRecipeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/videoRecipe")
public class VideoRecipeController {

    final
    VideoRecipeService videoRecipeService;

    public VideoRecipeController(VideoRecipeService videoRecipeService) {
        this.videoRecipeService = videoRecipeService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoRecipeEntity addRecipe(@RequestBody VideoRecipeResponseDTO videoRecipe){
        return videoRecipeService.newRecipe(videoRecipe);
    }

    @PutMapping(path = "/id",consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoRecipeEntity updateRecipeInfo(@RequestBody VideoRecipeResponseDTO videoRecipeUpdate,@RequestParam("id") Integer id){
        return videoRecipeService.updateRecipe(videoRecipeUpdate,id);
    }
    @PutMapping(path = "/like",consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoRecipeEntity addLikes(@RequestParam("recipeId") Integer recipeId){
        return  videoRecipeService.updateRecipeLikes(recipeId);
    }


    @GetMapping(path = "/{id}")
    public VideoRecipeRequestDTO getVideoRecipeById(@PathVariable(value = "id") int id){
        return videoRecipeService.getVideoRecipeById(id);
    }
    @GetMapping(path = "/all")
    public List<VideoRecipeRequestDTO> getAllRecipe(){
        return videoRecipeService.getAllRecipe();
    }
    @GetMapping("/titleContain")
    public List<VideoRecipeRequestDTO> getRecipesWithTitleContaining(@RequestParam("keyword") String keyword) {
        return videoRecipeService.getRecipesWithTitleContaining(keyword);
    }

    @GetMapping("/byCategory")
    public List<VideoRecipeRequestDTO> getRecipesByCategory(@RequestParam("categoryId") int categoryId) {
        // I Have To Check This Part
        VideoCategoriesEntity category = new VideoCategoriesEntity();
        category.setId(categoryId);
        return videoRecipeService.getRecipesByCategory(category);
    }

    @GetMapping("/totalRateGreaterThan")
    public List<VideoRecipeRequestDTO> getRecipesByTotalRateGreaterThan(@RequestParam("rate") int rate) {
        return videoRecipeService.getRecipesByTotalRateGreaterThan(rate);
    }

    @GetMapping("/likesGreaterThan")
    public List<VideoRecipeRequestDTO> getRecipesByLikesGreaterThan(@RequestParam("likes") int likes) {
        return videoRecipeService.getRecipesByLikesGreaterThan(likes);
    }

    @GetMapping("/dateAfter")
    public List<VideoRecipeRequestDTO> getRecipesByDateAfter(@RequestParam("date") String date) {
        // Parse the date string to LocalDate if needed
        return videoRecipeService.getRecipesByDateAfter(LocalDate.parse(date));
    }

    @GetMapping("/orderByTotalRateDesc")
    public List<VideoRecipeRequestDTO> getRecipesOrderByTotalRateDesc() {
        return videoRecipeService.getRecipesOrderByTotalRateDesc();
    }

    @GetMapping("/mostLikedRecipe")
    public List<VideoRecipeRequestDTO> getMostLikedRecipe() {
        return videoRecipeService.getMostLikedRecipe();
    }

    @GetMapping("/minRatings")
    public List<VideoRecipeRequestDTO> getRecipesByMinRatings(@RequestParam("minRatings") int minRatings) {
        return videoRecipeService.getRecipesByMinRatings(minRatings);
    }

    @GetMapping("/totalRateBetween")
    public List<VideoRecipeRequestDTO> getRecipesByTotalRateBetween(
            @RequestParam("minRate") int minRate, @RequestParam("maxRate") int maxRate) {
        return videoRecipeService.getRecipesByTotalRateBetween(minRate, maxRate);
    }

    @GetMapping("/dateBetween")
    public List<VideoRecipeRequestDTO> getRecipesByDateBetween(
            @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        // Parse the date strings to LocalDate if needed
        return videoRecipeService.getRecipesByDateBetween(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    @GetMapping("/leastLikedRecipe")
    public List<VideoRecipeRequestDTO> getLeastLikedRecipe() {
        return videoRecipeService.getLeastLikedRecipe();
    }

    @GetMapping("/titleContainingIgnoreCase")
    public List<VideoRecipeRequestDTO> getRecipesWithTitleContainingIgnoreCase(@RequestParam("keyword") String keyword) {
        return videoRecipeService.getRecipesWithTitleContainingIgnoreCase(keyword);
    }

    @GetMapping("/topRatedRecipe")
    public List<VideoRecipeRequestDTO> getTopRatedRecipe() {
        return videoRecipeService.getTopRatedRecipe();
    }

    @GetMapping("/recipesCreatedToday")
    public List<VideoRecipeRequestDTO> getRecipesCreatedToday() {
        return videoRecipeService.getRecipesCreatedToday();
    }

    @GetMapping("/recipesWithNoLikes")
    public List<VideoRecipeRequestDTO> getRecipesWithNoLikes() {
        return videoRecipeService.getRecipesWithNoLikes();
    }

    @GetMapping("/latestRecipe")
    public List<VideoRecipeRequestDTO> getLatestRecipe() {
        return videoRecipeService.getLatestRecipe();
    }

    @GetMapping("/byChef")
    public List<VideoRecipeRequestDTO> getRecipesByChef(@RequestParam("chefId") int chefId) {
        ChefEntity chef = new ChefEntity();
        chef.setId(chefId);
        return videoRecipeService.getRecipesByChef(chef);
    }

    @GetMapping("/byLink")
    public List<VideoRecipeRequestDTO> getRecipesByLink(@RequestParam("link") String link) {
        return videoRecipeService.getRecipesByLink(link);
    }

    @GetMapping("/by-category-and-total-rate-between")
    public List<VideoRecipeRequestDTO> getRecipesByCategoryAndTotalRateBetween(
            @RequestParam("categoryId") int categoryId,
            @RequestParam("minRate") int minRate,
            @RequestParam("maxRate") int maxRate) {
        VideoCategoriesEntity category = new VideoCategoriesEntity();
        category.setId(categoryId);
        return videoRecipeService.getRecipesByCategoryAndTotalRateBetween(category, minRate, maxRate);
    }

    @GetMapping("/latestByChef")
    public List<VideoRecipeRequestDTO> getLatestRecipeByChef() {
        return videoRecipeService.getLatestRecipeByChef();
    }

    @GetMapping("/oldestByChef")
    public List<VideoRecipeRequestDTO> getOldestRecipeByChef() {
        return videoRecipeService.getOldestRecipeByChef();
    }

    @GetMapping("/lowestRated")
    public List<VideoRecipeRequestDTO> getLowestRatedRecipe() {
        return videoRecipeService.getLowestRatedRecipe();
    }

    @GetMapping("/highestRated")
    public List<VideoRecipeRequestDTO> getHighestRatedRecipe() {
        return videoRecipeService.getHighestRatedRecipe();
    }

    @GetMapping("/unrated")
    public List<VideoRecipeRequestDTO> getUnratedRecipes() {
        return videoRecipeService.getUnratedRecipes();
    }
}