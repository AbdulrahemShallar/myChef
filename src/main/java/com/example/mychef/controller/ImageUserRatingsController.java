package com.example.mychef.controller;

import com.example.mychef.convert.ImageUserRatingsDTOConverter;
import com.example.mychef.dto.requestDTO.ImageUserRatingsRequestDTO;
import com.example.mychef.dto.responseDTO.ImageUserRatingsResponseDTO;
import com.example.mychef.model.ImageUserRatingsEntity;
import com.example.mychef.service.ImageUserRatingsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/imageUserRatings")
public class ImageUserRatingsController {

    final ImageUserRatingsService imageUserRatingsService;

    final ImageUserRatingsDTOConverter imageUserRatingsDTOConverter;

    public ImageUserRatingsController(ImageUserRatingsService imageUserRatingsService, ImageUserRatingsDTOConverter imageUserRatingsDTOConverter) {
        this.imageUserRatingsService = imageUserRatingsService;
        this.imageUserRatingsDTOConverter = imageUserRatingsDTOConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageUserRatingsEntity addUserRating(@RequestBody ImageUserRatingsResponseDTO userRatings){
        return imageUserRatingsService.newUserRatings(imageUserRatingsDTOConverter.convertImageUserRatingsDTOToEntity(userRatings));
    }

    // I need to do Service Class first

//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ImageUserRatingsEntity updateUserRatingsInfo(@RequestBody ImageUserRatingsResponseDTO userRatingsUpdate,@RequestParam("id") Integer id){
//        return imageUserRatingsService.updateUserHistory(imageUserRatingsDTOConverter.convertImageUserRatingsDTOToEntity(userRatingsUpdate),id);
//    }

    @GetMapping(path = "/userAndRecipeId")
    public ImageUserRatingsRequestDTO getUserRatingsById(@RequestParam("userId") Integer userId, @RequestParam("recipeId") Integer recipeId) {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getUserRatingsById(userId,recipeId));
    }
    @GetMapping(path = "/userId")
    public List<ImageUserRatingsRequestDTO> getUserRatingsByUserId(@RequestParam("userId") Integer userId) {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getUserRatingsByUserId(userId));
    }
    @GetMapping(path = "/recipeId")
    public List<ImageUserRatingsRequestDTO> getUserRatingsByRecipeId(@RequestParam("recipeId") Integer recipeId) {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getUserRatingsByRecipeId(recipeId));
    }

    @GetMapping(path = "/all")
    public List<ImageUserRatingsRequestDTO> getAllUserRatings(){
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getAllUserUserRatings());
    }

    @GetMapping("/by-rate")
    public List<ImageUserRatingsRequestDTO> getUserRatingsByRate(@RequestParam("rate") int rate) {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getUserRatingsByRate(rate));
    }

    @GetMapping("/by-rate-between")
    public List<ImageUserRatingsRequestDTO> getUserRatingsByRateBetween(@RequestParam("minRate") int minRate, @RequestParam("maxRate") int maxRate) {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getUserRatingsByRateBetween(minRate, maxRate));
    }

    @GetMapping("/by-date-range")
    public List<ImageUserRatingsRequestDTO> getUserRatingsByDateRange(@RequestParam("startDate") Instant startDate, @RequestParam("endDate") Instant endDate) {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getUserRatingsByDateRange(startDate, endDate));
    }

    @GetMapping("/with-comments")
    public List<ImageUserRatingsRequestDTO> getRatingsWithComments() {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getRatingsWithComments());
    }

    @GetMapping("/without-comments")
    public List<ImageUserRatingsRequestDTO> getRatingsWithoutComments() {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getRatingsWithoutComments());
    }

    @GetMapping("/by-user-and-rate")
    public List<ImageUserRatingsRequestDTO> getUserRatingsByUserAndRate(@RequestParam("userId") int userId, @RequestParam("rate") int rate) {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getUserRatingsByUserAndRate(userId, rate));
    }

    @GetMapping("/by-recipe-and-rate")
    public List<ImageUserRatingsRequestDTO> getUserRatingsByRecipeAndRate(@RequestParam("recipeId") int recipeId, @RequestParam("rate") int rate) {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getUserRatingsByRecipeAndRate(recipeId, rate));
    }

    @GetMapping("/max-rated")
    public List<ImageUserRatingsRequestDTO> getMaxRatedRatings() {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getMaxRatedRatings());
    }

    @GetMapping("/min-rated")
    public List<ImageUserRatingsRequestDTO> getMinRatedRatings() {
        return imageUserRatingsDTOConverter.convertImageUserRatingsEntityToDTO(imageUserRatingsService.getMinRatedRatings());
    }


}
