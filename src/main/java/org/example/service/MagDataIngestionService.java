package org.example.service;

import jakarta.transaction.Transactional;
import org.example.external.dto.mag.MagResponseDto;
import org.example.external.service.mag.MagDataService;
import org.example.mapper.MagDataMapper;
import org.example.models.MagData;
import org.example.repository.MagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagDataIngestionService {
    private final MagRepository magRepository;
    private final MagDataService client;

    private final MagDataMapper magDataMapper;

    public MagDataIngestionService(MagRepository magRepository, MagDataService client, MagDataMapper magDataMapper) {
        this.magRepository = magRepository;
        this.client = client;
        this.magDataMapper = magDataMapper;
    }

    @Transactional
    public void ingest() {

        MagResponseDto response = client.getMagCachedData();

        if (response == null) return;

        List<MagData> snapshots = magDataMapper.merge(response);

        if (snapshots.isEmpty()) return;

        magRepository.saveAll(snapshots);
    }
}
