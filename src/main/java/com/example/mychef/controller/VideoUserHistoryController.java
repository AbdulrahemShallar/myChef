package com.example.mychef.controller;


import com.example.mychef.dto.requestDTO.VideoUserHistoryRequestDTO;
import com.example.mychef.dto.responseDTO.VideoUserHistoryResponseDTO;
import com.example.mychef.model.VideoUserHistoryEntity;
import com.example.mychef.service.VideoUserHistoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videoUserHistory")
public class VideoUserHistoryController {

    final
    VideoUserHistoryService videoUserHistoryService;

    public VideoUserHistoryController(VideoUserHistoryService videoUserHistoryService) {
        this.videoUserHistoryService = videoUserHistoryService;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public VideoUserHistoryEntity addUserHistory(@RequestBody VideoUserHistoryResponseDTO userHistory){
        return videoUserHistoryService.newUserHistory(userHistory);
    }

    // I need to do Service Class first

//    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
//    public VideoUserHistoryEntity updateUserHistoryInfo(@RequestBody VideoUserHistoryResponseDTO userHistoryUpdate,@PathVariable(name = "id") Integer id){
//        return videoUserHistoryService.updateUserHistory(userHistoryUpdate,id);
//    }

    @GetMapping(path = "/{userId}/{recipeId}")
    public VideoUserHistoryRequestDTO getUserHistoryById(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "recipeId") Integer recipeId) {
        return videoUserHistoryService.getUserHistoryById(userId,recipeId);
    }
    @GetMapping(path = "/{userId}")
    public List<VideoUserHistoryRequestDTO> getUserHistoryByUserId(@PathVariable(name = "userId") Integer userId) {
        return videoUserHistoryService.getUserHistoryByUserId(userId);
    }
    @GetMapping(path = "/{recipeId}")
    public List<VideoUserHistoryRequestDTO> getUserHistoryByRecipeId(@PathVariable(name = "recipeId") Integer recipeId) {
        return videoUserHistoryService.getUserHistoryByRecipeId(recipeId);
    }

    @GetMapping(path = "/all")
    public List<VideoUserHistoryRequestDTO> getAllUserHistory(){
        return videoUserHistoryService.getAllUserHistory();
    }
}
