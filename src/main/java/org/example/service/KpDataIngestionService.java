package org.example.service;

import org.example.external.service.kp.KpDataService;
import org.example.repository.KpRepository;
import org.springframework.stereotype.Service;

@Service
public class KpDataIngestionService {
    private final KpRepository kpRepository;
    private final KpDataService client;

    public KpDataIngestionService(KpRepository kpRepository, KpDataService client) {
        this.kpRepository = kpRepository;
        this.client = client;
    }
}
