package com.example.mychef.controller;


import com.example.mychef.dto.requestDTO.VideoUserHistoryRequestDTO;
import com.example.mychef.dto.responseDTO.VideoUserHistoryResponseDTO;
import com.example.mychef.model.VideoUserHistoryEntity;
import com.example.mychef.service.VideoUserHistoryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/videoUserHistory")
public class VideoUserHistoryController {

    final
    VideoUserHistoryService videoUserHistoryService;

    public VideoUserHistoryController(VideoUserHistoryService videoUserHistoryService) {
        this.videoUserHistoryService = videoUserHistoryService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoUserHistoryEntity addUserHistory(@RequestBody VideoUserHistoryResponseDTO userHistory){
        return videoUserHistoryService.newUserHistory(userHistory);
    }

    // I need to do Service Class first

//    @PutMapping(path = "/id",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public VideoUserHistoryEntity updateUserHistoryInfo(@RequestBody VideoUserHistoryResponseDTO userHistoryUpdate,@RequestParam("id") Integer id){
//        return videoUserHistoryService.updateUserHistory(userHistoryUpdate,id);
//    }

    @GetMapping(path = "/Id")
    public VideoUserHistoryRequestDTO getUserHistoryById(@RequestParam("userId") Integer userId, @RequestParam("recipeId") Integer recipeId) {
        return videoUserHistoryService.getUserHistoryById(userId,recipeId);
    }
    @GetMapping(path = "/userId")
    public List<VideoUserHistoryRequestDTO> getUserHistoryByUserId(@RequestParam("userId") Integer userId) {
        return videoUserHistoryService.getUserHistoryByUserId(userId);
    }
    @GetMapping(path = "/recipeId")
    public List<VideoUserHistoryRequestDTO> getUserHistoryByRecipeId(@RequestParam("recipeId") Integer recipeId) {
        return videoUserHistoryService.getUserHistoryByRecipeId(recipeId);
    }

    @GetMapping(path = "/all")
    public List<VideoUserHistoryRequestDTO> getAllUserHistory(){
        return videoUserHistoryService.getAllUserHistory();
        
    }

    @GetMapping("/user/date-range")
    public List<VideoUserHistoryRequestDTO> getUserHistoryByUserAndDateRange(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return videoUserHistoryService.getUserHistoryByUserAndDateRange(userId, startDate, endDate);
    }

    @GetMapping("/recipe/date-range")
    public List<VideoUserHistoryRequestDTO> getHistoryByRecipeAndDateRange(
            @RequestParam(name = "recipeId") Integer recipeId,
            @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return videoUserHistoryService.getHistoryByRecipeAndDateRange(recipeId, startDate, endDate);
    }

    @GetMapping("/date-range")
    public List<VideoUserHistoryRequestDTO> getHistoryByDateRange(
            @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return videoUserHistoryService.getHistoryByDateRange(startDate, endDate);
    }

    @GetMapping("/latest-records")
    public List<VideoUserHistoryRequestDTO> getLatestRecords(
            @RequestParam(name = "limit") int limit) {
        return videoUserHistoryService.getLatestRecords(limit);
    }

    @GetMapping("/latest-history")
    public VideoUserHistoryRequestDTO getLatestHistoryForUserAndRecipe(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "recipeId") Integer recipeId) {
        return videoUserHistoryService.getLatestHistoryForUserAndRecipe(userId, recipeId);
    }

    @GetMapping("/latest-history-records")
    public List<VideoUserHistoryRequestDTO> getLatestHistoryRecords(
            @RequestParam(name = "limit") int limit) {
        return videoUserHistoryService.getLatestHistoryRecords(limit);
    }

    @GetMapping("/latest-history-for-user")
    public List<VideoUserHistoryRequestDTO> getLatestHistoryForUser(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "limit") int limit) {
        return videoUserHistoryService.getLatestHistoryForUser(userId, limit);
    }
}
