package org.example.external.service.kp;

import org.example.external.client.DataClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FetchKpSchedulerService {
    private final DataClient dataClient;
    private final KpDataService kpDataService;

    public FetchKpSchedulerService(DataClient dataClient, KpDataService kpDataService) {
        this.dataClient = dataClient;
        this.kpDataService = kpDataService;
    }

    @Scheduled(fixedRate = 60000)
    public void updateKpData() {
        dataClient.fetchKpForecast()
                .doOnError(e -> System.err.println("Kp failed: " + e.getMessage()))
                .subscribe(kpDataService::updateKp);
    }
}