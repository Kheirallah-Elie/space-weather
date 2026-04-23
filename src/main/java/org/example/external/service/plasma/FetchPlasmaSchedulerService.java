package org.example.external.service.plasma;

import org.example.external.client.DataClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FetchPlasmaSchedulerService {
    private final DataClient dataClient;
    private final PlasmaDataService plasmaDataService;

    public FetchPlasmaSchedulerService(DataClient dataClient, PlasmaDataService plasmaDataService) {
        this.dataClient = dataClient;
        this.plasmaDataService = plasmaDataService;
    }

    @Scheduled(fixedRate = 60000)
    public void updatePlasmaData() {
        dataClient.fetchPlasmaPerMin()
                .doOnError(e -> System.err.println("Plasma failed: " + e.getMessage()))
                .subscribe(plasmaDataService::updatePlasma);
    }
}
