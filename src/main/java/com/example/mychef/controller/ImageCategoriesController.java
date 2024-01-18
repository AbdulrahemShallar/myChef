package com.example.mychef.controller;


import com.example.mychef.service.ImageCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ImageCategoriesController {

    @Autowired
    ImageCategoriesService imageCategoriesService;
}
