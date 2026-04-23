package org.example.external.service.mag;

import org.example.external.client.DataClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FetchMagSchedulerService {
    private final DataClient dataClient;
    private final MagDataService magDataService;

    public FetchMagSchedulerService(DataClient dataClient, MagDataService magDataService) {
        this.dataClient = dataClient;
        this.magDataService = magDataService;
    }

    @Scheduled(fixedRate = 60000)
    public void updateMagData() {
        dataClient.fetchMagPerMin()
                .doOnError(e -> System.err.println("Plasma failed: " + e.getMessage()))
                .subscribe(magDataService::updateMag);
    }
}