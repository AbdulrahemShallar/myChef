package com.example.mychef.service;

import com.example.mychef.convert.ImageUserHistoryDTOConverter;
import com.example.mychef.repository.ImageUserHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageUserHistoryService {

    private final ImageUserHistoryDTOConverter imageUserHistoryDTOConverter;
    private final ImageUserHistoryRepository imageUserHistoryRepository;

    public ImageUserHistoryService(ImageUserHistoryDTOConverter imageUserHistoryDTOConverter, ImageUserHistoryRepository imageUserHistoryRepository) {
        this.imageUserHistoryDTOConverter = imageUserHistoryDTOConverter;
        this.imageUserHistoryRepository = imageUserHistoryRepository;
    }

}
