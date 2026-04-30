package org.example.external.controller;

import org.example.external.dto.kp.KpResponseDto;
import org.example.external.dto.mag.MagResponseDto;
import org.example.external.dto.plasma.PlasmaResponseDto;

import org.example.external.service.kp.KpDataService;
import org.example.external.service.mag.MagDataService;
import org.example.external.service.plasma.PlasmaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpaceWeatherController {

    @Autowired
    private final KpDataService kpDataService;
    @Autowired
    private final MagDataService magDataService;
    @Autowired
    private final PlasmaDataService plasmaDataService;


    public SpaceWeatherController(KpDataService kpDataService, MagDataService magDataService, PlasmaDataService plasmaDataService) {
        this.magDataService = magDataService;
        this.plasmaDataService = plasmaDataService;
        this.kpDataService = kpDataService;
    }

    @GetMapping("/kp-data")
    public KpResponseDto getKpData() {
        return kpDataService.getKpCachedData();
    }

    @GetMapping("/mag-data")
    public MagResponseDto getMagData() {
        return magDataService.getMagCachedData();
    }

    @GetMapping("/plasma-data")
    public PlasmaResponseDto getPlasmaData() {
        return plasmaDataService.getPlasmaCachedData();
    }


}