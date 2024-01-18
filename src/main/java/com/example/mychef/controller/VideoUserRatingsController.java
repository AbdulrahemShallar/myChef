package com.example.mychef.controller;

import com.example.mychef.service.VideoUserRatingsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class VideoUserRatingsController {

    final
    VideoUserRatingsService videoUserRatingsService;

    public VideoUserRatingsController(VideoUserRatingsService videoUserRatingsService) {
        this.videoUserRatingsService = videoUserRatingsService;
    }
}
