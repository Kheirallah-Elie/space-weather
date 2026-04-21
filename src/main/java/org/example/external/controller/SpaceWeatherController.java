package org.example.external.controller;

import org.example.external.dto.SpaceWeatherResponseDto;
import org.example.external.service.SpaceWeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpaceWeatherController {

    @Autowired
    private final SpaceWeatherService spaceWeatherService;

    public SpaceWeatherController(SpaceWeatherService spaceWeatherService) {
        this.spaceWeatherService = spaceWeatherService;
    }

    @GetMapping("/space-weather")
    public SpaceWeatherResponseDto getSpaceWeather() {
        return spaceWeatherService.getCachedData();
    }
}