package com.example.mychef.controller;

import com.example.mychef.dto.ImageUserRatingsDTO;
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
    public ImageUserRatingsEntity addUserRating(@RequestBody ImageUserRatingsEntity userRatings){
        return imageUserRatingsService.newUserRatings(userRatings);
    }

    // I need to do Service Class first

//    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ImageUserRatingsEntity updateUserRatingsInfo(@RequestBody ImageUserRatingsEntity userRatingsUpdate,@PathVariable(name = "id") Integer id){
//        return imageUserRatingsService.updateUserHistory(userRatingsUpdate,id);
//    }

//    @GetMapping(path = "/{id}")
//    public ImageUserRatingsDTO getUserRatingsById(@PathVariable(name = "id") Integer id) {
//        return imageUserRatingsService.getUserRatingsById(id);
//    }

    @GetMapping(path = "/all")
    public List<ImageUserRatingsDTO> getAllUserRatings(){
        return imageUserRatingsService.getAllUserUserRatings();
    }

}
