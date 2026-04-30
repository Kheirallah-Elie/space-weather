package org.example.controller;

import org.example.service.KpDataIngestionService;
import org.example.service.MagDataIngestionService;
import org.example.service.PlasmaDataIngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TemporaryDataAddedController {
    @Autowired
    private final PlasmaDataIngestionService plasmaDataIngestionService;
    @Autowired
    private final MagDataIngestionService magDataIngestionService;
    @Autowired
    private final KpDataIngestionService kpDataIngestionService;

    public TemporaryDataAddedController(PlasmaDataIngestionService plasmaDataIngestionService,
                                        MagDataIngestionService magDataIngestionService,
                                        KpDataIngestionService kpDataIngestionService) {
        this.plasmaDataIngestionService = plasmaDataIngestionService;
        this.magDataIngestionService = magDataIngestionService;
        this.kpDataIngestionService = kpDataIngestionService;
    }


    @GetMapping("/add-plasma")
    public void addPlasma() {
        plasmaDataIngestionService.ingest();
    }

    @GetMapping("/add-mag")
    public void addMag() {
        magDataIngestionService.ingest();
    }

    @GetMapping("/add-kp")
    public void addKp() {
        kpDataIngestionService.ingest();
    }
}