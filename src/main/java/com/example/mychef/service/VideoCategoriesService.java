package com.example.mychef.service;

import com.example.mychef.convert.VideoCategoriesDTOConverter;
import com.example.mychef.repository.VideoCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoCategoriesService {

    @Autowired
    VideoCategoriesDTOConverter videoCategoriesDTOConverter;
    @Autowired
    VideoCategoriesRepository videoCategoriesRepository;
}
