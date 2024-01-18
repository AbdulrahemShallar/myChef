package com.example.mychef.service;

import com.example.mychef.convert.VideoUserHistoryDTOConverter;
import com.example.mychef.repository.VideoUserHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoUserHistoryService {

    final
    VideoUserHistoryDTOConverter videoUserHistoryDTOConverter;
    final
    VideoUserHistoryRepository videoUserHistoryRepository;

    public VideoUserHistoryService(VideoUserHistoryDTOConverter videoUserHistoryDTOConverter, VideoUserHistoryRepository videoUserHistoryRepository) {
        this.videoUserHistoryDTOConverter = videoUserHistoryDTOConverter;
        this.videoUserHistoryRepository = videoUserHistoryRepository;
    }
}
