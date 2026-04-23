package org.example.external.service.plasma;

import org.example.external.dto.plasma.PlasmaDataDto;
import org.example.external.dto.plasma.PlasmaResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlasmaDataService {
    private List<PlasmaDataDto> plasmaCache;

    public synchronized void updatePlasma(List<PlasmaDataDto> plasma) {
        this.plasmaCache = plasma;
    }

    public PlasmaResponseDto getPlasmaCachedData() {
        return new PlasmaResponseDto(plasmaCache);
    }
}