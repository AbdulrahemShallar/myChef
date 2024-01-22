package com.example.mychef.controller;

import com.example.mychef.dto.ImageUserHistoryDTO;
import com.example.mychef.model.ImageUserHistoryEntity;
import com.example.mychef.service.ImageUserHistoryService;
import org.springframework.http.MediaType;
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

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageUserHistoryEntity addUserHistory(@RequestBody ImageUserHistoryEntity userHistory){
        return imageUserHistoryService.newUserHistory(userHistory);
    }

    // I need to do Service Class first

//    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ImageUserHistoryEntity updateUserHistoryInfo(@RequestBody ImageUserHistoryEntity userHistoryUpdate,@PathVariable(name = "id") Integer id){
//        return imageUserHistoryService.updateUserHistory(userHistoryUpdate,id);
//    }

//    @GetMapping(path = "/{id}")
//    public ImageUserHistoryDTO getUserHistoryById(@PathVariable(name = "id") Integer id) {
//        return imageUserHistoryService.getUserHistoryById(id);
//    }

    @GetMapping(path = "/all")
    public List<ImageUserHistoryDTO> getAllUserHistory(){
        return imageUserHistoryService.getAllUserHistory();
    }


}
