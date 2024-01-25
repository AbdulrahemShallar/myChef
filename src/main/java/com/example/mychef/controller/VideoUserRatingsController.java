package com.example.mychef.controller;

import com.example.mychef.dto.requestDTO.VideoUserRatingsRequestDTO;
import com.example.mychef.dto.responseDTO.VideoUserRatingsResponseDTO;
import com.example.mychef.model.VideoUserRatingsEntity;
import com.example.mychef.service.VideoUserRatingsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videoUserRatings")
public class VideoUserRatingsController {

    final
    VideoUserRatingsService videoUserRatingsService;

    public VideoUserRatingsController(VideoUserRatingsService videoUserRatingsService) {
        this.videoUserRatingsService = videoUserRatingsService;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoUserRatingsEntity addUserRating(@RequestBody VideoUserRatingsResponseDTO userRatings){
        return videoUserRatingsService.newUserRatings(userRatings);
    }

    // I need to do Service Class first

//    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
//    public VideoUserRatingsEntity updateUserRatingsInfo(@RequestBody VideoUserRatingsResponseDTO userRatingsUpdate,@PathVariable(name = "id") Integer id){
//        return videoUserRatingsService.updateUserHistory(userRatingsUpdate,id);
//    }

    @GetMapping(path = "/{userId}/{recipeId}")
    public VideoUserRatingsRequestDTO getUserRatingsById(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "recipeId") Integer recipeId) {
        return videoUserRatingsService.getUserRatingsById(userId,recipeId);
    }
    @GetMapping(path = "/{userId}")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByUserId(@PathVariable(name = "userId") Integer userId) {
        return videoUserRatingsService.getUserRatingsByUserId(userId);
    }
    @GetMapping(path = "/{recipeId}")
    public List<VideoUserRatingsRequestDTO> getUserRatingsByRecipeId(@PathVariable(name = "recipeId") Integer recipeId) {
        return videoUserRatingsService.getUserRatingsByRecipeId(recipeId);
    }

    @GetMapping(path = "/all")
    public List<VideoUserRatingsRequestDTO> getAllUserRatings(){
        return videoUserRatingsService.getAllUserUserRatings();
    }

}
