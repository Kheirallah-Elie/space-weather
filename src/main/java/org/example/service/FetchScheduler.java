package org.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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
        dataClient.fetchMagPerMin()
                .doOnError(e -> System.err.println("Mag failed: " + e.getMessage()))
                .subscribe(weatherService::updateMag);

        dataClient.fetchPlasmaPerMin()
                .doOnError(e -> System.err.println("Plasma failed: " + e.getMessage()))
                .subscribe(weatherService::updatePlasma);

        dataClient.fetchKpForecast()
                .doOnError(e -> System.err.println("KP failed: " + e.getMessage()))
                .subscribe(weatherService::updateKp);
    }
}
