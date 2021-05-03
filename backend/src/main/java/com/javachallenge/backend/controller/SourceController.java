package com.javachallenge.backend.controller;

import com.javachallenge.backend.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/source", produces = MediaType.APPLICATION_JSON_VALUE)
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getSource() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(sourceService.getSource());
    }
}