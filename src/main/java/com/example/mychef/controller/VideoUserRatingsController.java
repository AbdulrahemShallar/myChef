package com.example.mychef.controller;

import com.example.mychef.dto.requestDTO.VideoUserRatingsRequestDTO;
import com.example.mychef.dto.responseDTO.VideoUserRatingsResponseDTO;
import com.example.mychef.model.VideoUserRatingsEntity;
import com.example.mychef.service.VideoUserRatingsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/videoUserRatings")
public class VideoUserRatingsController {

    final
    VideoUserRatingsService videoUserRatingsService;

    public VideoUserRatingsController(VideoUserRatingsService videoUserRatingsService) {
        this.videoUserRatingsService = videoUserRatingsService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoUserRatingsEntity addUserRating(@RequestBody VideoUserRatingsResponseDTO userRatings){
        return videoUserRatingsService.newUserRatings(userRatings);
    }

    // I need to do Service Class first

    @PutMapping(path = "/id",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public VideoUserRatingsEntity updateUserRatingsInfo(@RequestBody VideoUserRatingsResponseDTO userRatingsUpdate,@RequestParam("id") Integer id){
//        return videoUserRatingsService.updateUserHistory(userRatingsUpdate,id);
//    }

    @GetMapping(path = "/userAndRecipeId")
    public VideoUserRatingsRequestDTO getUserRatingsById(@RequestParam("userId") Integer userId, @RequestParam("recipeId") Integer recipeId) {
        return videoUserRatingsService.getUserRatingsById(userId,recipeId);
    }
    @GetMapping(path = "/userId")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByUserId(@RequestParam("userId") Integer userId) {
        return videoUserRatingsService.getUserRatingsByUserId(userId);
    }
    @GetMapping(path = "/recipeId")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByRecipeId(@RequestParam("recipeId") Integer recipeId) {
        return videoUserRatingsService.getUserRatingsByRecipeId(recipeId);
    }

    @GetMapping(path = "/all")
    public List<VideoUserRatingsRequestDTO> getAllUserRatings(){
        return videoUserRatingsService.getAllUserUserRatings();
    }

    @GetMapping("/by-rate")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByRate(@RequestParam("rate") int rate) {
        return videoUserRatingsService.getUserRatingsByRate(rate);
    }

    @GetMapping("/by-rate-between")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByRateBetween(@RequestParam("minRate") int minRate, @RequestParam("maxRate") int maxRate) {
        return videoUserRatingsService.getUserRatingsByRateBetween(minRate, maxRate);
    }

    @GetMapping("/by-date-range")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByDateRange(@RequestParam("startDate") Instant startDate, @RequestParam("endDate") Instant endDate) {
        return videoUserRatingsService.getUserRatingsByDateRange(startDate, endDate);
    }

    @GetMapping("/with-comments")
    public List<VideoUserRatingsRequestDTO> getRatingsWithComments() {
        return videoUserRatingsService.getRatingsWithComments();
    }

    @GetMapping("/without-comments")
    public List<VideoUserRatingsRequestDTO> getRatingsWithoutComments() {
        return videoUserRatingsService.getRatingsWithoutComments();
    }

    @GetMapping("/by-user-and-rate")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByUserAndRate(@RequestParam("userId") int userId, @RequestParam("rate") int rate) {
        return videoUserRatingsService.getUserRatingsByUserAndRate(userId, rate);
    }

    @GetMapping("/by-recipe-and-rate")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByRecipeAndRate(@RequestParam("recipeId") int recipeId, @RequestParam("rate") int rate) {
        return videoUserRatingsService.getUserRatingsByRecipeAndRate(recipeId, rate);
    }

    @GetMapping("/max-rated")
    public List<VideoUserRatingsRequestDTO> getMaxRatedRatings() {
        return videoUserRatingsService.getMaxRatedRatings();
    }

    @GetMapping("/min-rated")
    public List<VideoUserRatingsRequestDTO> getMinRatedRatings() {
        return videoUserRatingsService.getMinRatedRatings();
    }

}
