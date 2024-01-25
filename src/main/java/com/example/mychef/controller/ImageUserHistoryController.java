package com.example.mychef.controller;

import com.example.mychef.dto.requestDTO.ImageUserHistoryRequestDTO;
import com.example.mychef.service.ImageUserHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imageUserHistory")
public class ImageUserHistoryController {

    final
    ImageUserHistoryService imageUserHistoryService;

    public ImageUserHistoryController(ImageUserHistoryService imageUserHistoryService) {
        this.imageUserHistoryService = imageUserHistoryService;
    }

//    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ImageUserHistoryEntity addUserHistory(@RequestBody ImageUserHistoryResponseDTO userHistory){
//        return imageUserHistoryService.newUserHistory(userHistory);
//    }

    // I need to do Service Class first

//    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ImageUserHistoryEntity updateUserHistoryInfo(@RequestBody ImageUserHistoryResponseDTO userHistoryUpdate,@PathVariable(name = "id") Integer id){
//        return imageUserHistoryService.updateUserHistory(userHistoryUpdate,id);
//    }

    @GetMapping(path = "/{userId}/{recipeId}")
    public ImageUserHistoryRequestDTO getUserHistoryById(@PathVariable(name = "userId") Integer userId,@PathVariable(name = "recipeId") Integer recipeId) {
        return imageUserHistoryService.getUserHistoryById(userId,recipeId);
    }
    @GetMapping(path = "/{userId}")
    public List<ImageUserHistoryRequestDTO> getUserHistoryByUserId(@PathVariable(name = "userId") Integer userId) {
        return imageUserHistoryService.getUserHistoryByUserId(userId);
    }
    @GetMapping(path = "/{recipeId}")
    public List<ImageUserHistoryRequestDTO> getUserHistoryByRecipeId(@PathVariable(name = "recipeId") Integer recipeId) {
        return imageUserHistoryService.getUserHistoryByRecipeId(recipeId);
    }

    @GetMapping(path = "/all")
    public List<ImageUserHistoryRequestDTO> getAllUserHistory(){
        return imageUserHistoryService.getAllUserHistory();
    }


}
