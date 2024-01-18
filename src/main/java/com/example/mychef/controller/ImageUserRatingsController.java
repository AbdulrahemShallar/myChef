package com.example.mychef.controller;

import com.example.mychef.service.ImageUserRatingsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ImageUserRatingsController {

    final
    ImageUserRatingsService imageUserRatingsService;

    public ImageUserRatingsController(ImageUserRatingsService imageUserRatingsService) {
        this.imageUserRatingsService = imageUserRatingsService;
    }
}
