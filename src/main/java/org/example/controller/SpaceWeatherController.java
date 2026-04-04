package org.example.controller;

import org.example.dto.SpaceWeatherResponseDto;
import org.example.service.SpaceWeatherService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpaceWeatherController {

    private final SpaceWeatherService spaceWeatherService;

    public SpaceWeatherController(SpaceWeatherService spaceWeatherService) {
        this.spaceWeatherService = spaceWeatherService;
    }

    @GetMapping("/api/space-weather")
    public SpaceWeatherResponseDto getSpaceWeather() {
        return spaceWeatherService.getCachedData();
    }
}