package com.example.mychef.service;

import com.example.mychef.convert.VideoUserHistoryDTOConverter;
import com.example.mychef.repository.VideoUserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoUserHistoryService {

    @Autowired
    VideoUserHistoryDTOConverter videoUserHistoryDTOConverter;
    @Autowired
    VideoUserHistoryRepository videoUserHistoryRepository;
}
