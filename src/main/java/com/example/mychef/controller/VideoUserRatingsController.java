package com.example.mychef.controller;

import com.example.mychef.convert.VideoUserRatingsDTOConverter;
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

    final
    VideoUserRatingsDTOConverter videoUserRatingsDTOConverter;

    public VideoUserRatingsController(VideoUserRatingsService videoUserRatingsService, VideoUserRatingsDTOConverter videoUserRatingsDTOConverter) {
        this.videoUserRatingsService = videoUserRatingsService;
        this.videoUserRatingsDTOConverter = videoUserRatingsDTOConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoUserRatingsEntity addUserRating(@RequestBody VideoUserRatingsResponseDTO userRatings){
        return videoUserRatingsService.newUserRatings(videoUserRatingsDTOConverter.convertVideoUserRatingsDTOToEntity(userRatings));
    }

    // I need to do Service Class first

//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public VideoUserRatingsEntity updateUserRatingsInfo(@RequestBody VideoUserRatingsResponseDTO userRatingsUpdate,@RequestParam("id") Integer id){
//        return videoUserRatingsService.updateUserHistory(videoUserRatingsDTOConverter.convertVideoUserRatingsDTOToEntity(userRatingsUpdate),id);
//    }

    @GetMapping(path = "/userAndRecipeId")
    public VideoUserRatingsRequestDTO getUserRatingsById(@RequestParam("userId") Integer userId, @RequestParam("recipeId") Integer recipeId) {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO((videoUserRatingsService.getUserRatingsById(userId,recipeId)));
    }
    @GetMapping(path = "/userId")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByUserId(@RequestParam("userId") Integer userId) {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getUserRatingsByUserId(userId));
    }
    @GetMapping(path = "/recipeId")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByRecipeId(@RequestParam("recipeId") Integer recipeId) {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getUserRatingsByRecipeId(recipeId));
    }

    @GetMapping(path = "/all")
    public List<VideoUserRatingsRequestDTO> getAllUserRatings(){
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getAllUserUserRatings());
    }

    @GetMapping("/by-rate")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByRate(@RequestParam("rate") int rate) {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getUserRatingsByRate(rate));
    }

    @GetMapping("/by-rate-between")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByRateBetween(@RequestParam("minRate") int minRate, @RequestParam("maxRate") int maxRate) {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getUserRatingsByRateBetween(minRate, maxRate));
    }

    @GetMapping("/by-date-range")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByDateRange(@RequestParam("startDate") Instant startDate, @RequestParam("endDate") Instant endDate) {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getUserRatingsByDateRange(startDate, endDate));
    }

    @GetMapping("/with-comments")
    public List<VideoUserRatingsRequestDTO> getRatingsWithComments() {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getRatingsWithComments());
    }

    @GetMapping("/without-comments")
    public List<VideoUserRatingsRequestDTO> getRatingsWithoutComments() {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getRatingsWithoutComments());
    }

    @GetMapping("/by-user-and-rate")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByUserAndRate(@RequestParam("userId") int userId, @RequestParam("rate") int rate) {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getUserRatingsByUserAndRate(userId, rate));
    }

    @GetMapping("/by-recipe-and-rate")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByRecipeAndRate(@RequestParam("recipeId") int recipeId, @RequestParam("rate") int rate) {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getUserRatingsByRecipeAndRate(recipeId, rate));
    }

    @GetMapping("/max-rated")
    public List<VideoUserRatingsRequestDTO> getMaxRatedRatings() {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getMaxRatedRatings());
    }

    @GetMapping("/min-rated")
    public List<VideoUserRatingsRequestDTO> getMinRatedRatings() {
        return videoUserRatingsDTOConverter.convertVideoUserRatingsEntityToDTO(videoUserRatingsService.getMinRatedRatings());
    }

}
