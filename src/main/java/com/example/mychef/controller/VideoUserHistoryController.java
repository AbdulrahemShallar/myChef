package com.example.mychef.controller;


import com.example.mychef.convert.VideoUserHistoryDTOConverter;
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

    final
    VideoUserHistoryDTOConverter videoUserHistoryDTOConverter;

    public VideoUserHistoryController(VideoUserHistoryService videoUserHistoryService, VideoUserHistoryDTOConverter videoUserHistoryDTOConverter) {
        this.videoUserHistoryService = videoUserHistoryService;
        this.videoUserHistoryDTOConverter = videoUserHistoryDTOConverter;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoUserHistoryEntity addUserHistory(@RequestBody VideoUserHistoryResponseDTO userHistory){
        return videoUserHistoryService.newUserHistory(videoUserHistoryDTOConverter.convertVideoUserHistoryDTOToEntity(userHistory));
    }

    // I need to do Service Class first

//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public VideoUserHistoryEntity updateUserHistoryInfo(@RequestBody VideoUserHistoryResponseDTO userHistoryUpdate,@RequestParam("id") Integer id){
//        return videoUserHistoryService.updateUserHistory(videoUserHistoryDTOConverter.convertVideoUserHistoryDTOToEntity(userHistoryUpdate),id);
//    }

    @GetMapping(path = "/Id")
    public VideoUserHistoryRequestDTO getUserHistoryById(@RequestParam("userId") Integer userId, @RequestParam("recipeId") Integer recipeId) {
        return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(videoUserHistoryService.getUserHistoryById(userId,recipeId));
    }
    @GetMapping(path = "/userId")
    public List<VideoUserHistoryRequestDTO> getUserHistoryByUserId(@RequestParam("userId") Integer userId) {
        return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(videoUserHistoryService.getUserHistoryByUserId(userId));
//                .stream()
//                .map(videoUserHistoryDTOConverter::convertVideoUserHistoryEntityToDTO)
//                .collect(Collectors.toList());
    }
    @GetMapping(path = "/recipeId")
    public List<VideoUserHistoryRequestDTO> getUserHistoryByRecipeId(@RequestParam("recipeId") Integer recipeId) {
        return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(videoUserHistoryService.getUserHistoryByRecipeId(recipeId));
    }

    @GetMapping(path = "/all")
    public List<VideoUserHistoryRequestDTO> getAllUserHistory(){
        return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(videoUserHistoryService.getAllUserHistory());
        
    }

    @GetMapping("/user/date-range")
    public List<VideoUserHistoryRequestDTO> getUserHistoryByUserAndDateRange(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(videoUserHistoryService.getUserHistoryByUserAndDateRange(userId, startDate, endDate));
    }

    @GetMapping("/recipe/date-range")
    public List<VideoUserHistoryRequestDTO> getHistoryByRecipeAndDateRange(
            @RequestParam(name = "recipeId") Integer recipeId,
            @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(videoUserHistoryService.getHistoryByRecipeAndDateRange(recipeId, startDate, endDate));
    }

    @GetMapping("/date-range")
    public List<VideoUserHistoryRequestDTO> getHistoryByDateRange(
            @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(videoUserHistoryService.getHistoryByDateRange(startDate, endDate));
    }

    @GetMapping("/latest-records")
    public List<VideoUserHistoryRequestDTO> getLatestRecords(
            @RequestParam(name = "limit") int limit) {
        return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(videoUserHistoryService.getLatestRecords(limit));
    }

    @GetMapping("/latest-history")
    public VideoUserHistoryRequestDTO getLatestHistoryForUserAndRecipe(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "recipeId") Integer recipeId) {
        return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(videoUserHistoryService.getLatestHistoryForUserAndRecipe(userId, recipeId));
    }

    @GetMapping("/latest-history-records")
    public List<VideoUserHistoryRequestDTO> getLatestHistoryRecords(
            @RequestParam(name = "limit") int limit) {
        return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(videoUserHistoryService.getLatestHistoryRecords(limit));
    }

    @GetMapping("/latest-history-for-user")
    public List<VideoUserHistoryRequestDTO> getLatestHistoryForUser(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "limit") int limit) {
        return videoUserHistoryDTOConverter.convertVideoUserHistoryEntityToDTO(videoUserHistoryService.getLatestHistoryForUser(userId, limit));
    }
}
