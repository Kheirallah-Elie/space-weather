package org.example.service;

import jakarta.transaction.Transactional;
import org.example.external.dto.plasma.PlasmaResponseDto;
import org.example.external.service.plasma.PlasmaDataService;
import org.example.mapper.PlasmaDataMapper;
import org.example.models.PlasmaData;
import org.example.repository.PlasmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlasmaDataIngestionService {
    private final PlasmaRepository plasmaRepository;
    private final PlasmaDataService client;
    private final PlasmaDataMapper plasmaDataMapper;

    public PlasmaDataIngestionService(PlasmaRepository plasmaRepository, PlasmaDataService client, PlasmaDataMapper plasmaDataMapper) {
        this.plasmaRepository = plasmaRepository;
        this.client = client;
        this.plasmaDataMapper = plasmaDataMapper;
    }

    @Transactional
    public void ingest() {

        PlasmaResponseDto response = client.getPlasmaCachedData();

        if (response == null) return;

        List<PlasmaData> snapshots = plasmaDataMapper.merge(response);

        if (snapshots.isEmpty()) return;

        plasmaRepository.saveAll(snapshots);
    }
}
