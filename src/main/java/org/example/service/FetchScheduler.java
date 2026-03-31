package org.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FetchScheduler {
    private final DataClient dataClient;
    private final SpaceWeatherService weatherService;

    public FetchScheduler(DataClient dataClient, SpaceWeatherService weatherService) {
        this.dataClient = dataClient;
        this.weatherService = weatherService;
    }

    @Scheduled(fixedRate = 60000)
    public void updateSpaceWeather() {
        Mono.zip(
                dataClient.fetchMagPerMin(),
                dataClient.fetchPlasmaPerMin(),
                dataClient.fetchKpForecast()
        ).subscribe(tuple -> {
            weatherService.updateCache(tuple.getT1(), tuple.getT2(), tuple.getT3());
        }, error -> {
            System.err.println("Failed to fetch NOAA data: " + error.getMessage());
        });
    }
}
