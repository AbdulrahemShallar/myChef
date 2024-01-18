package com.example.mychef.service;

import com.example.mychef.convert.VideoUserRatingsDTOConverter;
import com.example.mychef.repository.VideoUserRatingsRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoUserRatingsService {
    final
    VideoUserRatingsDTOConverter videoUserRatingsDTOConverter;
    final
    VideoUserRatingsRepository videoUserRatingsRepository;

    public VideoUserRatingsService(VideoUserRatingsDTOConverter videoUserRatingsDTOConverter, VideoUserRatingsRepository videoUserRatingsRepository) {
        this.videoUserRatingsDTOConverter = videoUserRatingsDTOConverter;
        this.videoUserRatingsRepository = videoUserRatingsRepository;
    }
}
