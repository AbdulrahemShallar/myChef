package com.example.mychef.controller;

import com.example.mychef.dto.requestDTO.ImageUserRatingsRequestDTO;
import com.example.mychef.dto.responseDTO.ImageUserRatingsResponseDTO;
import com.example.mychef.model.ImageUserRatingsEntity;
import com.example.mychef.service.ImageUserRatingsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imageUserRatings")
public class ImageUserRatingsController {

    final
    ImageUserRatingsService imageUserRatingsService;

    public ImageUserRatingsController(ImageUserRatingsService imageUserRatingsService) {
        this.imageUserRatingsService = imageUserRatingsService;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageUserRatingsEntity addUserRating(@RequestBody ImageUserRatingsResponseDTO userRatings){
        return imageUserRatingsService.newUserRatings(userRatings);
    }

    // I need to do Service Class first

//    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ImageUserRatingsEntity updateUserRatingsInfo(@RequestBody ImageUserRatingsResponseDTO userRatingsUpdate,@PathVariable(name = "id") Integer id){
//        return imageUserRatingsService.updateUserHistory(userRatingsUpdate,id);
//    }

    @GetMapping(path = "/{userId}/{recipeId}")
    public ImageUserRatingsRequestDTO getUserRatingsById(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "recipeId") Integer recipeId) {
        return imageUserRatingsService.getUserRatingsById(userId,recipeId);
    }
    @GetMapping(path = "/{userId}")
    public List<ImageUserRatingsRequestDTO> getUserRatingsByUserId(@PathVariable(name = "userId") Integer userId) {
        return imageUserRatingsService.getUserRatingsByUserId(userId);
    }
    @GetMapping(path = "/{recipeId}")
    public List<ImageUserRatingsRequestDTO> getUserRatingsByRecipeId(@PathVariable(name = "recipeId") Integer recipeId) {
        return imageUserRatingsService.getUserRatingsByRecipeId(recipeId);
    }

    @GetMapping(path = "/all")
    public List<ImageUserRatingsRequestDTO> getAllUserRatings(){
        return imageUserRatingsService.getAllUserUserRatings();
    }

}
