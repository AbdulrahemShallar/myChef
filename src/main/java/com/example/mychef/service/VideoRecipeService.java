package com.example.mychef.service;


import com.example.mychef.convert.VideoRecipeDTOConverter;
import com.example.mychef.repository.VideoRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoRecipeService {

    @Autowired
    VideoRecipeDTOConverter videoRecipeDTOConverter;
    @Autowired
    VideoRecipeRepository videoRecipeRepository;
}
