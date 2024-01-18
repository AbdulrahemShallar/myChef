package com.example.mychef.controller;


import com.example.mychef.service.VideoUserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class VideoUserHistoryController {

    @Autowired
    VideoUserHistoryService videoUserHistoryService;
}
