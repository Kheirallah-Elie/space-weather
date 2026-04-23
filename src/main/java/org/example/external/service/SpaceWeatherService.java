package org.example.external.service;

import org.example.external.dto.kp.KpDataDto;
import org.example.external.dto.mag.MagDataDto;
import org.example.external.dto.plasma.PlasmaDataDto;
import org.example.external.dto.SpaceWeatherResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceWeatherService {

    private List<MagDataDto> magCache;
    private List<PlasmaDataDto> plasmaCache;
    private List<KpDataDto> kpCache;

    public synchronized void updateMag(List<MagDataDto> mag) {
        this.magCache = mag;
    }

    public synchronized void updatePlasma(List<PlasmaDataDto> plasma) {
        this.plasmaCache = plasma;
    }

    public synchronized void updateKp(List<KpDataDto> kp) {
            this.kpCache = kp;
    }

    public SpaceWeatherResponseDto getCachedData() {
        return new SpaceWeatherResponseDto(
                magCache,
                plasmaCache,
                kpCache
        );
    }
}