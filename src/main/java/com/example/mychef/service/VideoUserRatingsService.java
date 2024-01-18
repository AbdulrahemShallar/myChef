package com.example.mychef.service;

import com.example.mychef.convert.VideoCategoriesDTOConverter;
import com.example.mychef.convert.VideoUserRatingsDTOConverter;
import com.example.mychef.repository.VideoCategoriesRepository;
import com.example.mychef.repository.VideoUserRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoUserRatingsService {
    @Autowired
    VideoUserRatingsDTOConverter videoUserRatingsDTOConverter;
    @Autowired
    VideoUserRatingsRepository videoUserRatingsRepository;
}
