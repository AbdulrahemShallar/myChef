package com.example.mychef.service;

import com.example.mychef.convert.ImageUserHistoryDTOConverter;
import com.example.mychef.repository.ImageUserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageUserRatingsService {
    @Autowired ImageUserHistoryDTOConverter imageUserHistoryDTOConverter;
    @Autowired
    ImageUserHistoryRepository imageUserHistoryRepository;
}
