package org.example.controller;

import org.example.service.SolarDataIngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TemporaryDataAddedController {
    @Autowired
    private final SolarDataIngestionService solarDataIngestionService;

    public TemporaryDataAddedController(SolarDataIngestionService solarDataIngestionService) {
        this.solarDataIngestionService = solarDataIngestionService;
    }

    @GetMapping("/add-data")
    public void addData() {
        solarDataIngestionService.ingest();
    }
}