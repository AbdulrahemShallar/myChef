package com.example.mychef.controller;

import com.example.mychef.convert.ImageUserHistoryDTOConverter;
import com.example.mychef.dto.requestDTO.ImageUserHistoryRequestDTO;
import com.example.mychef.service.ImageUserHistoryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/imageUserHistory")
public class ImageUserHistoryController {

    final ImageUserHistoryService imageUserHistoryService;

    final ImageUserHistoryDTOConverter imageUserHistoryDTOConverter;

    public ImageUserHistoryController(ImageUserHistoryService imageUserHistoryService,ImageUserHistoryDTOConverter imageUserHistoryDTOConverter) {
        this.imageUserHistoryService = imageUserHistoryService;
        this.imageUserHistoryDTOConverter = imageUserHistoryDTOConverter;
    }

    //    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    //    public ImageUserHistoryEntity addUserHistory(@RequestBody ImageUserHistoryResponseDTO userHistory){
//        return imageUserHistoryService.newUserHistory(imageUserHistoryDTOConverter.convertImageUserHistoryDTOToEntity(userHistory));
//    }
//
//    // I need to do Service Class first
//
//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ImageUserHistoryEntity updateUserHistoryInfo(@RequestBody ImageUserHistoryResponseDTO userHistoryUpdate,@RequestParam("id") Integer id){
//        return imageUserHistoryService.updateUserHistory(imageUserHistoryDTOConverter.convertImageUserHistoryDTOToEntity(userHistoryUpdate),id);
//    }

    @GetMapping(path = "/userAndRecipeId")
    public ImageUserHistoryRequestDTO getUserHistoryById(@RequestParam("userId") Integer userId,@RequestParam("recipeId") Integer recipeId) {
        return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(imageUserHistoryService.getUserHistoryById(userId,recipeId));
    }
    @GetMapping(path = "/userId")
    public List<ImageUserHistoryRequestDTO> getUserHistoryByUserId(@RequestParam("userId") Integer userId) {
        return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(imageUserHistoryService.getUserHistoryByUserId(userId));
    }
    @GetMapping(path = "/recipeId")
    public List<ImageUserHistoryRequestDTO> getUserHistoryByRecipeId(@RequestParam("recipeId") Integer recipeId) {
        return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(imageUserHistoryService.getUserHistoryByRecipeId(recipeId));
    }

    @GetMapping(path = "/all")
    public List<ImageUserHistoryRequestDTO> getAllUserHistory(){
        return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(imageUserHistoryService.getAllUserHistory());
    }

    @GetMapping("/user/date-range")
    public List<ImageUserHistoryRequestDTO> getUserHistoryByUserAndDateRange(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(imageUserHistoryService.getUserHistoryByUserAndDateRange(userId, startDate, endDate));
    }

    @GetMapping("/recipe/date-range")
    public List<ImageUserHistoryRequestDTO> getHistoryByRecipeAndDateRange(
            @RequestParam(name = "recipeId") Integer recipeId,
            @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(imageUserHistoryService.getHistoryByRecipeAndDateRange(recipeId, startDate, endDate));
    }

    @GetMapping("/date-range")
    public List<ImageUserHistoryRequestDTO> getHistoryByDateRange(
            @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(imageUserHistoryService.getHistoryByDateRange(startDate, endDate));
    }

    @GetMapping("/latest-records")
    public List<ImageUserHistoryRequestDTO> getLatestRecords(
            @RequestParam(name = "limit") int limit) {
        return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(imageUserHistoryService.getLatestRecords(limit));
    }

    @GetMapping("/latest-history")
    public ImageUserHistoryRequestDTO getLatestHistoryForUserAndRecipe(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "recipeId") Integer recipeId) {
        return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(imageUserHistoryService.getLatestHistoryForUserAndRecipe(userId, recipeId));
    }

    @GetMapping("/latest-history-records")
    public List<ImageUserHistoryRequestDTO> getLatestHistoryRecords(
            @RequestParam(name = "limit") int limit) {
        return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(imageUserHistoryService.getLatestHistoryRecords(limit));
    }

    @GetMapping("/latest-history-for-user")
    public List<ImageUserHistoryRequestDTO> getLatestHistoryForUser(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "limit") int limit) {
        return imageUserHistoryDTOConverter.convertImageUserHistoryEntityToDTO(imageUserHistoryService.getLatestHistoryForUser(userId, limit));
    }

}
