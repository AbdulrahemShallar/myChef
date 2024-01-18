package com.example.mychef.controller;

import com.example.mychef.service.VideoRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class VideoRecipeController {

    @Autowired
    VideoRecipeService videoRecipeService;
}
