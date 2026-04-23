package org.example.controller;

import org.example.service.MagDataIngestionService;
import org.example.service.PlasmaDataIngestionService;
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
    @Autowired
    private final PlasmaDataIngestionService plasmaDataIngestionService;
    @Autowired
    private final MagDataIngestionService magDataIngestionService;

    public TemporaryDataAddedController(SolarDataIngestionService solarDataIngestionService,
                                        PlasmaDataIngestionService plasmaDataIngestionService,
                                        MagDataIngestionService magDataIngestionService) {
        this.solarDataIngestionService = solarDataIngestionService;
        this.plasmaDataIngestionService = plasmaDataIngestionService;
        this.magDataIngestionService = magDataIngestionService;
    }

    @GetMapping("/add-data")
    public void addData() {
        solarDataIngestionService.ingest();
    }

    @GetMapping("/add-plasma")
    public void addPlasma() {
        plasmaDataIngestionService.ingest();
    }

    @GetMapping("/add-mag")
    public void addMag() {
        magDataIngestionService.ingest();
    }
}