package com.example.mychef.controller;


import com.example.mychef.service.VideoUserHistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class VideoUserHistoryController {

    final
    VideoUserHistoryService videoUserHistoryService;

    public VideoUserHistoryController(VideoUserHistoryService videoUserHistoryService) {
        this.videoUserHistoryService = videoUserHistoryService;
    }
}
