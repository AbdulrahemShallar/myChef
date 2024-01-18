package com.example.mychef.controller;

import com.example.mychef.service.ImageUserHistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ImageUserHistoryController {

    final
    ImageUserHistoryService imageUserHistoryService;

    public ImageUserHistoryController(ImageUserHistoryService imageUserHistoryService) {
        this.imageUserHistoryService = imageUserHistoryService;
    }


}
