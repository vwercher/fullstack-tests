package com.javachallenge.backend.service.impl;

import com.javachallenge.backend.service.SourceService;
import org.springframework.stereotype.Service;

@Service
public class SourceServiceImpl implements SourceService {

    public String getSource() {
        return "https://github.com/vwercher/java-challenge";
    }
}
