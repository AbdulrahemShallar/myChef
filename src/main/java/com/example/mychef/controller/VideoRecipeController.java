package com.example.mychef.controller;

import com.example.mychef.convert.VideoRecipeDTOConverter;
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

    final
    VideoRecipeDTOConverter videoRecipeDTOConverter;

    public VideoRecipeController(VideoRecipeService videoRecipeService, VideoRecipeDTOConverter videoRecipeDTOConverter) {
        this.videoRecipeService = videoRecipeService;
        this.videoRecipeDTOConverter = videoRecipeDTOConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoRecipeEntity addRecipe(@RequestBody VideoRecipeResponseDTO videoRecipe){
        return videoRecipeService.newRecipe(videoRecipeDTOConverter.convertVideoRecipeDTOToEntity(videoRecipe));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoRecipeEntity updateRecipeInfo(@RequestBody VideoRecipeResponseDTO videoRecipeUpdate,@RequestParam("id") Integer id){
        VideoRecipeEntity videoRecipeEntity = videoRecipeDTOConverter.convertVideoRecipeDTOToEntity(videoRecipeUpdate);

        if(videoRecipeUpdate.getCategoryId() > 0) {
            VideoCategoriesEntity categoriesEntity= new VideoCategoriesEntity();
            categoriesEntity.setId(videoRecipeUpdate.getId());
            videoRecipeEntity.setCategory(categoriesEntity);
        }

        if(videoRecipeUpdate.getChefId() > 0){
            ChefEntity chef = new ChefEntity();
            chef.setId(videoRecipeUpdate.getId());
            videoRecipeEntity.setChef(chef);
        }
        return videoRecipeService.updateRecipe(videoRecipeDTOConverter.convertVideoRecipeDTOToEntity(videoRecipeUpdate),id);
    }
    @PutMapping(path = "/like",consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoRecipeEntity addLikes(@RequestParam("recipeId") Integer recipeId){
        return  videoRecipeService.updateRecipeLikes(recipeId);
    }


    @GetMapping(path = "/{id}")
    public VideoRecipeRequestDTO getVideoRecipeById(@PathVariable(value = "id") int id){
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getVideoRecipeById(id));
    }
    @GetMapping(path = "/all")
    public List<VideoRecipeRequestDTO> getAllRecipe(){
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getAllRecipe());
    }
    @GetMapping("/titleContain")
    public List<VideoRecipeRequestDTO> getRecipesWithTitleContaining(@RequestParam("keyword") String keyword) {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesWithTitleContaining(keyword));
    }

    @GetMapping("/byCategory")
    public List<VideoRecipeRequestDTO> getRecipesByCategory(@RequestParam("categoryId") int categoryId) {
        // I Have To Check This Part
        VideoCategoriesEntity category = new VideoCategoriesEntity();
        category.setId(categoryId);
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesByCategory(category));
    }

    @GetMapping("/totalRateGreaterThan")
    public List<VideoRecipeRequestDTO> getRecipesByTotalRateGreaterThan(@RequestParam("rate") int rate) {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesByTotalRateGreaterThan(rate));
    }

    @GetMapping("/likesGreaterThan")
    public List<VideoRecipeRequestDTO> getRecipesByLikesGreaterThan(@RequestParam("likes") int likes) {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesByLikesGreaterThan(likes));
    }

    @GetMapping("/dateAfter")
    public List<VideoRecipeRequestDTO> getRecipesByDateAfter(@RequestParam("date") String date) {
        // Parse the date string to LocalDate if needed
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesByDateAfter(LocalDate.parse(date)));
    }

    @GetMapping("/orderByTotalRateDesc")
    public List<VideoRecipeRequestDTO> getRecipesOrderByTotalRateDesc() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesOrderByTotalRateDesc());
    }

    @GetMapping("/mostLikedRecipe")
    public List<VideoRecipeRequestDTO> getMostLikedRecipe() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getMostLikedRecipe());
    }

    @GetMapping("/minRatings")
    public List<VideoRecipeRequestDTO> getRecipesByMinRatings(@RequestParam("minRatings") int minRatings) {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesByMinRatings(minRatings));
    }

    @GetMapping("/totalRateBetween")
    public List<VideoRecipeRequestDTO> getRecipesByTotalRateBetween(
            @RequestParam("minRate") int minRate, @RequestParam("maxRate") int maxRate) {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesByTotalRateBetween(minRate, maxRate));
    }

    @GetMapping("/dateBetween")
    public List<VideoRecipeRequestDTO> getRecipesByDateBetween(
            @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        // Parse the date strings to LocalDate if needed
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesByDateBetween(LocalDate.parse(startDate), LocalDate.parse(endDate)));
    }

    @GetMapping("/leastLikedRecipe")
    public List<VideoRecipeRequestDTO> getLeastLikedRecipe() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getLeastLikedRecipe());
    }

    @GetMapping("/titleContainingIgnoreCase")
    public List<VideoRecipeRequestDTO> getRecipesWithTitleContainingIgnoreCase(@RequestParam("keyword") String keyword) {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesWithTitleContainingIgnoreCase(keyword));
    }

    @GetMapping("/topRatedRecipe")
    public List<VideoRecipeRequestDTO> getTopRatedRecipe() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getTopRatedRecipe());
    }

    @GetMapping("/recipesCreatedToday")
    public List<VideoRecipeRequestDTO> getRecipesCreatedToday() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesCreatedToday());
    }

    @GetMapping("/recipesWithNoLikes")
    public List<VideoRecipeRequestDTO> getRecipesWithNoLikes() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesWithNoLikes());
    }

    @GetMapping("/latestRecipe")
    public List<VideoRecipeRequestDTO> getLatestRecipe() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getLatestRecipe());
    }

    @GetMapping("/byChef")
    public List<VideoRecipeRequestDTO> getRecipesByChef(@RequestParam("chefId") int chefId) {
        ChefEntity chef = new ChefEntity();
        chef.setId(chefId);
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesByChef(chef));
    }

    @GetMapping("/byLink")
    public List<VideoRecipeRequestDTO> getRecipesByLink(@RequestParam("link") String link) {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesByLink(link));
    }

    @GetMapping("/by-category-and-total-rate-between")
    public List<VideoRecipeRequestDTO> getRecipesByCategoryAndTotalRateBetween(
            @RequestParam("categoryId") int categoryId,
            @RequestParam("minRate") int minRate,
            @RequestParam("maxRate") int maxRate) {
        VideoCategoriesEntity category = new VideoCategoriesEntity();
        category.setId(categoryId);
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getRecipesByCategoryAndTotalRateBetween(category, minRate, maxRate));
    }

    @GetMapping("/latestByChef")
    public List<VideoRecipeRequestDTO> getLatestRecipeByChef() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getLatestRecipeByChef());
    }

    @GetMapping("/oldestByChef")
    public List<VideoRecipeRequestDTO> getOldestRecipeByChef() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getOldestRecipeByChef());
    }

    @GetMapping("/lowestRated")
    public List<VideoRecipeRequestDTO> getLowestRatedRecipe() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getLowestRatedRecipe());
    }

    @GetMapping("/highestRated")
    public List<VideoRecipeRequestDTO> getHighestRatedRecipe() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getHighestRatedRecipe());
    }

    @GetMapping("/unrated")
    public List<VideoRecipeRequestDTO> getUnratedRecipes() {
        return videoRecipeDTOConverter.convertVideoRecipeEntityToDTO(videoRecipeService.getUnratedRecipes());
    }

}