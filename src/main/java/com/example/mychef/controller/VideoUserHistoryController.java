package com.example.mychef.controller;


import com.example.mychef.dto.VideoUserHistoryDTO;
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
    public VideoUserHistoryEntity addUserHistory(@RequestBody VideoUserHistoryEntity userHistory){
        return videoUserHistoryService.newUserHistory(userHistory);
    }

    // I need to do Service Class first

//    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
//    public VideoUserHistoryEntity updateUserHistoryInfo(@RequestBody VideoUserHistoryEntity userHistoryUpdate,@PathVariable(name = "id") Integer id){
//        return videoUserHistoryService.updateUserHistory(userHistoryUpdate,id);
//    }

//    @GetMapping(path = "/{id}")
//    public VideoUserHistoryDTO getUserHistoryById(@PathVariable(name = "id") Integer id) {
//        return videoUserHistoryService.getUserHistoryById(id);
//    }

    @GetMapping(path = "/all")
    public List<VideoUserHistoryDTO> getAllUserHistory(){
        return videoUserHistoryService.getAlluserUserHistory();
    }
}
