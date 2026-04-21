package org.example.service;

import jakarta.transaction.Transactional;
import org.example.external.dto.SpaceWeatherResponseDto;
import org.example.external.service.SpaceWeatherService;
import org.example.mapper.SolarDataMapper;
import org.example.models.SolarSnapshot;
import org.example.repository.SolarSnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolarDataIngestionService {

    private final SolarSnapshotRepository repository;
    private final SpaceWeatherService client;
    private final SolarDataMapper mapper;

    public SolarDataIngestionService(SolarSnapshotRepository repository,
                                     SpaceWeatherService client,
                                     SolarDataMapper mapper) {
        this.repository = repository;
        this.client = client;
        this.mapper = mapper;
    }

    @Transactional
    public void ingest() {

        SpaceWeatherResponseDto response = client.getCachedData();

        if (response == null) return;

        List<SolarSnapshot> snapshots = mapper.merge(response);

        if (snapshots.isEmpty()) return;

        repository.saveAll(snapshots);
    }
}