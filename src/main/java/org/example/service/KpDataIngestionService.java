package org.example.service;

import jakarta.transaction.Transactional;
import org.example.external.dto.kp.KpResponseDto;
import org.example.external.service.kp.KpDataService;
import org.example.mapper.KpDataMapper;
import org.example.models.KpData;
import org.example.repository.KpRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KpDataIngestionService {
    private final KpRepository kpRepository;
    private final KpDataService client;
    private final KpDataMapper kpDataMapper;

    public KpDataIngestionService(KpRepository kpRepository, KpDataService client, KpDataMapper kpDataMapper) {
        this.kpRepository = kpRepository;
        this.client = client;
        this.kpDataMapper = kpDataMapper;
    }

    @Transactional
    public void ingest() {

        KpResponseDto response = client.getKpCachedData();
        if (response == null) return;

        List<KpData> snapshots = kpDataMapper.merge(response);
        if (snapshots.isEmpty()) return;

        for (KpData data : snapshots) {
            kpRepository.upsert(
                    data.getTimestamp(),
                    data.getKp(),
                    data.getType(),
                    data.getNoaaScale()
            );
        }
    }
}
