package com.example.mychef.controller;

import com.example.mychef.dto.VideoUserRatingsDTO;
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
    public VideoUserRatingsEntity addUserRating(@RequestBody VideoUserRatingsEntity userRatings){
        return videoUserRatingsService.newUserRatings(userRatings);
    }

    // I need to do Service Class first

//    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
//    public VideoUserRatingsEntity updateUserRatingsInfo(@RequestBody VideoUserRatingsEntity userRatingsUpdate,@PathVariable(name = "id") Integer id){
//        return videoUserRatingsService.updateUserHistory(userRatingsUpdate,id);
//    }

//    @GetMapping(path = "/{id}")
//    public VideoUserRatingsDTO getUserRatingsById(@PathVariable(name = "id") Integer id) {
//        return videoUserRatingsService.getUserRatingsById(id);
//    }

    @GetMapping(path = "/all")
    public List<VideoUserRatingsDTO> getAllUserRatings(){
        return videoUserRatingsService.getAllUserUserRatings();
    }

}
