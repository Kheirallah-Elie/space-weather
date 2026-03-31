package org.example.controller;

import org.example.dto.CombinedDataDto;
import org.example.service.SpaceWeatherService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpaceWeatherController {

    private final SpaceWeatherService weatherService;

    public SpaceWeatherController(SpaceWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/space-weather")
    public CombinedDataDto getSpaceWeather() {
        return weatherService.getCachedData();
    }
}